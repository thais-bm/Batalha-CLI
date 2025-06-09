package negocios;
import negocios.tipos_item.ItensConsumiveis.*;
import negocios.tipos_item.ItensAtk.*;
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
                System.out.println("morreu");
                new Sprite(Spritesheets.getVitoria(), 11, 45).draw(tela.getScreen());
            }
        }
        tela.renderScreen();
    }

    public void controleTurno(Batalha batalha) {
        if (batalha.getSeAtivo()) {
            while (batalha.getNumTurnos() > 0 && batalha.getSeAtivo()) {

                System.out.println("Turno atual: " + batalha.getNumTurnos());
                battleSpriteLoad(batalha, "Atacar", "Defender", "Inventario", "Nao sei");



                if(batalha.getPersonagem().getVida() <= 0){
                    perdeu();
                }
                batalha.turnoJogador();

                //Conseguiu derrotar o inimigo
                if (batalha.getInimigo().getVida() <= 0) {
                    battleSpriteLoad(batalha, batalha.getInimigo().getNome() + " morreu, prosseguir");
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
        manusearInventario();
    }

    public void manusearInventario(){
        tela.drawInventoryMain(batalha.getInventario());
        tela.renderScreen();



        System.out.println("1 - para remover um item");
        System.out.println("2 - para usar de item");
        System.out.println("3 - continuar");

        Scanner sc = new Scanner(System.in);
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Selecione um item para remover: ");
                int item = sc.nextInt();
                if(batalha.getPersonagem().getInventario().getItem(item) != null){
                    batalha.getPersonagem().getInventario().removeItem(item);
                }
                else {
                    System.out.println("Item removido com sucesso!");
                }
                break;

            case 2:
                System.out.println("Selecione um item para usar: ");
                int item2 = sc.nextInt();
                if(batalha.getPersonagem().getInventario().getItem(item2) != null){
                    batalha.getInventario().useItem(item2, batalha.getPersonagem());
                }
                else {
                    System.out.println("Item utilizado com sucesso!");
                }

            case 3:
                reiniciarBatalha();

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
        inventario.setItem(new CuraGrande(), 1);
        inventario.setItem(new EspadaFantasma(), 2);
        inventario.setItem(new CuraPequena(), 3);
        inventario.setItem(new EspadaBasica(), 4);
        inventario.setItem(new EspadaManeira(), 5);
        inventario.setItem(new CuraMedia(), 7);
        inventario.setItem(new PedraPolimento(), 8);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new CuraGrande());
        items.add(new EspadaFantasma());
        items.add(new CuraPequena());

        tela.setMargin(33);
        tela.toggleFrame();

        Jogador player = new Jogador("Trabalho de PE", 0, inventario, 100, 100, 50, 0);
        player.setSpriteList(Spritesheets.getCavaleirinho());
        Inimigo enemy = new Inimigo("Felicien", null, items, 100, 100, 10, 0);
        Inimigo enemy2 = new Inimigo("Elon Musk", null, items, 100, 100, 10, 0);
        Inimigo enemy3 = new Inimigo("snope", null, items, 999, 999, 10, 20);
        enemy3.setSpriteList(Spritesheets.getEsnupi());

        Batalha batalha1 = new Batalha(20, player, enemy, inventario);
        Batalha batalha2 = new Batalha(20, player, enemy2, inventario);
        Batalha batalha3 = new Batalha(20, player, enemy3, inventario);

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

        System.out.println("\nFim de jogo! Pressione Enter para voltar ao menu.");
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


