package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class CuraMedia extends ItemConsumivel{
    public CuraMedia() {
        super("Poção", "- POÇÃO - ", "recupera 60% de HP perdido");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("     ._.     ");
        spritelist.add("     | |     ");
        spritelist.add("     / \\     ");
        spritelist.add("    |~~~|    ");
        spritelist.add("    \\___/    ");
        this.setSpriteList(spritelist);
    }

    public void Efeito(Jogador personagem) {

        personagem.setVida(personagem.getVida() + (personagem.getMax_vida() * 0.6f));
        if (personagem.getVida() > personagem.getMax_vida()){
            personagem.setVida(100);
        }
        personagem.getInventario().removeItem(this);
    }
}
