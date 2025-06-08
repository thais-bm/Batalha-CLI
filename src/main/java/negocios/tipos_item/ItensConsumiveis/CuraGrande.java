package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class CuraGrande extends ItemConsumivel{
    public CuraGrande() {
        super("Poçãozona", "- POÇÃO -\n\nrecupera 100% de HP perdido");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("    .:=:.  @ ");
        spritelist.add("   @ | |     ");
        spritelist.add("    /~~~\\ @  ");
        spritelist.add("   | ' . |   ");
        spritelist.add("    \\___/    ");
        this.setSpriteList(spritelist);
    }

    public void Efeito(Jogador personagem) {
        personagem.setVida(personagem.getVida());
    }
}
