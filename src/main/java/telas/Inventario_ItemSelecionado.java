package telas;

import utilidades.ComandosUteis;
import java.util.ArrayList;

public abstract class Inventario_ItemSelecionado {
    public static void drawUI(ArrayList<String> tela) {
        new Sprite(SpritesInterface.getInvSwap()).draw(tela);
    }



    public static void drawItem(ArrayList<String> tela, Sprite sprite) {
        sprite.draw(tela, 3, 39);
    }
    public static void drawItem(ArrayList<String> tela, ArrayList<String> spritelist) {
        drawItem(tela, new Sprite(spritelist));
    }


    public static void drawDesc(ArrayList<String> tela, String... args) {
        for (int i = 0; i < args.length && i < 4; i++) {
            StringBuilder builder = new StringBuilder(tela.get(10+i));
            builder.replace(21, 69, ComandosUteis.autocentraliza(args[i], 48));
            tela.set(10+i, builder.toString());
        }
    }
}
