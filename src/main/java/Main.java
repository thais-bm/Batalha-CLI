// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import negocios.Batalha;
import telas.ScreenManager;
import telas.Sprite;
import negocios.Jogador;
import negocios.Spritesheets;
import negocios.Inimigo;

public class Main {
  public static void main(String[] args) {
    ScreenManager tela = new ScreenManager();

    Jogador player = new Jogador("Trabalho de PE",0, null, 100, 100, 20, 0);
    Inimigo enemy = new Inimigo("Felicien", null,null, 100, 100, 10, 0);

    Batalha batalha = new Batalha(4, player, enemy, true);
    batalha.iniciarTurnos(enemy, player);

    /*tela.updatePlayerSprite(new Sprite(player.getSpriteList()));
    tela.updateInimigoSprite(new Sprite(enemy.getSpriteList()));
    tela.drawBattleScreen();
    tela.toggleFrame();
    tela.setMargin(15);
    tela.renderScreen();*/


  }
}