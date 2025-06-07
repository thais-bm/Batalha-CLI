package telas;
import java.util.ArrayList;
import java.util.List;
import negocios.Jogador;
import negocios.Inimigo;
import java.util.HashMap;
import java.util.Map;



public class ScreenManager {
    private ArrayList<String> tela;
    int lineamount;
    int linesize;
    //armazena sprites não fixos e que variam durante gameplay
    //ex: elementos base de UI NÃO precisam entrar nessa lista
    //itens, sprites de personagem, inimigos, entram nessa lista
    Map<String, Sprite> spriteDict;

    //construtor, claro, n pode faltar
    public ScreenManager() {
        lineamount = 20;
        linesize = 90;
        spriteDict = new HashMap<String, Sprite>();
        tela = new ArrayList<String>();
        for (int i = 0; i < lineamount; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < linesize; j++) {
                builder.append(" ");
            }
            tela.add(builder.toString());
        }
        ArrayList<String> tempemptysprite = new ArrayList<String>();
        tempemptysprite.add(" ");
        updatePlayerSprite(new Sprite(tempemptysprite));
        updateInimigoSprite(new Sprite(tempemptysprite));
    }

    //autoexplicativo
    public ArrayList<String> getScreen() {
        return tela;
    }

    //simplesmente faz o print da tela principal
    public void renderScreen(){
        for (int i = 0; i < lineamount; i++) {
            System.out.println(tela.get(i));
            }
        }
    
    //limpa a tela principal
    public void clear() {
        for (int i = 0; i < tela.size(); i++) {
            String newstring = "";
            for (int j = 0; j < linesize; j++) {
                newstring += " ";
            }
            tela.set(i, newstring);
        }
    }

    //atualiza sprite atual do jogador para tela de batalha
    public void updatePlayerSprite(Sprite sprite) {
        spriteDict.put("jogador", sprite);
    } //tambem funciona se colocar só o ArrayList, automaticamente criando um objeto tipo Sprite com ele
    public void updatePlayerSprite(ArrayList<String> spritelist) {
        this.updatePlayerSprite(new Sprite(spritelist, 6, 0));
    }

    //atualiza sprite de inimigo utilizado na tela de batalha
    public void updateInimigoSprite(Sprite sprite) {
        spriteDict.put("inimigo", sprite);
    } //tambem funciona se bla bla bla mesma coisa que o outro
    public void updateInimigoSprite(ArrayList<String> spritelist) {
        this.updateInimigoSprite(new Sprite(spritelist, 0, 48));
    }



    //sequencia de metodos que desenha a tela completa de batalha na tela
    //não inclui a renderização. lembra de chamar o método renderScreen depois
    public void drawBattleScreen() {
        clear();
        telabatalha.drawUI(tela);
        telabatalha.drawPlayerSprite(tela, spriteDict.get("jogador"));
        telabatalha.drawEnemySprite(tela, spriteDict.get("inimigo"));
        //MUDAR VALORES DE HP QUANDO GAME MANAGER FOR IMPLEMENTADO
        //PUXAR VALORES DO JOGADOR E INIMIGO DE VERDADE
        //DEIXEI VALORES DE TESTE
        telabatalha.drawHPBar(tela, 150, 200, "jogador");
        telabatalha.drawHPBar(tela, 243, 300, "inimigo");
    }

}