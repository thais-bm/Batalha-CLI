package negocios;

import java.util.ArrayList;

public class Jogador extends Entidade{
    public int max_inv_tam;
    public Inventário inventário;
    public ArrayList<String> sprite;

    public Jogador(int max_inv_tam, Inventário inventário,float max_vida, float vida, float atk, float def){
        super(max_vida, vida, atk, def);
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
}
