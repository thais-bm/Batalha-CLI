package negocios;

import java.util.ArrayList;

public class Inimigo extends Entidade{
    public String tipo;
    public ArrayList<Item> recompensa;
    public String[] items;

    public Inimigo(String nome,String tipo, ArrayList<Item> recompensa, float max_vida,float vida, float atk, float def) {
        super(nome,max_vida, vida, atk, def);
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

    public void atacar(Batalha batalha, Entidade entidade) {
        System.out.println("Atacando: " + entidade.getNome());
        double dano = batalha.getInventario().itensDeDefesaFunctionCall((int) this.getAtk());
        entidade.setVida((float)(entidade.getVida() - dano));
        if (entidade.getVida() < 0) entidade.setVida(0);
        System.out.println("Total vida depois do ataque: " + entidade.getVida());

    }

    private void loadDefaultSprite() {
        this.setSpriteList(Spritesheets.getFantasminha());
    }
}
