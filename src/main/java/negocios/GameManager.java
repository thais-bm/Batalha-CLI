package negocios;
import negocios.tipos_item.ItensConsumiveis.*;
import negocios.tipos_item.ItensDef.EscudoRuim;
import negocios.tipos_item.ItemConsumivel;
import negocios.tipos_item.ItensAtk.*;
import persistencia.SaveManager;
import telas.ScreenManager;
import telas.Sprite;
import telas.SpritesInterface;
import utilidades.ComandosUteis;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Optional; // para criar um opcional pro load

// Acho que as batalhas deviam ficar aqui dentro
// O Main manipular apenas o gameManager 1-1

public class GameManager {
    private boolean gameLoop = false;
    private Batalha batalha;
    private ScreenManager tela;

    // sem metodos
    public GameManager(){
        this.batalha = null;
        this.tela = new ScreenManager();
    }

    public GameManager(Batalha batalha, ScreenManager tela) {
        this.batalha = batalha;
        this.tela = tela;
    }
    //Getters e Setters

    public Batalha getBatalha() {
        return batalha;
    }
    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }
    public void setTela(ScreenManager tela) {
        this.tela = tela;
    }

    //Métodos
    public void iniciarBatalha(Batalha batalha) {
        batalha.setSeAtivo(true);
        System.out.println("Batalha iniciada com sucesso!");
        System.out.println(batalha.getNumTurnos() + " turnos ao total");
    }

    public void battleSpriteLoad(Batalha batalha, String... args) {
        tela.drawBattleScreen(batalha.getPersonagem(), batalha.getInimigo(), args);
        if (args.length > 0) {
            
            if (args[0].equals(batalha.getInimigo().getNome() + " morreu, prosseguir")) {
                new Sprite(Spritesheets.getVitoria(), 11, 45).draw(tela.getScreen());
            }
        }
        tela.renderScreen();
    }

    public void controleTurno(Batalha batalha) {
        if (batalha.getSeAtivo()) {
            while (batalha.getNumTurnos() > 0 && batalha.getSeAtivo()) {

                System.out.println("Turno atual: " + batalha.getNumTurnos());
                battleSpriteLoad(batalha, " 1 - Atacar", " 2 - Defender", " 3 - Inventario", " 4 - Nao sei");



                if(batalha.getPersonagem().getVida() <= 0){
                    morreu();
                }
                batalha.turnoJogador();

                //Conseguiu derrotar o inimigo
                if (batalha.getInimigo().getVida() <= 0) {
                    battleSpriteLoad(batalha, " " + batalha.getInimigo().getNome() + " morreu", "pressione Enter para prosseguir");
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine(); // isso pode desbugar o enter
                    derrotouInimigo();
                    break;
                }

                System.out.println("Turno atual: " + batalha.getNumTurnos());
                batalha.turnoInimigo();

                if (batalha.getInimigo().getVida() <= 0) {
                    derrotouInimigo();
                    break;
                }
                //Não conseguiu derrotar no numero de turnos dados
                if(batalha.getNumTurnos() <= 0 && batalha.getInimigo().getVida() > 0) {
                    perdeu();
                    break;
                }

            }
        }
    }

    public void derrotouInimigo() {
        batalha.setSeAtivo(false);
        System.out.println("Batalha acabou!");
        
        newItemSet(batalha.getPersonagem().getSorte());
    }

    public void perdeu(){
        batalha.setSeAtivo(false);
        System.out.println("Batalha acabou!");
        System.out.println("Não conseguiu ganhar no numero de turnos determinados ");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        while (opcao != 1) {
            System.out.println("Aperte 1 para voltar ao menu: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if (opcao != 1) {
                    System.out.println("Número inválido, digite novamente.");
                }
            } else {
                System.out.println("Entrada inválida, digite um número.");
            }
        }
        if (opcao == 1) {
            gameLoop();
        }
    }

    public void morreu(){
        batalha.setSeAtivo(false);
        System.out.println("Batalha acabou!");
        System.out.println("Você morreu!");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        while (opcao != 1) {
            System.out.println("Aperte 1 para voltar ao menu: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if (opcao != 1) {
                    System.out.println("Número inválido, digite novamente: ");
                }
            } else {
                System.out.println("Entrada inválida, digite um número: ");

            }
        }
        if (opcao == 1) {
            gameLoop();
        }



    }

    public void manusearInventario(){
        tela.drawInventoryMain(batalha.getInventario(), "(1-8) - Selecionar item                          ", "0 - Fechar inventário                            ");
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        while (true) {
            try {
                entrada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (((entrada > 1 || entrada < 8) && batalha.getInventario().getItem(entrada) != null) || entrada == 0) {
                break;
            }
        } 
        if (entrada == 0) return;
        manusearInventarioItemSelecionado(entrada);
    }

    private void manusearInventarioItemSelecionado(int index) {
        Item item = batalha.getInventario().getItem(index);
        ItemConsumivel itemconsumivel;
        boolean consumivel = (item instanceof ItemConsumivel);
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        if (consumivel) {
            itemconsumivel = (ItemConsumivel) item;
            tela.drawInventoryItemSelected(batalha.getInventario(), index, " 1 - Remover            2 - Usar              3 - Reposicionar    ", " 0 - Voltar                                                       ");
            tela.renderScreen();
            while (entrada < 0 || entrada > 3) {
                try {
                    entrada = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {}
            }
            switch(entrada) {
                case 1:
                    batalha.getInventario().removeItem(index);
                    break;
                case 2:
                    itemconsumivel.Efeito(batalha.getPersonagem());
                    break;
                case 3:
                    manusearInventarioSwap(index);
                    break;
            }
        } else {
            tela.drawInventoryItemSelected(batalha.getInventario(), index, " 1 - Remover                                  2 - Reposicionar    ", " 0 - Voltar                                                       ");
            tela.renderScreen();
            while (entrada < 0 || entrada > 2) {
                try {
                    entrada = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {}
            }
            switch(entrada) {
                case 1:
                    batalha.getInventario().removeItem(index);
                    break;
                case 2:
                    manusearInventarioSwap(index);
                    break;
            }
        }
        manusearInventario();
    }

    private void manusearInventarioSwap(int index) {
        tela.drawInventoryMain(batalha.getInventario(), " (1-8) - Selecionar item para trocar posição                      ", " 0 - Cancelar                                                     ");
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        while (true) {
            try {
                entrada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada > 0 || entrada < 8) {
                break;
            }
        }
        if (entrada == 0) return;
        Item item1 = batalha.getInventario().getItem(index);
        Item item2 = batalha.getInventario().getItem(entrada);
        batalha.getInventario().setItem(item1, entrada);
        if (item2 != null) {
            batalha.getInventario().setItem(item2, index);
        } else {
            batalha.getInventario().removeItem(index);
        }
    }

    public void inventarioCheioAddItem(Item newitem) {
        tela.drawInventoryMain(batalha.getInventario(), " Inventário cheio ", " (1-8) - Escolher item para comparar                                    0 - Voltar ");
        String string1 = "| Escolha um item para substituir por " + newitem.getNome() + " |";
        String string2 = "X";
        for (int i = 2; i < string1.length(); i++) string2 += "-";
        string2 += "X";
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add(string1);
        spritelist.add(string2);
        Sprite aviso = new Sprite(spritelist, 0, (int) (90 - string1.length())/2);
        aviso.draw(tela.getScreen());
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        int entrada2 = -1;
        while (true) {
            try {
                entrada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada > 0 || entrada < 8) {
                break;
            }
        }
        if (entrada == 0) return;
        tela.drawInventorySwap(batalha.getInventario(), entrada, newitem, "1 - Aceitar novo item e descartar antigo                     ", "0 - Cancelar                                                 ");
        tela.renderScreen();
        while (true) {
            try {
                entrada2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada2 == 1) {
                batalha.getInventario().setItem(newitem, entrada);
                manusearInventario();
                break;
            }
            if (entrada2 == 0) {
                inventarioCheioAddItem(newitem);
                break;
            }
            
        }

    }
    public void newItemSet() {
        newItemSet(0);
    }
    public void newItemSet(int fatorsorte) {
        Item item1 = InvHelper.getRandomItemByRarity(fatorsorte);
        Item item2 = InvHelper.getRandomItemByRarity(fatorsorte);
        while (item2.equals(item1)) item2 = InvHelper.getRandomItemByRarity(fatorsorte);
        Item item3 = InvHelper.getRandomItemByRarity(fatorsorte);
        while (item3.equals(item1) || item3.equals(item2)) item3 = InvHelper.getRandomItemByRarity(fatorsorte);
        newItemChoice(item1, item2, item3);
    }
    public void newItemChoice(Item item1, Item item2, Item item3) {
        tela.drawNewItemsScreen(item1, item2, item3, "(1-3) - Escolher novo item              4 - Checar inventario", "0 - Pular                                                    ");
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        int entrada2 = -1;
        while (true) {
            try {
                entrada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada > 0 || entrada < 4) {
                break;
            }
        }
        Item selecteditem = null;
        switch(entrada) {
            case 1:
                selecteditem = item1;
                break;
            case 2:
                selecteditem = item2;
                break;
            case 3:
                selecteditem = item3;
                break;
        }
        if (4 > entrada && entrada > 0) {
        tela.drawNewItemsScreen(item1, item2, item3, "1 - Aceitar item                             0 - Voltar");
            popUpInfo(selecteditem);
            tela.renderScreen();
            while (true) {
                try {
                    entrada2 = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {}
                if (entrada2 == 0 || entrada2 == 1) {
                    break;
                }
            }
            if (entrada2 == 0) {
                newItemChoice(item1, item2, item3);
                return;
            }
        }
        switch(entrada) {
            case 0:
                break;
            case 1:
            case 2:
            case 3:
                if (getBatalha().getInventario().isFull()) {
                    inventarioCheioAddItem(selecteditem);
                } else {
                    getBatalha().getInventario().addItem(selecteditem);
                }
                break;
            case 4:
                manusearInventario();
                newItemChoice(item1, item2, item3);
                break;
        }
    }
    private void popUpInfo (Item item) {
        Sprite popup = new Sprite(SpritesInterface.getTextBox(), 12, 19);
        popup.draw(tela.getScreen());
        ArrayList<String> desc = new ArrayList<String>();
        for (String i : item.getDescricao()) desc.add(ComandosUteis.autocentraliza(i, 48));
        Sprite descsprite = new Sprite(desc, 13, 21);
        descsprite.draw(tela.getScreen());
    }


    public void reiniciarBatalha() {
        System.out.println("Turno reinciado!");
        batalha.setSeAtivo(false);
    }



    // MENU PRINCIPAL
    public void start_new_game(Optional<Jogador> jog) {


        System.out.println("Comecou novo jogo");

        Inventario inventario = new Inventario();
        inventario.setItem(new EspadaDebug(), 1);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 2);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 3);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 4);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 5);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 6);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 7);
        inventario.setItem(InvHelper.getRandomItemByRarity(), 8);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new CuraGrande());
        items.add(new EspadaFantasma());
        items.add(new CuraPequena());

<<<<<<< Updated upstream
        Jogador player = new Jogador("Trabalho de PE", 0, inventario, 100, 100, 20, 0, 0);
=======
        tela.setMargin(33);
        tela.toggleFrame();

        Jogador player = jog.orElse(new Jogador("Trabalho de PE", 0, inventario, 100, 100, 20, 0));
>>>>>>> Stashed changes
        player.setSpriteList(Spritesheets.getCavaleirinho());
        Inimigo enemy = new Inimigo("Felicien", null, items, 100, 100, 20, 0);
        Inimigo enemy2 = new Inimigo("Elon Musk", null, items, 100, 100, 20, 0);
        Inimigo enemy3 = new Inimigo("snope", null, items, 999, 999, 20, 20);
        enemy3.setSpriteList(Spritesheets.getEsnupi());

        Batalha batalha1 = new Batalha(20, player, enemy, inventario, this);
        Batalha batalha2 = new Batalha(20, player, enemy2, inventario, this);
        Batalha batalha3 = new Batalha(20, player, enemy3, inventario, this);

        // Batalha 1
        this.setBatalha(batalha1);
        iniciarBatalha(this.batalha);
        controleTurno(this.batalha);

        // Batalha 2
        this.setBatalha(batalha2);
        iniciarBatalha(this.batalha);
        controleTurno(this.batalha);

        // Batalha 3
        this.setBatalha(batalha3);
        iniciarBatalha(this.batalha);
        controleTurno(this.batalha);

        System.out.println("\nFim de jogo! Deseja armazenar os seus items?");
        System.out.println("\n 1 - Salvar");
        System.out.println("\n2 - Não salvar");
        System.out.println("> ");
        new Scanner(System.in).nextLine(); // Pausa para o jogador ler
    }

    public void close_game(){
        System.out.println("Fechou o jogo");
        gameLoop = false;
    }

    public void load_game(){
        System.out.println("Carregou o jogo");
        Jogador jogadorRecuperado = SaveManager.Carregar();
        start_new_game(Optional.ofNullable(jogadorRecuperado));
    }

    public void saveGame(Jogador player){
        // saveManager nao possui atributos apenas metodos
        SaveManager.Salvar(player);
    }


    public void SaveOptions(Jogador player){
        Scanner sc = new Scanner(System.in);
        int resposta = -1;

        while (true) {
            System.out.print("> ");
            try {
                String opcao = sc.nextLine();
                resposta = Integer.parseInt(opcao);
                if (resposta >= 1 && resposta <= 2) {
                    switch (resposta){
                        case 1:
                            saveGame(player);
                            break;
                        case 2:
                            System.out.println("O jogo nao foi salvo");
                            break;
                    }
                } else {
                    System.out.println("Opcao Invalida! Por favor, digite 1, 2 ou 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro! Por favor, digite um numero.");
            }
        }
    }


    public int ShowMenuAndOptions() {
        tela.drawMainMenuScreen();
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int resposta = -1;

        while (true) {
            System.out.print("> ");
            try {
                String opcao = sc.nextLine();
                resposta = Integer.parseInt(opcao);
                if (resposta >= 1) {
                    return resposta;
                } else {
                    System.out.println("Opcao Invalida! Por favor, digite 1, 2 ou 3 ou 4 ou mais.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro! Por favor, digite um numero.");
            }
        }
    }

    // LOGICA DE JOGO AQUI
    //na verdade isso e so a logica do menu principal
    public void gameLoop(){
        this.tela = new ScreenManager();
        tela.setMargin(20);
        tela.toggleFrame();
        this.gameLoop = true;

        while (this.gameLoop) {
            int escolha = ShowMenuAndOptions(); // o menu
            switch (escolha) {
                case 1:
                    start_new_game(Optional.empty()); // vai criar um do zero
                    break;
                case 2:
                    load_game();
                    break;
                case 3:
                    close_game();
                    break;
                case 4:
                    tela.toggleFrame();
                    break;
                default:
                    try {
                        tela.setMargin(escolha);
                    } catch (Exception ArrayIndexOutOfBoundsException) {}
            }
        }
    }
}


