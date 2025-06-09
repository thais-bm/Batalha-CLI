package negocios.tipos_item.ItensDef;
import negocios.Jogador;
import negocios.Spritesheets;
import negocios.tipos_item.ItemDef;

import java.util.ArrayList;


public class SapatoEspetado extends ItemDef{
    public SapatoEspetado() {
        super("Sapato Espetado","- SAPATO ESPETADO -", "Reduz dano sofrido em 5%", "Sempre que o usuário for atacado, aumenta o valor base", "de ataque do jogador em 7 permanentemente");
        this.setRaridade("comum");
        ArrayList<String> spritelist = Spritesheets.getPicaretaMinecraft();
        this.setSpriteList(spritelist);
    }

    public int Efeito(int entrada, Jogador jogador) {
        jogador.setAtk(jogador.getAtk() + 7);
        return (int) ((entrada * 0.95) - 0.999999);
    }
}