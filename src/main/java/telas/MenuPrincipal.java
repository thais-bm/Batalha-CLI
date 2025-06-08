package telas;

import utilidades.ComandosUteis;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    public static void drawUI(ArrayList<String> tela) {
        new Sprite(SpritesInterface.getMenuPrincipal()).draw(tela);
    }
}
