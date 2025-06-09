package negocios.tipos_item.ItensAtk;
import java.util.ArrayList;
import negocios.tipos_item.ItemAtk;
import negocios.tipos_item.ItemDef;

public class Martelo extends ItemAtk{
    public Martelo() {
        super("Martelão", "- MARTELÃO -", "aumenta dano de ataques em 5",
                   "bônus aumenta em mais 15 para cada", "item que reduz dano sofrido no invenário");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add(" |''-=X=-''| ");
        spritelist.add(" |,,-.X.-,,| ");
        spritelist.add("     | |     ");
        spritelist.add("     |/|     ");
        spritelist.add("     |_|     ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        int resposta = entrada + 5;
        for (int i = 1; i <= 8; i++) {
            if (this.getInventario().getItem(i) instanceof ItemDef) resposta += 15;
        }
        return resposta;
    }
}
