package telas;
import negocios.Jogador;

import java.util.ArrayList;
/*
 CAIXA DA BARRA DE VIDA: LINHAS 0-5 (6) SUBSTRING 0-29 (30 caracteres)
 NOME DO JOGADOR: LINHA 0 SUBSTRING 1-8 (8 caracteres)
 CONTADOR DE VIDA (??/??): LINHA 2 SUBSTRING 1-8 (8 caracteres)
 BARRA DE VIDA: LINHA 4 SUBSTRING 5-25 (20 caracteres)
 MENU: LINHAS 14-19 (6) SUBSTRING 0-41 (42 caracteres)
 CAIXA DA BARRA DE VIDA DO INIMIGO: LINHAS 13-18 (6) SUBSTRING 49-89 (40 caracteres)

 SPRITE DO JOGADOR: LINHAS 6-13 (8) SUBSTRING 0-41 (42 caracteres)
 SPRITE DO INIMIGO:
*/
public abstract class telabatalha {
    public static ArrayList<String> DrawUI(ArrayList<String> tela) {

        //sprites dos elementos de IU de batalha
        ArrayList<String> barradevida = new ArrayList<String>();
        barradevida.add("|[ NOME ]|                   O");
        barradevida.add("|HP ??/??|                   |");
        barradevida.add("     --------------------    |");
        barradevida.add("    {                    }   |");
        barradevida.add("     --------------------    |");
        barradevida.add("_____________________________O");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("=========================================O");
        menu.add("  1 - esse texto vai ser                 |");
        menu.add("  2 - substituido em breve               |");
        menu.add("  3 - pelas opcoes de batalha            |");
        menu.add("  4 -                                    |");
        menu.add("                                         |");

        ArrayList<String> vidadoinimigo = new ArrayList<String>();
        vidadoinimigo.add(" _______________________________________ ");
        vidadoinimigo.add("O     [NOME DO INIMIGO]     | HP ??/??  O");
        vidadoinimigo.add("|          --------------------         |");
        vidadoinimigo.add("|         {                    }        |");
        vidadoinimigo.add("|          --------------------         |");
        vidadoinimigo.add("O_______________________________________O");

        //desenhando os elementos por cima da "tela"
        for (int i = 0; i <= 5; i++) {
            String currentline = tela.get(i);
            StringBuilder builder = new StringBuilder(currentline);
            builder.replace(0, 29, barradevida.get(i));
            tela.set(i, builder.toString());
        }
        for (int i = 14; i <= 19; i++) {
            String currentline = tela.get(i);
            StringBuilder builder = new StringBuilder(currentline);
            builder.replace(0, 41, menu.get(i-14));
            tela.set(i, builder.toString());
        }
        for (int i = 13; i <= 18; i++) {
            String currentline = tela.get(i);
            StringBuilder builder = new StringBuilder(currentline);
            builder.replace(49, 89, vidadoinimigo.get(i-13));
            tela.set(i, builder.toString());
        }

        return tela;
    }
    //Sprite do jogador PRECISA ser array com EXATAMENTE 8 elementos String de tamanho 42
    public static ArrayList<String> DrawPlayerSprite(ArrayList<String> tela, ArrayList<String> sprite) {
        if (sprite.size() !=8) {
            return tela;
        }
        for (int i = 6; i <= 13; i++) {
            String currentline = tela.get(i);
            StringBuilder builder = new StringBuilder(currentline);
            builder.replace(0, 42, sprite.get(i-6));
            tela.set(i, builder.toString());
        }
        return tela;
    }




}
