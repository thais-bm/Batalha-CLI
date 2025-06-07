package negocios;

public class GameManager {
    private Batalha batalha;

    public GameManager(Batalha batalha) {
        this.batalha = batalha;
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

    public void controleTurno(Batalha batalha) {
        if (batalha.getSeAtivo()) {
            while (batalha.getNumTurnos() > 0 && batalha.getSeAtivo()) {
                System.out.println("Turno atual: " + batalha.getNumTurnos());

                batalha.turnoJogador();

                //Conseguiu derrotar o inimigo
                if (batalha.getInimigo().getVida() <= 0) {
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
        if (batalha.getInimigo().recompensa != null) {
            System.out.println("O inimigo dropou recompensas: ");
            for (int i = 0; i < batalha.getInimigo().recompensa.size(); i++) {
                System.out.println("-" + batalha.getInimigo().recompensa.get(i).getNome());
            }

            //Adiciona as recompensas que o inimigo tinha no inventario
            for (int i = 0; i < batalha.getInimigo().recompensa.size(); i++) {
                System.out.println(batalha.getInimigo().recompensa.get(i).getNome() + " adicionado no inventário");
                batalha.getInventário().adicionarItem(batalha.getInimigo().recompensa.get(i));
            }
        }
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
        iniciarBatalha(batalha);
    }
}


