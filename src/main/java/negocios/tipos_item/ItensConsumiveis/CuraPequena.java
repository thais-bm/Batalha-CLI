package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class CuraPequena extends ItemConsumivel{
    public CuraPequena() {
        super("Poçãozinha", "- POÇÃOZINHA -", "Consumível", "recupera 25% de HP perdido");
        this.setRaridade("muito comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("             ");
        spritelist.add("     |~|     ");
        spritelist.add("     | |     ");
        spritelist.add("     |_|     ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }

    public void Efeito(Jogador personagem) {
        personagem.setVida(personagem.getVida() + (personagem.getMax_vida()/4));
        if (personagem.getVida() > personagem.getMax_vida()){
            personagem.setVida(100);
        }
        personagem.getInventario().removeItem(this);
    }
}
