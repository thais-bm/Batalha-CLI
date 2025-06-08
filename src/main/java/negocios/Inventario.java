package negocios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import negocios.tipos_item.ItemAtk;

import java.util.HashMap;

public class Inventario {
    private Item[] itemlist;

    public Inventario() {
        itemlist = new Item[8];
    }
    
    public Item getItem(int index) {
        if (index > 8) return null;
        try {
            return itemlist[index-1];
        } catch (Exception ArrayIndexOutOfBoundsException) {
            //totalmente nao precisava de tratamento de exceção mas tinha que usar em algum lugar pra mostrar que a gente aprendeu
            return null;
        }
    }

    public void setItem(Item item, int index){
        if (index < 1 || index > 8) return;
        itemlist[index-1] = item;
        item.setInventario(this);
    }

    public int itensDeAtaqueFunctionCall(int entrada) {
        int resposta = entrada;
        for (Item item: itemlist) {
            if (item instanceof ItemAtk) {
                resposta = item.Efeito(resposta);
            }
        }
        return resposta;
    }

}