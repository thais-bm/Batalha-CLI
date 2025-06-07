package telas;

import utilidades.ComandosUteis;
import java.util.ArrayList;

public abstract class Inventario_ItemSelecionado {
    public static void drawUI(ArrayList<String> tela) {
        new Sprite(SpritesInterface.getInvSelected()).draw(tela);
    }

    public static void drawSwapUI(ArrayList<String> tela) {
        new Sprite(SpritesInterface.getInvSwap()).draw(tela);
    }



    public static void drawItem(ArrayList<String> tela, Sprite sprite, String key) {
        int linha = 3;
        int coluna = 39;
        if (key.equals("swap1")){
            coluna = 8;
        }
        if (key.equals("swap2")){
            linha = 10;
            coluna = 70;
        }
        sprite.draw(tela, linha, coluna);
    }
    public static void drawItem(ArrayList<String> tela, ArrayList<String> spritelist, String key) {drawItem(tela, new Sprite(spritelist), key);}
    public static void drawItem(ArrayList<String> tela, Sprite sprite) {drawItem(tela, sprite, "");}
    public static void drawItem(ArrayList<String> tela, ArrayList<String> spritelist) {drawItem(tela, new Sprite(spritelist), "");}

    public static void drawDesc(ArrayList<String> tela, String[] args, String key) {
        int line = 11;
        int start = 21;
        int end = 69;
        
        if (key.equals("swap1")) {
            line = 3;
            start = 32;
            end = 80;
        }
        if (key.equals("swap2")) {
            line = 11;
            start = 13;
            end = 61;
        }
        for (int i = 0; i < args.length && i < 4; i++) {
            StringBuilder builder = new StringBuilder(tela.get(line+i));
            builder.replace(start, end, ComandosUteis.autocentraliza(args[i], 48));
            tela.set(line+i, builder.toString());
        }
    }


    public static void drawOptions(ArrayList<String> tela, String... args) {
        for (int i = 0; i < args.length && i < 2; i++) {
            StringBuilder builder = new StringBuilder(tela.get(17+i));
            builder.replace(1, 89, ComandosUteis.autocentraliza(args[i], 88));
            tela.set(17+i, builder.toString());
        }
    }
}
//13 60