package negocios.tipos_item.ItensAtk;
import negocios.tipos_item.ItemAtk;
import java.util.ArrayList;


public class EspadaDebug extends ItemAtk{
    public EspadaDebug() {
        super("EspadaDebug","espada debug", "dano 999", "se isso aparecer ou eu cometi um erro ou eu", "esqueci de fazer nao começar o jogo com isso");
        this.setRaridade("não encontrada na loot table de item aleatório");
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("             ");
        spritelist.add("             ");
        spritelist.add("      :)     ");
        spritelist.add("             ");
        spritelist.add("             ");
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada) {
        return entrada + 999;
    }
}
