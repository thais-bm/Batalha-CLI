package negocios;
import java.util.ArrayList;
public abstract class Spritesheets {
    public static ArrayList<String> getCavaleirinho() {
        ArrayList<String> sprite;
        sprite = new ArrayList<String>();
        sprite.add("                                          ");
        sprite.add("                                          ");
        sprite.add("           __                /            ");
        sprite.add("           \\ Z_            / /            ");
        sprite.add("             \\_\\__       /__ /            ");
        sprite.add("             /  \\\\\\_     //               ");
        sprite.add("             \\_____/    //                ");
        sprite.add("             /    \\    //                 ");
        return sprite;
    }

    public static ArrayList<String> getFantasminha() {
        ArrayList<String> sprite;
        sprite = new ArrayList<String>();
        sprite.add("                                           ");
        sprite.add("                                           ");
        sprite.add("                                           ");
        sprite.add("                                           ");
        sprite.add("             __------__                    ");
        sprite.add("            /          \\\\                  ");
        sprite.add("         __|       O     _\\__              ");
        sprite.add("        |  |  O      _       \\             ");
        sprite.add("         \\_|    ___--      _/              ");
        sprite.add("            \\              _\\              ");
        sprite.add("             |         ___/                ");
        sprite.add("             \\_/\\_____/                    ");
        sprite.add("                                           ");
        return sprite;
    }
}
