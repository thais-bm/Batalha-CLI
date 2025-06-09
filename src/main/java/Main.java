// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import negocios.*;
import negocios.tipos_item.*;
import negocios.tipos_item.ItensAtk.*;
import negocios.tipos_item.ItensConsumiveis.CuraGrande;
import negocios.tipos_item.ItensConsumiveis.CuraMedia;
import negocios.tipos_item.ItensConsumiveis.CuraPequena;
import negocios.tipos_item.ItensConsumiveis.Garrafa;
import telas.Inventario_EscolherNovoItem;
import telas.ScreenManager;
import telas.Sprite;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    GameManager gameManager = new GameManager();
    gameManager.gameLoop();

    // tela.setMargin(33);
    // tela.toggleFrame();
    // fica bugadinho
    // tela.drawMainMenuScreen();
    // tela.renderScreen();






    /*
    Inventario inventario = new Inventario();
    inventario.setItem(new CuraGrande(), 1);
    inventario.setItem(new EspadaFantasma(), 2);
    inventario.setItem(new CuraPequena(), 3);
    inventario.setItem(new EspadaBasica(), 4);
    inventario.setItem(new EspadaManeira(), 5);
    inventario.setItem(new CuraMedia(), 7);
    inventario.setItem(new PedraPolimento(), 8);



    ArrayList<Item> itemsInventario = new ArrayList<Item>();
    ArrayList<Item> items = new ArrayList<Item>();

    tela.setMargin(33);
    tela.toggleFrame();

    tela.drawInventoryMain(inventario);
    tela.renderScreen();
    tela.drawInventorySwap(inventario, 1, new CuraMedia(), "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", "012345678910111213141516171819");
    tela.renderScreen();

    System.out.println(inventario.itensDeAtaqueFunctionCall(20));

    
    Jogador player = new Jogador("Trabalho de PE",0, inventario, 100, 100, 50, 0);
    player.setSpriteList(Spritesheets.getCavaleirinho());
    Inimigo enemy = new Inimigo("Felicien", null,items, 100, 100, 10, 0);

    Inimigo enemy2 = new Inimigo("Elon Musk", null,items, 100, 100, 10, 0);

    Inimigo enemy3 = new Inimigo("snope", null,items, 999, 999, 10, 20);
    enemy3.setSpriteList(Spritesheets.getEsnupi());

    Batalha batalha1 = new Batalha(20, player, enemy, inventario);
    Batalha batalha2 = new Batalha(20, player, enemy2, inventario);
    Batalha batalha3 = new Batalha(20, player, enemy3, inventario);    

    GameManager manager = new GameManager(batalha1, tela);
    manager.iniciarBatalha(batalha1);
    manager.controleTurno(batalha1);

    manager.iniciarBatalha(batalha2);
    manager.controleTurno(batalha2);

    manager.iniciarBatalha(batalha3);
    manager.controleTurno(batalha3);
    */
  }
}