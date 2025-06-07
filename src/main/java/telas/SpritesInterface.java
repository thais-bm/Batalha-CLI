package telas;
import java.util.ArrayList;

public abstract class SpritesInterface {
    public static ArrayList<String> getInvBase() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ______________________________________________________________________________________  ");
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
        spritelist.add(" O______________________________________________________________________________________O");
    }

    public static ArrayList<String> getInvSelected() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ______________________________________________________________________________________  ");
        spritelist.add(" O                                                                                    O ");
        spritelist.add("|      O|SELECIONADO|O          _______________________________________________          |");
        spritelist.add("|      |             |         /                                               \\          |");
        spritelist.add("|      |             |        |                                                 |         |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      O-------------O         \\_______________________________________________/         |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O");
    }

    public static ArrayList<String> getInvSwap() {
        ArrayList<String> spritelist = new ArrayList<String>();
        spritelist.add("  ______________________________________________________________________________________  ");
        spritelist.add(" O                                                                                    O ");
        spritelist.add("|      O|SELECIONADO|O          _______________________________________________          |");
        spritelist.add("|      |             |         /                                               \\         |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      |             |        |                                                 |        |");
        spritelist.add("|      |             |         \\_______________________________________________/         |");
        spritelist.add("|      O-------------O                                                                   |");
        spritelist.add("|__________________________________________ | ______________________ O---|NOVO|----O ____|");
        spritelist.add("|           _______________________________\\|/_____________          |             |     |");
        spritelist.add("|          /                                               \\         |             |     |");
        spritelist.add("|         |                                                 |        |             |     |");
        spritelist.add("|         |                                                 |        |             |     |");
        spritelist.add("|         |                                                 |        |             |     |");
        spritelist.add("|          \\_______________________________________________/         O-------------O     |");
        spritelist.add("|________________________________________________________________________________________|");
        spritelist.add("|                                                                                        |");
        spritelist.add("|                                                                                        |");
        spritelist.add(" O______________________________________________________________________________________O");
    }
}
