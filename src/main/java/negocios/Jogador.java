package negocios;

import telas.ScreenManager;
import telas.TelaInventario;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador extends Entidade{
    private Inventario inventario;
    private ArrayList<String> sprite;
    private ScreenManager screen;
    private int sortebonus;

    public Jogador(String nome,int max_inv_tam, Inventario inventario,float max_vida, float vida, float atk, float def, int sortebonus) {
        super(nome,max_vida, vida, atk, def);
        this.sortebonus = sortebonus;
        this.inventario = inventario;
        this.screen = new ScreenManager();
        loadDefaultSprite();
    }

    public Jogador(String nome,int max_inv_tam, Inventario inventario,float max_vida, float vida, float atk, float def) {
        this(nome, max_inv_tam, inventario, max_vida, vida, atk, def, 0);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setSorte(int sortebonus) {
        this.sortebonus = sortebonus;
    }

    public int getSorte() {
        return sortebonus;
    }

    private void loadDefaultSprite() {
        this.setSpriteList(Spritesheets.getCavaleirinho());
    }

    public void atacar(Batalha batalha, Entidade entidade) {
        System.out.println("Atacando: " + entidade.getNome());
        entidade.setVida(entidade.getVida() - this.inventario.itensDeAtaqueFunctionCall((int) this.getAtk()));
        System.out.println("Total vida depois do ataque: " + entidade.getVida());

    }

    public void mostrarInventario() {
        screen.drawInventoryMain(getInventario());
        screen.renderScreen();
    }

    public void mostrarItem(int index){
        screen.drawInventoryItemSelected(inventario, index);
        screen.renderScreen();
    }


}
