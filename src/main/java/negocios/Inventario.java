package negocios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import negocios.tipos_item.ItemAtk;
import negocios.tipos_item.ItemConsumivel;
import negocios.tipos_item.ItemDef;
import negocios.tipos_item.ItensAtk.*;
import negocios.tipos_item.ItensConsumiveis.*;
import negocios.tipos_item.ItensDef.*;

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
//pra ser mais intuitivo deixei o index do setItem e getItem como 1 a mais que o normal (1-8 no lugar de 0-7) pra condizer com o numero do slot
    public void setItem(Item item, int index){
        if (index < 1 || index > 8) return;
        itemlist[index-1] = item;
    }

//se item no slot especificado for consumivel ativa o efeito do item sobre o jogador, entao remove o item do inventario
    public void useItem(int index, Jogador jogador) {
        if (this.getItem(index) instanceof ItemConsumivel) {
            ItemConsumivel item = (ItemConsumivel) this.getItem(index);
            item.Efeito(jogador);
            removeItem(index);
        }
    }

    public void removeItem(int index) {
        if (index < 1 || index > 8) return;
        itemlist[index-1] = null;
    }

    public void removeItem(Item item) {
        int counter = 1;
        for (Item i : itemlist) {
            if (i == item) {
                removeItem(counter);
                break;
            }
            counter++;
        }
    }

    public int findItem(Item item) {
        int counter = 1;
        for (Item i : itemlist) {
            if (i.equals(item)) {
                return counter;
            }
            counter++;
        }
        return 0;
    }

    public boolean isFull() {
        for (Item item : itemlist) {
            if (item == null) return false;
        }
        return true;
    }

    public void addItem(Item newitem) {
        for (int i = 1; i <= 8; i++) {
            if (getItem(i) == null) {
                setItem(newitem, i);
                break;
            }
        }
    }


//A ideia é antes do jogador atacar, rodar esse método por cima do stat base de ataque do jogador
//o loop passa por cada item no inventario, e se o item for uma sub-subclasse da subclasse ItemAtk
//usa a função Efeito() no valor de entrada, a função Efeito() tem um efeito diferente pra cada item diferente
    public int itensDeAtaqueFunctionCall(int entrada, Jogador jogador) {
        int resposta = entrada;
        for (Item item: itemlist) {
            if (item instanceof ItemAtk) {
                ItemAtk holder = (ItemAtk) item;
                resposta = holder.Efeito(resposta, jogador);
            }
        }
        return resposta;
    }

    public int itensDeDefesaFunctionCall(int entrada, Jogador jogador) {
        int resposta = entrada;
        for (Item item: itemlist) {
            if (item instanceof ItemDef) {
                ItemDef holder = (ItemDef) item;
                resposta = holder.Efeito(resposta, jogador);
            }
        }
        return resposta;
    }

}