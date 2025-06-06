package negocios;

import java.util.ArrayList;
import java.util.List;

public class Inventário {
    private int max_inv_tam;
    private int tamanho_atual;
    //n lembro mais como faz array
    ArrayList<Item> lista_items;

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
    public void adicionarItem(){
        this.tamanho_atual += 1;
        //n sei como vai botar o item aq
        //lista_items.add(item);
    }

    public void removerItem(){
        this.tamanho_atual -= 1;

    }

    public void listarItem(){

    }
}
