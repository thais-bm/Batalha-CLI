package telas;
import java.util.ArrayList;

/*
criei essa classe pra facilitar renderização na tela, principalmente pra elementos gráficos que podem ser alterados,
como o sprite do jogador e do inimigo, que podem ser alterados frequentemente, e itens no inventário, que com certeza
não vão sempre ser os mesmos
*/

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
        len = sprite.get(0).length();
        start = new int[] {startlinha, startcoluna};
    }
    //construtor caso nao usar os argumentos opcionais
    public Sprite(ArrayList<String> list) {
        this(list, 0, 0);
    }
    
    //quantidade de linhas
    public int getHeight() {
        return height;
    }
    //quantidade de letras em cada linha
    public int getLen() {
        return len;
    }
    //posição da linha e da coluna do canto superior esquerdo do sprite quando desenhado na tela
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
    //roda esse loop com o index de cada elemento no ArrayList de Strings da tela que vai ser alterado pra conter o sprite sendo adicionado
        for (int i = startlinha; i < startlinha + height; i++) {
            String currentline = tela.get(i); // salva numa variável uma cópia da String sendo substituída
            String newline = sprite.get(i - startlinha); // salva numa variável uma cópia da substring que vai ser inserida
            StringBuilder builder = new StringBuilder(currentline); // cria StringBuilder contendo a cópia da original
                                // StringBuilder é tipo uma string não constante e modificável já que em java Strings são constantes
            builder.replace(startcoluna, startcoluna + len, newline); // Substitui uma parte específica da string original pela nova substring
            tela.set(i, builder.toString()); // transforma o StringBuilder em String, substitui a versão antiga da String no array de strings
                                             // pela versão nova que tem uma parte dela substituida
        }
    }
}
