package negocios;

import negocios.tipos_item.ItensAtk.*;
import negocios.tipos_item.ItensConsumiveis.*;
import negocios.tipos_item.ItensDef.*;
import java.util.Random;

public abstract class InvHelper {
        public static Item[] getAllAtkItemsList() {
        return new Item[] {
            new Dente(),
            new EspadaBacaninha(),
            new EspadaBasica(),
            new EspadaFantasma(),
            new EspadaManeira(),
            new Martelo(),
            new PedraPolimento()
        };
    }

    public static Item[] getAllConsumivelItemsList() {
        return new Item[] {
            new CuraGrande(),
            new CuraMedia(),
            new CuraPequena(),
            new Garrafa(),
            new Sanduiche()
        };
    }

    public static Item[] getAllDefItemsList() {
        return new Item[] {
            new EscudoFoda(),
            new EscudoMarroMeno(),
            new EscudoRuim(),
            new SapatoEspetado()
        };
    }

    public static Item[] getAllItemList() {
        Item[] atklist = getAllAtkItemsList();
        Item[] consumelist = getAllConsumivelItemsList();
        Item[] deflist = getAllDefItemsList();
        Item[] resposta = new Item[atklist.length + consumelist.length + deflist.length];
        int index = 0;
        for (Item i : atklist) {
            resposta[index] = i;
            index++;
        }
        for (Item i : consumelist) {
            resposta[index] = i;
            index++;
        }
        for (Item i : deflist) {
            resposta[index] = i;
            index++;
        }
        return resposta;
    }
    
    public static Item[] getAllMuitoComumList() {
        Item[] listall = getAllItemList();
        int nmuitocomum = 0;
        for (Item i : listall) if (i.getRaridade().equals("muito comum")) nmuitocomum++;
        Item[] resposta = new Item[nmuitocomum];
        int index = 0;
        for (Item i : listall) if (i.getRaridade().equals("muito comum")) {
            resposta[index] = i;
            index++;
        }
        return resposta;    
    }

    public static Item[] getAllComumList() {
        Item[] listall = getAllItemList();
        int nmuitocomum = 0;
        for (Item i : listall) if (i.getRaridade().equals("comum")) nmuitocomum++;
        Item[] resposta = new Item[nmuitocomum];
        int index = 0;
        for (Item i : listall) if (i.getRaridade().equals("comum")) {
            resposta[index] = i;
            index++;
        }
        return resposta;    
    }

    public static Item[] getAllMenosComumList() {
        Item[] listall = getAllItemList();
        int nmuitocomum = 0;
        for (Item i : listall) if (i.getRaridade().equals("menos comum")) nmuitocomum++;
        Item[] resposta = new Item[nmuitocomum];
        int index = 0;
        for (Item i : listall) if (i.getRaridade().equals("menos comum")) {
            resposta[index] = i;
            index++;
        }
        return resposta;    
    }

    public static Item getRandomItemByRarity(int sortebonus) {
        Random random = new Random();
        Item[] list;
        int key = random.nextInt(100) + 1;
        key *= (1 + (sortebonus/100));
        //key = (int) ( ( (double) key) * ((double) 1 + ( ( (double) (sortebonus) ) / 100 ) ) );

        if (key <= 50) {
            //50%
            list = getAllMuitoComumList();
        }
        else if (key <= 80) {
            //30%
            list = getAllComumList();
        }
        else {
            //20%
            list = getAllMenosComumList();
        }

        return list[random.nextInt(list.length)];
    }

    public static Item getRandomItemByRarity() {
        return getRandomItemByRarity(0);
    }
}
