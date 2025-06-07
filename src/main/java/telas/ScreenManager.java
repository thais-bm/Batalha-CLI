package telas;
import java.util.ArrayList;
import java.util.List;
import negocios.Jogador;
import negocios.Spritesheets;
import negocios.Inimigo;
import java.util.HashMap;
import java.util.Map;



public class ScreenManager {
    private ArrayList<String> tela;
    int lineamount;
    int linesize;
    int margin;
    boolean frame;
    //armazena sprites não fixos e que variam durante gameplay
    //ex: elementos base de UI NÃO precisam entrar nessa lista
    //itens, sprites de personagem, inimigos, entram nessa lista
    Map<String, Sprite> spriteDict;

    //construtor, claro, n pode faltar
    public ScreenManager() {
        frame = false;
        margin = 0;
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
    //com uma margem
    public void renderScreen() {
        String extrastring = "";
        String framestring = "";
        String frameside = "";

        for (int i = 0; i < margin; i++) {
            extrastring += " ";
        }

        if (frame) {
            framestring += extrastring + "X";
            for (int i = 0; i < linesize; i++) {
                framestring += "-";
            }
            framestring += "X";
            frameside = "|";
            System.out.println(framestring);
        }

        for (int i = 0; i < lineamount; i++) {
            System.out.println(extrastring + frameside + tela.get(i) + frameside);
        }

        if (frame) {System.out.println(framestring);}
    }

    //comandos que definem se a tela principal vai ter margem e uma moldura
    public void setMargin(int margem) {
        margin = margem; //se botar negativo aqui provavelmente vai causar erro no renderScreen
        //bom candidato pra depois implementar tratamento de exceção pra realmente usar tudo que o professor ensinou
    }
    public void toggleFrame() {if(frame){frame = false;} else {frame = true;}} //esse é de liga/desliga sempre que chamado
    

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

    //atualiza sprite de um item em um slot específico no inventário
    public void updateItemSprite(Sprite sprite, int itemindex) {
        if (itemindex < 1 || itemindex > 8) {return;}
        spriteDict.put("item"+itemindex, sprite);
    }//arraylist vira sprite mesmo esquema
    public void updateItemSprite(ArrayList<String> spritelist, int itemindex) {
        this.updateItemSprite(new Sprite(spritelist), itemindex);
    }



    //sequencia de metodos que desenha a tela completa de batalha na tela
    //não inclui a renderização. lembra de chamar o método renderScreen depois
    public void drawBattleScreen() {
        clear();
        telabatalha.drawUI(tela);
        telabatalha.drawPlayerSprite(tela, spriteDict.get("jogador"));
        telabatalha.drawEnemySprite(tela, spriteDict.get("inimigo"));
        //MUDAR VALORES DE HP E TEXTO QUANDO GAME MANAGER FOR IMPLEMENTADO
        //PUXAR VALORES DO JOGADOR E INIMIGO DE VERDADE
        //DEIXEI VALORES DE TESTE PRA TUDO
        telabatalha.drawHPBar(tela, 150, 200, "jogador");
        telabatalha.drawHPBar(tela, 99999, 99999, "inimigo");
        telabatalha.drawMenuOptions(tela, "isso é uma opção", "atacar?", "não atacar", "todas as anteriores");
        telabatalha.drawName(tela, "Mano Player", "jogador");
        telabatalha.drawName(tela, "Fantasmagorico da Maldade", "inimigo");
    }

    public void drawInventoryMain() {
        clear();
        TelaInventario.drawUI(tela);
        for (int i = 1; i < 9; i++) {
            Sprite sprite = spriteDict.get("item"+i);
            if (sprite != null) {TelaInventario.drawItem(tela, sprite, i);}
            else {TelaInventario.drawItem(tela, SpritesInterface.getEmptySlot(), i);}
        }
        //primeira string se alinha pra esquerda, segunda pra direita
        //nesse metodo aqui eu nao me dei o trabalho de fazer autoformatar e gerar a numeração
        //porque nessa tela obviamente só vão ter as opções selecionar e voltar
        TelaInventario.drawOptions(tela, " (1 a 8) - SELECIONAR ITEM", "0 - VOLTAR");
    }
}