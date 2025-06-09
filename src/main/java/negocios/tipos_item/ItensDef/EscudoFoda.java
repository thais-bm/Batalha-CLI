package negocios.tipos_item.ItensDef;

import negocios.tipos_item.ItemDef;

import java.util.ArrayList;

public class EscudoFoda extends ItemDef {
    public EscudoFoda() {
        //acho que o professor pode nao gostar do nome antigo disso
        super("Escudo Maneiro", "- ESCUDO MANEIRO -", "", "reduz dano de ataques sofridos em 50");
        this.setRaridade("menos comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  .-==-==-.  ");
        spritelist.add(" ||escudo || ");
        spritelist.add(" ||maneiro|| ");
        spritelist.add("  \\\\      // ");
        spritelist.add("   \\\\____//  ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        int resposta = entrada - 50;
        if (resposta < 1) resposta = 1;
        return resposta;
    }
}
