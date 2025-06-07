package negocios;
import java.util.ArrayList;

/*
Criei essa classe abstrata pra ter um lugar onde guardar os sprites sem deixar um negocio enorme dentro do codigo das outras classes
por sinal, barrinha inclinada pra esquerda "\" dentro de string causa erro sozinha por causa da formatação de strings
duas barrinhas tipo "\\" saem como uma só barrinha "\" na hora de fazer o print
então cada par de "\\" representa um "\"

fora isso
sprite do player em batalha: 8 x 42
sprite do inimigo em batalha: 13 x 42

*/

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
        sprite.add("                                          ");
        sprite.add("                                          ");
        sprite.add("                                          ");
        sprite.add("                                          ");
        sprite.add("             __------__                   ");
        sprite.add("            /          \\\\                 ");
        sprite.add("         __|       O     _\\__             ");
        sprite.add("        |  |  O      _       \\            ");
        sprite.add("         \\_|    ___--      _/             ");
        sprite.add("            \\              _\\             ");
        sprite.add("             |         ___/               ");
        sprite.add("             \\_/\\_____/                   ");
        sprite.add("                                          ");
        return sprite;
    }

    public static ArrayList<String> getEsnupi() {
        ArrayList<String> sprite;
        sprite = new ArrayList<String>();
        sprite.add("            ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⠿⣟⣛⣛⣛⣫⣵⣿⣿⣿⣮⠻⣿⣿           ");
        sprite.add("            ⣿⣿⡿⣱⣿⣿⣿⣿⣿⢻⣿⣿⣿⣿⣿⣷⢻⣿           ");
        sprite.add("            ⣿⠫⠡⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠉⠇⣿           ");
        sprite.add("            ⣿⣶⣦⡻⢿⣿⣿⣿⣿⣿⣿⣿⡇⠣⠈⢠⠐⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣷⣾⣽⣻⢿⣿⣿⡿⡸⠂⠀⡠⣳⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣿⣿⣿⡿⣁⣛⡣⣿⣷⣮⣽⣾⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣿⣿⢟⣼⣿⣻⣇⣿⣿⣿⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣿⡟⣾⣿⣏⣿⡟⢸⣿⣿⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣿⣇⡻⣿⡿⡟⢏⡙⡿⣿⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣿⣿⠿⠆⣿⢻⣷⢾⣭⣵⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⠻⢞⣭⣯⣯⣾⣿⣝⢿⣿⣿⣿⣿⣿           ");
        sprite.add("            ⣿⣿⣿⣿⣷⣦⣥⣯⣯⣯⣭⣭⣼⣿⣿⣿⣿⣿           ");
        return sprite;
    }

    public static ArrayList<String> getEspadinha() {
        ArrayList<String> spritelist = new ArrayList<>();
        spritelist.add("     /|\\     ");
        spritelist.add("     |||     ");
        spritelist.add("     |||     ");
        spritelist.add("    <=O=>    ");
        spritelist.add("      U      ");
        return spritelist;
    }
}
