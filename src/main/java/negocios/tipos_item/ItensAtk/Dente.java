package negocios.tipos_item.ItensAtk;
import negocios.Jogador;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;

public class Dente extends ItemAtk{
    public Dente() {
        super("Dente de Onça", "- DENTE DE ONÇA -", "A cada item ofensivo no inventário,", "aumenta dano do ataque em +20 total", "(tudo que aumenta ataque é considerado ofensivo)");
        this.setRaridade("menos comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("      |\\     ");
        spritelist.add("     /' \\    ");
        spritelist.add("    /  ' |   ");
        spritelist.add("   |_   _|   ");
        spritelist.add("     '''     ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada, Jogador jogador) {
        int resposta = entrada;
        for (int i = 1; i <= 8; i++) {
            if (jogador.getInventario().getItem(i) instanceof ItemAtk) resposta += 20;
        }
        return resposta;
    }
}