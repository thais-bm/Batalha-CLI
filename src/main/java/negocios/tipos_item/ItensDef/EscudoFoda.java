package negocios.tipos_item.ItensDef;

import negocios.tipos_item.ItemDef;

import java.util.ArrayList;

public abstract class EscudoFoda extends ItemDef {
    public EscudoFoda() {
        super("Escudo Foda", "- ESCUDO FODA -", "", "reduz dano de ataques sofridos em 50");
        this.setRaridade("menos comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("   .-.__.-.  ");
        spritelist.add("  ||escudo|| ");
        spritelist.add("  || foda || ");
        spritelist.add("   \\______/  ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }



    public int Efeito(int entrada) {
        int resposta = entrada - 50;
        if (resposta < 1) resposta = 1;
        return resposta;
    }
}
