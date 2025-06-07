package negocios;

import java.util.ArrayList;
import java.util.List;

public class Inventário {
    private int max_inv_tam;
    private int tamanho_atual;
    ArrayList<Item> lista_items;

    public Inventário(int max_inv_tam, int tamanho_atual, ArrayList<Item> lista_items) {
        this.max_inv_tam = max_inv_tam;
        this.tamanho_atual = tamanho_atual;
        this.lista_items = lista_items;
    }

    //Getters e Setters
    public ArrayList<Item> getLista_items() {
        return lista_items;
    }

    public void setLista_items(ArrayList<Item> lista_items) {
        this.lista_items = lista_items;
    }

    public void setMax_inv_tam(int max_inv_tam) {
        this.max_inv_tam = max_inv_tam;
    }

    public void setTamanho_atual(int tamanho_atual) {
        this.tamanho_atual = tamanho_atual;
    }

    public int getMax_inv_tam() {
        return max_inv_tam;
    }

    public int getTamanho_atual() {
        return tamanho_atual;
    }

    //Métodos
    public void adicionarItem(Item item) {
        this.tamanho_atual += 1;
        lista_items.add(item);
    }

    public void usarItem(Item item) {
        this.tamanho_atual -= 1;
        lista_items.remove(item);
    }

    public void listarItem(){
        System.out.println(lista_items);
    }
}
