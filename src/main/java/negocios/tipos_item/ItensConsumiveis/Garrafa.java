package negocios.tipos_item.ItensConsumiveis;
import java.util.ArrayList;
import negocios.tipos_item.ItemConsumivel;
import negocios.Jogador;

public class Garrafa extends ItemConsumivel{

    int usos;
    public Garrafa(int usos) {
        super("Poção", "- POÇÃO - ", "Consumível", "recupera 50% de HP perdido ao consumir", "pode ser consumida " + (usos) + " vezes");
        this.setRaridade("comum");
        this.usos = usos;
        ArrayList<String> spritelist1 = new ArrayList<String>();
        spritelist1.add("     ,_,     ");
        spritelist1.add("     /~\\     ");
        spritelist1.add("    | o |    ");
        spritelist1.add("    |o  |    ");
        spritelist1.add("    \\__o/    ");

        ArrayList<String> spritelist2 = new ArrayList<String>();
        spritelist2.add("     , ,     ");
        spritelist2.add("     / \\     ");
        spritelist2.add("    |~~~|    ");
        spritelist2.add("    |  o|    ");
        spritelist2.add("    \\o__/    ");

        ArrayList<String> spritelist3 = new ArrayList<String>();
        spritelist3.add("     , ,     ");
        spritelist3.add("     / \\    ");
        spritelist3.add("    |   |    ");
        spritelist3.add("    |~~~|    ");
        spritelist3.add("    \\___/    ");
        if (usos == 3) this.setSpriteList(spritelist1);
        if (usos == 2) this.setSpriteList(spritelist2);
        if (usos == 1) this.setSpriteList(spritelist3);
        
    }

    public Garrafa() {
        this(3);
    }

    public void Efeito(Jogador personagem) {

        personagem.setVida(personagem.getVida() + (personagem.getMax_vida() * 0.5f));
        if (personagem.getVida() > personagem.getMax_vida()){
            personagem.setVida(100);
        }
        if (usos == 3) personagem.getInventario().setItem(new Garrafa(2), personagem.getInventario().findItem(this));
        if (usos == 2) personagem.getInventario().setItem(new Garrafa(1), personagem.getInventario().findItem(this));
        if (usos == 1) personagem.getInventario().removeItem(this);
    }
}
