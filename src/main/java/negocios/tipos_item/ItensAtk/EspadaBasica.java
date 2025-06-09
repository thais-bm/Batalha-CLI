package negocios.tipos_item.ItensAtk;
import java.util.ArrayList;

import negocios.Jogador;
import negocios.tipos_item.ItemAtk;

public class EspadaBasica extends ItemAtk{
    public EspadaBasica() {
        super("Espada Simples", "- ESPADA SIMPLES -", "", "aumenta dano de ataques em 10");
        this.setRaridade("muito comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("             ");
        spritelist.add("      |      ");
        spritelist.add("      |      ");
        spritelist.add("      T      ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada, Jogador jogador) {
        return entrada + 10;
    }
}
