package negocios;

import telas.ScreenManager;
import telas.TelaInventario;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogador extends Entidade{
    private int max_inv_tam;
    private Inventario inventario;
    private ArrayList<String> sprite;
    private ScreenManager screen;

    public Jogador(String nome,int max_inv_tam, Inventario inventario,float max_vida, float vida, float atk, float def){
        super(nome,max_vida, vida, atk, def);
        this.max_inv_tam = max_inv_tam;
        this.inventario = inventario;
        this.screen = new ScreenManager();
        loadDefaultSprite();
    }

    //Getters e Setters
    public int getMax_inv_tam() {
        return max_inv_tam;
    }
    public void setMax_inv_tam(int max_inv_tam) {
        this.max_inv_tam = max_inv_tam;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    private void loadDefaultSprite() {
        this.setSpriteList(Spritesheets.getCavaleirinho());
    }

    public void atacar(Batalha batalha, Entidade entidade) {
        System.out.println("Atacando: " + entidade.getNome());
        entidade.setVida(entidade.getVida() - this.inventario.itensDeAtaqueFunctionCall((int) this.getAtk()));
        System.out.println("Total vida depois do ataque: " + entidade.getVida());

    }

    //n sei se ja tinha um chamar inventario, tem mt coisa aq
    public void mostrarInventario() {
        screen.drawInventoryMain(getInventario());
        screen.renderScreen();
    }


}
