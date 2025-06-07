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
    public void iniciarBatalha() {
        batalha.setSeAtivo(true);
        System.out.println("Batalha iniciada com sucesso!");
        System.out.println(batalha.getNumTurnos() + " turnos ao total");
    }

    public void controleTurno() {
        if (batalha.getSeAtivo()) {
            while (batalha.getNumTurnos() > 0) {
                System.out.println(batalha.getNumTurnos() + " turno atual");

                //Conseguiu derrotar o inimigo
                if (batalha.getInimigo().getVida() <= 0) {
                    derrotouInimigo();
                }
                //Não conseguiu derrotar no numero de turnos dados
                if(batalha.getNumTurnos() <= 0 && batalha.getInimigo().getVida() > 0) {
                    perdeu();
                }

                batalha.turnoJogador();
                if(batalha.getInimigo().getVida() > 0) {
                    batalha.turnoInimigo();
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

            for (int i = 0; i < batalha.getInimigo().recompensa.size(); i++) {
                System.out.println(batalha.getInimigo().recompensa.get(i).getNome() + " adicionado");
                batalha.getInventário().adicionarItem(batalha.getInimigo().recompensa.get(i));
            }
        }
    }

    public void perdeu(){
            batalha.setSeAtivo(false);
            System.out.println("Batalha acabou!");
            System.out.println("Não conseguiu ganhar no numero de turnos determinados ");
        }
}


