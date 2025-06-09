package negocios;


import java.util.Scanner;

//Não sei se é pra ter um numero definido de turnos ou se vai trocando ate alguem morrer

public class Batalha {
    private int numTurnos;
    private Jogador personagem;
    private Inimigo inimigo;
    private Inventario inventario;
    private boolean seAtivo;
    private GameManager manager;

    public Batalha(int numTurnos, Jogador personagem, Inimigo inimigo, Inventario inventario, GameManager manager) {
        this.numTurnos = numTurnos;
        this.inventario = inventario;
        this.personagem = personagem;
        this.inimigo = inimigo;
        this.manager = manager;
    }

    //Getter e Setters

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventário(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }
    public void setPersonagem(Jogador personagem) {
        this.personagem = personagem;
    }
    public void setSeAtivo(boolean seAtivo) {
        this.seAtivo = seAtivo;
    }
    public Inimigo getInimigo() {
        return inimigo;
    }
    public int getNumTurnos() {
        return numTurnos;
    }
    public Jogador getPersonagem() {
        return personagem;
    }
    public boolean getSeAtivo() {
        return seAtivo;
    }

    //Métodos

    public void turnoJogador() {
        
        System.out.println("\nÉ a vez de:" + personagem.getNome());
            Scanner sc = new Scanner(System.in);

            System.out.println("Acao do jogador:");
            int turno = sc.nextInt();
            switch(turno) {
                case 1:
                    personagem.atacar(this,inimigo);
                    numTurnos--;
                    break;
                case 2:
                    personagem.defender(this,personagem);
                    numTurnos--;
                    break;
                case 3:
                    manager.manusearInventario();
                    numTurnos--;
                    break;
                case 4:
                    break;
            }


    }
    public void turnoInimigo() {
        System.out.println("\nÉ a vez de:" + inimigo.getNome());
        if (numTurnos > 0 && personagem.seVivo(personagem) && seAtivo) {
            if (personagem.getAtk() + 50 > inimigo.getAtk()) {
                inimigo.atacar(this, personagem);
                numTurnos--;
            } else if (personagem.getAtk() < inimigo.getAtk()) {
                inimigo.defender(this, inimigo);
                numTurnos--;
            }

        }
    }
}
