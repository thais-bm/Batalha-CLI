package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class Sanduiche extends ItemConsumivel{
    public Sanduiche() {
        super("Sanduíche", "- SANDUÍCHE -", "Consumível", "Aumenta o dano base de ataque do jogador em 10 ao consumir", "Melhoria permanente");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("    ______   ");
        spritelist.add("   /______\\  ");
        spritelist.add("   |_.-=-_|  ");
        spritelist.add("  ~_~_~=_~_~ ");
        spritelist.add("   \\______/  ");
        
        this.setSpriteList(spritelist);
    }

    public void Efeito(Jogador personagem) {
        personagem.setAtk(personagem.getAtk() + 10);
        personagem.getInventario().removeItem(this);
    }
}