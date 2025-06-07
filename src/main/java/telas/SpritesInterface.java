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
        spritelist.add("|                                     O|SELECIONADO|O                                    |");
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
        spritelist.add("|            ______________________________\\|/______________         |             |     |");
        spritelist.add("|           /                                               \\        |             |     |");
        spritelist.add("|          |                                                 |       |             |     |");
        spritelist.add("|          |                                                 |       |             |     |");
        spritelist.add("|          |                                                 |       |             |     |");
        spritelist.add("|           \\_______________________________________________/        O-------------O     |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O ");
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
