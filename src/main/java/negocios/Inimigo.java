package negocios;

import java.util.ArrayList;

public class Inimigo extends Entidade{
    public String tipo;
    public ArrayList<Item> recompensa;

    public Inimigo(String tipo, ArrayList<Item> recompensa, float max_vida,float vida, float atk, float def){
        super(max_vida, vida, atk, def);
        loadDefaultSprite();
        this.tipo = tipo;
        this.recompensa = recompensa;
    }

    //Getters e setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Item> getRecompensa() {
        return recompensa;
    }
    public void setRecompensa(ArrayList<Item> recompensa) {
        this.recompensa = recompensa;
    }




    private void loadDefaultSprite() {
        this.setSpriteList(Spritesheets.getFantasminha());
    }
}
