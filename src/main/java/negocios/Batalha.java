package negocios;


import java.util.Scanner;

//Não sei se é pra ter um numero definido de turnos ou se vai trocando ate alguem morrer

public class Batalha {
    private int numTurnos;
    private Jogador personagem;
    private Inimigo inimigo;
    private Inventário inventário;
    private boolean seAtivo;


    public Batalha(int numTurnos, Jogador personagem, Inimigo inimigo, Inventário inventário, boolean seAtivo) {
        this.numTurnos = numTurnos;
        this.inventário = inventário;
        this.personagem = personagem;
        this.inimigo = inimigo;
        this.seAtivo = seAtivo;
    }

    //Getter e Setters

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }

    public Inventário getInventário() {
        return inventário;
    }

    public void setInventário(Inventário inventário) {
        this.inventário = inventário;
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

            //Se o inimigo tiver menos de 20 de vida e pocao de cura com ele da pra ele usar
            //Vou ver se da pra fazer se ele tiver pocao de dano foda dar pra usar
            //else if(inimigo.getVida() < 20 && inimigo.items == "Pocao de cura") {

            //}

        }
    }
}
