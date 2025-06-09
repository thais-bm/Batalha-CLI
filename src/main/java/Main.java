

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
  }
}