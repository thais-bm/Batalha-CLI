package negocios.tipos_item.ItensDef;

import negocios.tipos_item.ItemDef;

import java.util.ArrayList;

public class EscudoMarroMeno extends ItemDef {
    public EscudoMarroMeno() {
        super("Escudo Marro Meno", "- ESCUDO MARRO MENO -", "", "reduz dano de ataques sofridos em 25");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("   .-.__.-.  ");
        spritelist.add("  ||esc   ||  ");
        spritelist.add("  ||  uda ||  ");
        spritelist.add("   \\____o/   ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        int resposta = entrada - 25;
        if (resposta < 1) resposta = 1;
        return resposta;
    }
}
