package negocios.tipos_item.ItensDef;
import negocios.tipos_item.ItemDef;
import java.util.ArrayList;

public class EscudoRuim extends ItemDef{
    public EscudoRuim() {
        super("Escudo Basico", "- ESCUDO BASICO -", "", "reduz dano de ataques sofridos em 10");
        this.setRaridade("muito comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("   .-.__.-.  ");
        spritelist.add("   |es    |  ");
        spritelist.add("   |  cu  |  ");
        spritelist.add("    \\__do/   ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        int resposta = entrada - 10;
        if (resposta < 1) resposta = 1;
        return resposta;
    }
}