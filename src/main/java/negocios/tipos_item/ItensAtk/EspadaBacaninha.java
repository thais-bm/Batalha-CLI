package negocios.tipos_item.ItensAtk;
import negocios.Jogador;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;

public class EspadaBacaninha extends ItemAtk{
    public EspadaBacaninha() {
        super("Espada Maisoumenos", "- ESPADA MAIS OU MENOS -", "", "aumenta dano de ataques em 15");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("             ");
        spritelist.add("      A      ");
        spritelist.add("     |||     ");
        spritelist.add("    _|||_    ");
        spritelist.add("      T      ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada, Jogador jogador) {
        return entrada + 15;
    }
}