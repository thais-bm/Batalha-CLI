package telas;
import negocios.Entidade;
import utilidades.ComandosUteis;

import java.util.ArrayList;
/*
 CAIXA DA BARRA DE VIDA: LINHAS 0-5 (6) SUBSTRING 0-29 (30 caracteres)
 NOME DO JOGADOR: LINHA 0 SUBSTRING 1-8 (8 caracteres)
 CONTADOR DE VIDA (??/??): LINHA 2 SUBSTRING 1-8 (8 caracteres)
 BARRA DE VIDA: LINHA 4 SUBSTRING 5-25 (20 caracteres)
 MENU: LINHAS 14-19 (6) SUBSTRING 0-41 (42 caracteres)
 CAIXA DA BARRA DE VIDA DO INIMIGO: LINHAS 13-18 (6) SUBSTRING 49-89 (40 caracteres)
 CONTADOR DE VIDA DO INIMIGO:

 SPRITE DO JOGADOR: LINHAS 6-13 (8) SUBSTRING 0-41 (42 caracteres)
 SPRITE DO INIMIGO: LINHAS 0-16 (17) SUBSTRING 48-89 (43 caracteres)
*/
public abstract class telabatalha {

    public static void drawUI(ArrayList<String> tela) {

        //sprites dos elementos de IU de batalha
        ArrayList<String> barradevida = new ArrayList<String>();
        barradevida.add("| nome vai aqui |            O");
        barradevida.add("|HP ???/???|                 |");
        barradevida.add("     --------------------    |");
        barradevida.add("    {                    }   |");
        barradevida.add("     --------------------    |");
        barradevida.add("_____________________________O");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("=========================================O");
        menu.add("                                         |");
        menu.add("                                         |");
        menu.add("                                         |");
        menu.add("                                         |");
        menu.add("                                         |");

        //esse daqui ficou tipo minimamente assimetrico mas a gente ignora e nao conta pra ninguem
        ArrayList<String> vidadoinimigo = new ArrayList<String>();
        vidadoinimigo.add(" _______________________________________ ");
        vidadoinimigo.add("O     [NOME DO INIMIGO]     |HP ???/???|O");
        vidadoinimigo.add("|          --------------------         |");
        vidadoinimigo.add("|         {                    }        |");
        vidadoinimigo.add("|          --------------------         |");
        vidadoinimigo.add("O_______________________________________O");

        //desenhando os elementos por cima da "tela"
        
        new Sprite(barradevida, 0, 0).draw(tela);
        new Sprite(menu, 14, 0).draw(tela);
        new Sprite(vidadoinimigo, 13, 49).draw(tela);
        return;
    }


    
    //Sprite do jogador deve ter 8 linhas de altura e 42 caracteres comprimento
    //senao pode ser desenhado por cima de outros elementos
    public static void drawPlayerSprite(ArrayList<String> tela, Sprite playersprite) {
        playersprite.draw(tela, 6, 0);
        return;
    }
    //Mesma coisa que o anterior mas com 13 linhas de altura e 43 comprimento
    public static void drawEnemySprite(ArrayList<String> tela, Sprite enemysprite) {
        enemysprite.draw(tela, 0, 48);
        return;
    }
    
    //metodo que atualiza os valores de HP que aparecem na interface de batalha assim como a barra de hp
    public static void drawHPBar(ArrayList<String> tela, int hp, int maxhp, String tipo) {
        int xposcounter = 0;
        int yposcounter = 0;
        int xposbar = 0;
        int yposbar = 0; 
        if (tipo.equals("jogador")) {
            xposcounter = 4;
            yposcounter = 1;
            xposbar = 5;
            yposbar = 3;
        } else if (tipo.equals("inimigo")) {
            xposcounter = 81;
            yposcounter = 14;
            xposbar = 60;
            yposbar = 16;
        }


        double hpratio = (double) hp / (double) maxhp;
        int barfill = (int) ((20 * hpratio) + 0.5);
        

        //parte que atualiza o contador de hp na UI enquanto mantendo formatação
        String newline = "";
        if (hp < 10) {newline += "  " + hp;}
        else if (hp < 100) {newline += " " + hp;}
        else if (hp < 1000) {newline += hp;}
        newline += "/";
        if (maxhp < 10) { newline += "" + maxhp + "  "; }
        else if (maxhp < 100) { newline += "" + maxhp + " "; }
        else if (maxhp < 1000) { newline += maxhp; }
        //se o hp nao couber no formato ???/??? com 7 caracteres, vai aparecer apenas o hp
        else {
            newline = "" + hp;
            for (int i = 0; i < 7 - ("" + hp).length() ; i++) {
                newline += " ";
            }
        }
        tela.set(yposcounter, new StringBuilder(tela.get(yposcounter)).replace(xposcounter, xposcounter+7, newline).toString());

        //parte que atualiza a barrinha de hp
        newline = "";
        for (int i = 0; i < 20; i++) {
            if (i < barfill - 1 || barfill == 20) {newline += "/";}
            else if (i < barfill) {newline += "|";}
            else {newline += " ";}
        }
        tela.set(yposbar, new StringBuilder(tela.get(yposbar)).replace(xposbar, xposbar+20, newline).toString());
    }
    

    //organiza e formata opções de menu da tela de batalha. como argumentos bota o array de tela e
    //de 0 a 4 Strings. pode botar mais string mas da quinta pra cima elas vao ser ignoradas
    public static void drawMenuOptions(ArrayList<String> tela, String... args) {
        for (int i = 0; i < 4 && i < args.length; i++) {
            //String newsubstr = "  " + (i+1) + " - " + args[i];
            String newsubstr = "" + args[i];

            if (newsubstr.length() > 40) {
                newsubstr = newsubstr.substring(0, 39);
            } else while (newsubstr.length() < 39) {
                newsubstr += " ";
            }

            StringBuilder builder = new StringBuilder(tela.get(i + 15));
            builder.replace(0, 39, newsubstr);
            tela.set(i + 15, builder.toString());
        }
    }

    //coloca o nome do jogador ou do inimigo nas barras de vida
    //se for jogador colocar "jogador" como argumento key
    //se for inimigo colocar "inimigo" ou qualquer outra coisa tanto faz
    //formata o texto pra ficar centralizado no espaço pro nome
    public static void drawName(ArrayList<String> tela, String nome, String key) {
        int line;
        int columnstart;
        int sizelimit;
        if (key.equals("jogador")) {line = 0; columnstart = 1; sizelimit = 15;}
        else {line = 14; columnstart = 50; sizelimit = 27;}

        String newsubstr = ComandosUteis.autocentraliza(nome, sizelimit);

        tela.set(line, new StringBuilder(tela.get(line)).replace(columnstart, columnstart + sizelimit, newsubstr).toString());
    }
}
