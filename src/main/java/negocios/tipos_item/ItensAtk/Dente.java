package negocios.tipos_item.ItensAtk;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;

public class Dente extends ItemAtk{
    public Dente() {
        super("Dente de Onça", "A cada item ofensivo no inventário,", "aumenta dano do ataque em +20 total", "(tudo que aumenta ataque é considerado ofensivo)");
        this.setRaridade("menos comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("      |\\     ");
        spritelist.add("     /' \\    ");
        spritelist.add("    /  ' |   ");
        spritelist.add("   |_   _|   ");
        spritelist.add("     '''     ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        int resposta = entrada;
        for (int i = 1; i <= 8; i++) {
            if (this.getInventario().getItem(i) instanceof ItemAtk) resposta += 20;
        }
        return resposta;
    }
}