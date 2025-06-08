package negocios.tipos_item.ItensAtk;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;

public class EspadaManeira extends ItemAtk{
    public EspadaManeira() {
        super("Espada Legal", "- ESPADA LEGAL -", "", "aumenta dano de ataques em 25");
        this.setRaridade("menos comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("     / \\     ");
        spritelist.add("     |Y|     ");
        spritelist.add("     \\|/     ");
        spritelist.add("    <=O=>    ");
        spritelist.add("      ⡇      ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        return entrada + 25;
    }
}