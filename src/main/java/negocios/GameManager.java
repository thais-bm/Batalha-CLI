package negocios;
import negocios.tipos_item.ItensConsumiveis.*;
import negocios.tipos_item.ItensDef.EscudoRuim;
import negocios.tipos_item.ItemConsumivel;
import negocios.tipos_item.ItensAtk.*;
import persistencia.SaveManager;
import telas.ScreenManager;
import telas.Sprite;

import java.util.Scanner;
import java.util.ArrayList;

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
                    scanner.next();
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
        manusearInventario();

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
        while (true) {
            try {
                entrada2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada2 == 0) {
                batalha.getInventario().setItem(newitem, entrada);
                manusearInventario();
                break;
            }
            if (entrada2 == 1) {
                inventarioCheioAddItem(newitem);
                break;
            }
            
        }

    }

    public void newItemChoice (Item item1, Item item2, Item item3) {
        tela.drawNewItemsScreen(item1, item2, item3, "(1-3) - Escolher novo item              4 - Checar inventario", "0 - Pular                                                    ");
        Scanner sc = new Scanner(System.in);
        int entrada = -1;
        while (true) {
            try {
                entrada = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (entrada > 0 || entrada < 4) {
                break;
            }
        }
        switch(entrada) {
            case 0:
                break;
            case 1:
                if (getBatalha().getInventario().isFull()) {
                    inventarioCheioAddItem(item1);
                } else {
                    getBatalha().getInventario().addItem(item1);
                }
                break;
            case 2:
                if (getBatalha().getInventario().isFull()) {
                    inventarioCheioAddItem(item2);
                } else {
                    getBatalha().getInventario().addItem(item2);
                }
                break;
            case 3:
                if (getBatalha().getInventario().isFull()) {
                    inventarioCheioAddItem(item3);
                } else {
                    getBatalha().getInventario().addItem(item3);
                }
                break;
            case 4:
                manusearInventario();
                break;
        }
    }

    public void reiniciarBatalha() {
        System.out.println("Turno reinciado!");
        batalha.setSeAtivo(false);
    }



    // MENU PRINCIPAL
    public void start_new_game() {
        System.out.println("Comecou novo jogo");

        Inventario inventario = new Inventario();
        inventario.setItem(InvHelper.getRandomItemByRarity(), 1);
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

        tela.setMargin(33);
        tela.toggleFrame();

        Jogador player = new Jogador("Trabalho de PE", 0, inventario, 100, 100, 20, 0);
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
        // carregar um save

    }

    public void saveGame(Jogador player){
        SaveManager saveManager = new SaveManager();
        SaveManager.Salvar(player);
    }

    public void LoadGame(){

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
                if (resposta >= 1 && resposta <= 3) {
                    return resposta;
                } else {
                    System.out.println("Opcao Invalida! Por favor, digite 1, 2 ou 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro! Por favor, digite um numero.");
            }
        }
    }

    // LOGICA DE JOGO AQUI
    public void gameLoop(){
        this.tela = new ScreenManager();
        this.gameLoop = true;

        while (this.gameLoop) {
            int escolha = ShowMenuAndOptions(); // o menu
            switch (escolha) {
                case 1:
                    start_new_game();
                    break;
                case 2:
                    load_game();
                    break;
                case 3:
                    close_game();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }
        }
    }
}


