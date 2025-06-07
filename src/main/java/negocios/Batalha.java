package negocios;


import java.util.Scanner;

//Não sei se é pra ter um numero definido de turnos ou se vai trocando ate alguem morrer

public class Batalha {
    private int numTurnos;
    private Jogador personagem;
    private Inimigo inimigo;
    private Inventário inventário;
    private boolean seAtivo;
    private boolean vezDoJogador;


    public Batalha(int numTurnos, Jogador personagem, Inimigo inimigo, Inventário inventário, boolean seAtivo) {
        this.numTurnos = numTurnos;
        this.inventário = inventário;
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
        turnoJogador();
    }

    public void turnoJogador() {
        System.out.println("\nÉ a vez de:" + personagem.getNome());
        if(numTurnos > 0 && inimigo.seVivo(inimigo) && seAtivo) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Turno do jogador:");
            int turno = sc.nextInt();

            switch(turno) {
                case 1:
                    personagem.atacar(this,inimigo);
                    turnoInimigo();
                    numTurnos--;
                    break;
                case 2:
                    personagem.defender(this,personagem);
                    turnoInimigo();
                    numTurnos--;
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }


        }
        else if(inimigo.seVivo(inimigo) == false && numTurnos > 0) {
            seAtivo = false;
            System.out.println("Batalha acabou!");
            if(inimigo.recompensa != null){
                System.out.println("O inimigo dropou recompensas: ");
                for(int i = 0; i < inimigo.recompensa.size(); i++){
                    System.out.println("-" + inimigo.recompensa.get(i).getNome());
                }

               for(int i = 0; i < inimigo.recompensa.size(); i++){
                   System.out.println(inimigo.recompensa.get(i).getNome() + " adicionado");
                   inventário.adicionarItem(inimigo.recompensa.get(i));
               }
            }
        }
        else if(numTurnos < 0 && inimigo.seVivo(inimigo) == true && seAtivo) {
            seAtivo = false;
            System.out.println("Batalha acabou!");
            System.out.println("Não conseguiu ganhar no numero de turnos determinados ");
        }

    }
    public void turnoInimigo() {
        System.out.println("\nÉ a vez de:" + inimigo.getNome());
        if(numTurnos > 0 && personagem.seVivo(personagem) && seAtivo) {
            if(personagem.getAtk() + 50 > inimigo.getAtk()) {
                inimigo.atacar(this,personagem);
                numTurnos--;
                turnoJogador();
            }
            else if(personagem.getAtk() < inimigo.getAtk()) {
                inimigo.defender(this,inimigo);
                numTurnos--;
                turnoJogador();
            }
            //Se o inimigo tiver menos de 20 de vida e pocao de cura com ele da pra ele usar
            //Vou ver se da pra fazer se ele tiver pocao de dano foda dar pra usar
            //else if(inimigo.getVida() < 20 && inimigo.items == "Pocao de cura") {

            //}

        }else{
            seAtivo = false;
            System.out.println("Batalha acabou!");
            System.out.println("Voce perdeu!: ");
            }

    }
}
