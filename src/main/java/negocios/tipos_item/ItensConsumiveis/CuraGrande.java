package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class CuraGrande extends ItemConsumivel{
    public CuraGrande() {
        super("Poçãozona", "- POÇÃOZONA -", "recupera 100% de HP perdido");
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
            personagem.setVida(personagem.getVida() + (personagem.getMax_vida() * 1));
        if (personagem.getVida() > personagem.getMax_vida()){
            personagem.setVida(100);
        }
        personagem.getInventario().removeItem(this);
    }
}
