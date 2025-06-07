package telas;
import java.util.ArrayList;

public class Sprite {
    int len;
    int height;
    int[] start;

    ArrayList<String> sprite;
    //Argumentos:
    //primeiro: ArrayList contendo as Strings do sprite
    //segundo (opcional (mas de preferencia usar)): em que linha é pra começar o sprite
    //terceiro (tambem opcional): comprimento do sprite em letras supondo que é um retângulo perfeito com tudo no mesmo comprimento
    public Sprite(ArrayList<String> list, int startlinha, int startcoluna) {
        sprite = list;
        height = sprite.size();
        len = sprite.getFirst().length();
        start = new int[] {startlinha, startcoluna};
    }
    //construtor caso nao usar os argumentos opcionais
    public Sprite(ArrayList<String> list) {
        this(list, 0, 0);
    }
    
    public int getHeight() {
        return height;
    }
    public int getLen() {
        return len;
    }
    public int[] getStart() {
        return start;
    }
    public void setStart(int linha, int coluna) {
        start = new int[] {linha, coluna};
    }


    //sem argumentos de posicao, vai renderizar com o ponto superior esquerdo do sprite sendo o do atributo start
    public void draw(ArrayList<String> tela) {
        this.draw(tela, start[0], start[1]);
    }
    public void draw(ArrayList<String> tela, int startlinha, int startcoluna) {
        for (int i = startlinha; i < startlinha + height; i++) {
            String currentline = tela.get(i);
            String newline = sprite.get(i - startlinha);
            StringBuilder builder = new StringBuilder(currentline);
            builder.replace(startcoluna, startcoluna + len, newline);
            tela.set(i, builder.toString());
        }
    }
}
