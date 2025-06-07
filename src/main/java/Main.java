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


    tela.setMargin(33);
    tela.toggleFrame();

    items.add(armaduraFerro);
    items.add(armaduraDiamante);
    items.add(armaduraNetherite);

    Jogador player = new Jogador("Trabalho de PE",0, null, 100, 100, 21, 0);
    Inimigo enemy = new Inimigo("Felicien", null,items, 100, 100, 12, 0);

    tela.updatePlayerSprite(player.getSpriteList());
    tela.updateInimigoSprite(enemy.getSpriteList());
    tela.updatePlayerData(player);
    tela.updateEnemyData(enemy);
    tela.updateItemSprite(Spritesheets.getEspadaMinecraft(), 1);
    tela.updateItemDesc(1, "- ESPADA DE DIAMANTE -",
                                       "Sharpness V | Fire Aspect II | Looting III",
                                       "11 dano por golpe, 1.6 velocidade de ataque",
                                       "Durabilidade:  946/1561",
                                       "Se a formatação funcionar essa linha não vai aparecer e não vai dar erro"
                                       );
    tela.updateItemSprite(Spritesheets.getPicaretaMinecraft(), 2);
    tela.updateItemDesc(2, "- PICARETA DE FERRO -",
                                       "Efficiency IV | Unbreaking III | Silk Touch",
                                       "4 dano por golpe, 1.2 velocidade de ataque",
                                       "Durabilidade:  231/250",
                                       "Se a formatação funcionar essa linha não vai aparecer e não vai dar erro"
                                       );
    tela.drawBattleScreen();
    tela.renderScreen();
    tela.drawInventoryMain();
    tela.renderScreen();
    tela.drawInventoryItemSelected(1, "1 - Usar                 3 - Descartar                         ",
                                                    "2 - Mudar posicao        4 - Comer                   0 - Voltar");
    tela.renderScreen();
    tela.drawInventorySwap(1, 2, "1 - Aceitar novo item                                          ",
                                                       "2 - Cancelar troca                                   0 - Voltar");
    tela.renderScreen();
    Batalha batalha = new Batalha(20, player, enemy, inventário,true);


    GameManager manager = new GameManager(batalha);
    manager.iniciarBatalha();
    manager.controleTurno();

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