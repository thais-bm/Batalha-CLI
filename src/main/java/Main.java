// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import negocios.*;
import telas.ScreenManager;
import telas.Sprite;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ScreenManager tela = new ScreenManager();


    ArrayList<Item> itemsInventario = new ArrayList<Item>();
    Inventário inventário = new Inventário(8,0,itemsInventario);

    Armadura armaduraFerro = new Armadura("Armadura de ferro", "+10 Defesa", 10);
    Armadura armaduraDiamante = new Armadura("Armadura de diamante", "+15 Defesa", 15);
    Armadura armaduraNetherite = new Armadura("Armadura de netherite", "+20 Defesa", 20);

    ArrayList<Item> items = new ArrayList<Item>();

    Arma espadaFerro = new Arma("Espada de ferro", "+10 Ataque", 10);
    Arma espadaDiamante = new Arma("Espada de diamante", "+15 Ataque", 15);
    Arma arco = new Arma("Arco", "+10 Ataque", 10);


    items.add(armaduraFerro);
    items.add(armaduraDiamante);
    items.add(armaduraNetherite);

    Jogador player = new Jogador("Trabalho de PE",0, null, 100, 100, 50, 0);
    Inimigo enemy = new Inimigo("Felicien", null,items, 100, 100, 10, 0);

    Inimigo enemy2 = new Inimigo("Elon Musk", null,items, 100, 100, 10, 0);

    Batalha batalha1 = new Batalha(20, player, enemy, inventário);

    Batalha batalha2 = new Batalha(20, player, enemy2, inventário);

    GameManager manager = new GameManager(batalha1);
    manager.iniciarBatalha(batalha1);
    manager.controleTurno(batalha1);

    manager.iniciarBatalha(batalha2);
    manager.controleTurno(batalha2);




    /*tela.updatePlayerSprite(new Sprite(player.getSpriteList()));
    tela.updateInimigoSprite(new Sprite(enemy.getSpriteList()));
    //tela.drawBattleScreen();
    tela.updateItemSprite(Spritesheets.getEspadinha(), 1);
    tela.updateItemSprite(Spritesheets.getEspadinha(), 2);
    tela.updateItemSprite(Spritesheets.getEspadinha(), 3);
    tela.updateItemSprite(Spritesheets.getEspadinha(), 4);
    tela.updateItemSprite(Spritesheets.getEspadinha(), 5);
    tela.updateItemSprite(Spritesheets.getEspadinha(), 7);
    tela.drawInventoryMain();
    tela.toggleFrame();
    tela.setMargin(15);
    tela.renderScreen();*/


  }
}