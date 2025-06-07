package negocios;

import java.util.ArrayList;

public class Jogador extends Entidade{
    private int max_inv_tam;
    private Inventário inventário;
    private ArrayList<String> sprite;
    private Armadura armadura;
    private Arma arma;

    public Jogador(String nome,int max_inv_tam, Inventário inventário,float max_vida, float vida, float atk, float def){
        super(nome,max_vida, vida, atk, def);
        this.max_inv_tam = max_inv_tam;
        loadDefaultSprite();
    }

    //Getters e Setters
    public int getMax_inv_tam() {
        return max_inv_tam;
    }
    public void setMax_inv_tam(int max_inv_tam) {
        this.max_inv_tam = max_inv_tam;
    }
    
    private void loadDefaultSprite() {
        this.setSpriteList(Spritesheets.getCavaleirinho());
    }

    public void equiparArmadura(Armadura armadura){
        setDef(getDef() + armadura.getDefesaBonus());
    }

    public void equiparArma(Arma arma){
        setAtk(getAtk() + arma.getDanoBonus());
    }

}
