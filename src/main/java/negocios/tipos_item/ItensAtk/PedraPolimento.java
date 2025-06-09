package negocios.tipos_item.ItensAtk;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;

public class PedraPolimento extends ItemAtk{
    public PedraPolimento() {
        super("Amolador de Faca", "- AMOLADOR DE FACA -", "A cada item ofensivo no inventário,", "aumenta dano do ataque em 20%", "(tudo que aumenta ataque é considerado ofensivo)");
        this.setRaridade("comum");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("     _______ ");
        spritelist.add("    /.   : /|");
        spritelist.add("   /   .  / /");
        spritelist.add("  /_'___ /./ ");
        spritelist.add(" | '  . | /  ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        double resposta = (double) entrada;
        double multiplicador = 1;
        for (int i = 1; i <= 8; i++) {
            if (this.getInventario().getItem(i) instanceof ItemAtk) multiplicador += 0.20;
        }
        return (int) ((resposta * multiplicador) + 0.9999);
    }
}