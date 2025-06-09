package telas;

import utilidades.ComandosUteis;
import java.util.ArrayList;

public abstract class Inventario_EscolherNovoItem {
    public static void drawUI(ArrayList<String> tela) {
        new Sprite(SpritesInterface.getNewItems(), 0, 0).draw(tela);
    }

    //usando como argumento a tela e o sprite dos itens e os nomes, coloca
    //o item no espacinho certinho perfeito
    public static void drawItem(ArrayList<String> tela, Sprite sprite1, Sprite sprite2, Sprite sprite3, String nome1, String nome2, String nome3) {
        sprite1.draw(tela, 3, 13);
        sprite2.draw(tela, 3, 39);
        sprite3.draw(tela, 3, 65);

        StringBuilder builder = new StringBuilder(tela.get(12));
        builder.replace(10, 29, ComandosUteis.autocentraliza(nome1, 19));
        builder.replace(36, 55, ComandosUteis.autocentraliza(nome2, 19));
        builder.replace(62, 81, ComandosUteis.autocentraliza(nome3, 19));
        tela.set(12, builder.toString());

    } //tambem pode usar a lista de string se quiser e ela vai ser convertida em objeto Sprite
    public static void drawItem(ArrayList<String> tela, ArrayList<String> spritelist1, ArrayList<String> spritelist2, ArrayList<String> spritelist3, String nome1, String nome2, String nome3) {
        drawItem(tela, new Sprite(spritelist1), new Sprite(spritelist2), new Sprite(spritelist3), nome1, nome2, nome3);
    }

    //nesse as opções NÃO vão ser numeradas automaticamente como no menu de batalha, a numeração deve ser parte da string
    //imagino que não tem nenhuma situação que pode necessitar de mais que 2 opções nessa tela do menu
    //então vou programar pra formatar pra 2 opções
    //limite de tamanho de string: 43
    public static void drawOptions(ArrayList<String> tela, String... args) {
        for (int i = 0; i < args.length && i < 2; i++) {
            StringBuilder builder = new StringBuilder(tela.get(17+i));
            builder.replace(1, 89, ComandosUteis.autocentraliza(args[i], 88));
            tela.set(17+i, builder.toString());
        }
    }
}