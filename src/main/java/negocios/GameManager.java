package negocios;
import telas.ScreenManager;
import telas.Sprite;

import java.util.Scanner;

public class GameManager {
    private Batalha batalha;
    private ScreenManager tela;

    // sem metodos
    public GameManager(){
        this.batalha = null;
        this.tela = null;
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
        reinciarBatalha();
    }


    public void perdeu(){
        batalha.setSeAtivo(false);
        System.out.println("Batalha acabou!");
        System.out.println("Não conseguiu ganhar no numero de turnos determinados ");
        reinciarBatalha();
    }

    public void reinciarBatalha() {
        System.out.println("Turno reinciado!");
        batalha.setSeAtivo(false);
    }

    // MENU PRINCIPAL
    public void start_new_game(){
        System.out.println("Comecou novo jogo");
        // comecar um novo jogo
    }

    public void close_game(){
        System.out.println("Fechou o jogo");
        System.exit(0);
    }

    public void load_game(){
        System.out.println("Carregou o jogo");
        // carregar um save

    }

    public void screenLogic(){
        tela.drawMainMenuScreen();
        tela.renderScreen();
        Scanner sc = new Scanner(System.in);
        int resposta = -1;
        while (true) {
            System.out.print("> ");
            try{
                String opcao = sc.nextLine();
                resposta = Integer.parseInt(opcao);

            } catch (NumberFormatException e) {
                System.out.println("Erro! Por favor, digite um numero");
                continue;
            }

            switch (resposta) {
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


