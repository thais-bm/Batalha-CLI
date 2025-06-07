// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import telas.ScreenManager;
import telas.Sprite;
import negocios.Jogador;
import negocios.Spritesheets;
import negocios.Inimigo;

public class Main {
  public static void main(String[] args) {
    ScreenManager tela = new ScreenManager();
    Jogador player = new Jogador(0, null, 0, 0, 0, 0);
    Inimigo enemy = new Inimigo("", null, 0, 0, 0, 0);
    tela.updatePlayerSprite(new Sprite(player.getSpriteList()));
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
    tela.renderScreen();
  }
}