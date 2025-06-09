package telas;
import java.util.ArrayList;

/*
ITENS POSICAO:
item 1: Linha 3, Coluna 8 
item 2: Linha 3, Coluna 8 + 20
item 3: Linha 3, Coluna 8 + 20 + 20
item 4: Linha 3, Coluna 8 + 20 + 20 + 20
item 5: Linha 11, Coluna 8
item 6: Linha 11, Coluna 8 + 20
item 7: Linha 11, Coluna 8 + 20 + 20
item 8: Linha 11, Coluna 8 + 20 + 20 + 20

tamanho: 5 x 13
*/
public abstract class SpritesInterface {
    public static ArrayList<String> getInvBase() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ____________________________________|INVENTÁRIO|______________________________________  ");
        spritelist.add(" O                                                                                      O ");
        spritelist.add("|      O-----|1|-----O     O-----|2|-----O     O-----|3|-----O     O-----|4|-----O       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      O-------------O     O-------------O     O-------------O     O-------------O       |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|      O-----|5|-----O     O-----|6|-----O     O-----|7|-----O     O-----|8|-----O       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|      |             |     |             |     |             |     |             |       |");
        spritelist.add("|______O-------------O_____O-------------O_____O-------------O_____O-------------O_______|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O ");
        return spritelist;
    }

    public static ArrayList<String> getInvSelected() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  __________________________________|ITEM SELECIONADO|__________________________________  ");
        spritelist.add(" O                                                                                      O ");
        spritelist.add("|                                     O-------------O                                    |");
        spritelist.add("|                                     |             |                                    |");
        spritelist.add("|                                     |             |                                    |");
        spritelist.add("|                                     |             |                                    |");
        spritelist.add("|                                     |             |                                    |");
        spritelist.add("|                                     |             |                                    |");
        spritelist.add("|                                     O-------------O                                    |");
        spritelist.add("|                    ________________________________________________                    |");
        spritelist.add("|                   /                                                \\                   |");
        spritelist.add("|                  |                                                  |                  |");
        spritelist.add("|                  |                                                  |                  |");
        spritelist.add("|                  |                                                  |                  |");
        spritelist.add("|                  |                                                  |                  |");
        spritelist.add("|                   \\________________________________________________/                   |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O ");
        return spritelist;
    }

    public static ArrayList<String> getNewItems() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  __________________________________|ITEM SELECIONADO|__________________________________  ");
        spritelist.add(" O                                                                                      O ");
        spritelist.add("|           O-----|1|-----O           O-----|2|-----O           O-----|3|-----O          |");
        spritelist.add("|           |             |           |             |           |             |          |");
        spritelist.add("|           |             |           |             |           |             |          |");
        spritelist.add("|           |             |           |             |           |             |          |");
        spritelist.add("|           |             |           |             |           |             |          |");
        spritelist.add("|           |             |           |             |           |             |          |");
        spritelist.add("|           O-------------O           O-------------O           O-------------O          |");
        spritelist.add("|                  |                         |                         |                 |");
        spritelist.add("|                  V                         V                         V                 |");
        spritelist.add("|        O-------------------O     O-------------------O     O-------------------O       |");
        spritelist.add("|        |                   |     |                   |     |                   |       |");
        spritelist.add("|        O-------------------O     O-------------------O     O-------------------O       |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O ");
        return spritelist;
    }

    public static ArrayList<String> getInvSwap() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ______________________________________________________________________________________  ");
        spritelist.add(" O                                                                                      O ");
        spritelist.add("|      O|SELECIONADO|O          ________________________________________________         |");
        spritelist.add("|      |             |         /                                                \\        |");
        spritelist.add("|      |             |        |                                                  |       |");
        spritelist.add("|      |             |        |                                                  |       |");
        spritelist.add("|      |             |        |                                                  |       |");
        spritelist.add("|      |             |         \\________________________________________________/        |");
        spritelist.add("|      O-------------O                      |                                            |");
        spritelist.add("|_________________________________________  |  _____________________ O---|NOVO|----O ____|");
        spritelist.add("|            ______________________________\\|/_______________        |             |     |");
        spritelist.add("|           /                                                \\       |             |     |");
        spritelist.add("|          |                                                  |      |             |     |");
        spritelist.add("|          |                                                  |      |             |     |");
        spritelist.add("|          |                                                  |      |             |     |");
        spritelist.add("|           \\________________________________________________/       O-------------O     |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O ");
        return spritelist;
    }

    public static ArrayList<String> getTextBox() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ________________________________________________  ");
        spritelist.add(" /                                                \\ ");
        spritelist.add("|                                                  |");
        spritelist.add("|                                                  |");
        spritelist.add("|                                                  |");
        spritelist.add(" \\________________________________________________/ ");
        return spritelist;
    }


    // Interface menu principal
    public static ArrayList<String> getMenuPrincipal(){
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("   _______________________________________________________________________________ ");
        spritelist.add("  0                                                                               0");
        spritelist.add("  |  __                /     ____        _        _ _                             |");
        spritelist.add("  |  \\ Z_            / /    |  _ \\      | |      | | |                            |");
        spritelist.add("  |    \\_\\__       /__ /    | |_) | __ _| |_ __ _| | |__   __ _                   |");
        spritelist.add("  |    /  \\\\\\_     //       |  _ < / _` | __/ _` | | '_ \\ / _` |                  |");
        spritelist.add("  |    \\_____/    //        | |_) | (_| | || (_| | | | | | (_| |                  |");
        spritelist.add("  |    /    \\    //         |____/ \\__,_|\\__\\__,_|_|_| |_|\\__,_|                  |");
        spritelist.add("  |                                                                               |");
        spritelist.add("  |                                1 - NOVO JOGO                                  |");
        spritelist.add("  |                               2 - CARREGAR JOGO                               |");
        spritelist.add("  |                                3 - FECHAR JOGO                                |");
        spritelist.add("  |                                  4 - MOLDURA                                  |");
        spritelist.add("  |                              5+ - ALTERAR MARGEM                              |");
        spritelist.add("  0_______________________________________________________________________________0");
        return spritelist;
    }

    public static ArrayList<String> getEmptySlot() {
        ArrayList<String> spritelist = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            spritelist.add("             ");
        }
        return spritelist;
    }
}
