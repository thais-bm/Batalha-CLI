package negocios;


import java.util.Scanner;

public class Batalha {
    private int numTurnos;
    private Jogador personagem;
    private Inimigo inimigo;
    private boolean seAtivo;
    private boolean vezDoJogador;

    public Batalha(int numTurnos, Jogador personagem, Inimigo inimigo, boolean seAtivo) {
        this.numTurnos = numTurnos;
        this.personagem = personagem;
        this.inimigo = inimigo;
        this.seAtivo = seAtivo;
    }

    //Getter e Setters

    public void setVezDoJogador(boolean vezDoJogador) {
        this.vezDoJogador = vezDoJogador;
    }

    public boolean isVezDoJogador() {
        return vezDoJogador;
    }

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
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
    public void iniciarTurnos(Inimigo inimigo, Jogador personagem) {
        seAtivo = true;
        vezDoJogador = true;
        System.out.println("Iniciando turnos");
        System.out.println(numTurnos);
        System.out.println("É a vez do:" + personagem.getNome());
        turnoJogador();
    }

    public void turnoJogador() {
        if(numTurnos > 0 && inimigo.seVivo(inimigo) && seAtivo && vezDoJogador) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Turno do jogador:");
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
                    //dps adicionar o inventario aqui
                    break;
                case 4:
                    break;
            }


        }
        else{
            seAtivo = false;
            System.out.println("Turno acabou!");
        }

    }
    public void turnoInimigo() {
        if(numTurnos > 0 && personagem.seVivo(personagem) && seAtivo && !vezDoJogador) {
            if(personagem.getAtk() > inimigo.getAtk()) {
                inimigo.defender(this,inimigo);
                numTurnos--;
                turnoJogador();
            }
            else if(personagem.getAtk() < inimigo.getAtk()) {
                inimigo.atacar(this,personagem);
                numTurnos--;
                turnoJogador();
            }
            //Se o inimigo tiver menos de 20 de vida e pocao de cura com ele da pra ele usar
            //Vou ver se da pra fazer se ele tiver pocao de dano foda dar pra usar
            //else if(inimigo.getVida() < 20 && inimigo.items == "Pocao de cura") {

            //}

        }
    }
}
