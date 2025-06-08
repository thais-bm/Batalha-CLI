package telas;
import java.util.ArrayList;
import negocios.Inimigo;
import negocios.*;



public class ScreenManager {
    private ArrayList<String> tela;
    int lineamount;
    int linesize;
    int margin;
    boolean frame;

    //construtor, claro, n pode faltar
    public ScreenManager() {
        frame = false;
        margin = 0;
        lineamount = 20;
        linesize = 90;
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
    }

    public ArrayList<String> getScreen() {
        return tela;
    }

    //simplesmente faz o print da tela principal
    //com uma margem se habilitado
    //tambem com uma moldura se habilitado
    public void renderScreen() {
        System.out.println("");
        System.out.println("");

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

    //sequencia de metodos que desenha a tela completa de batalha na tela
    //não inclui a renderização. lembra de chamar o método renderScreen depois
    //basta usar os objetos Jogador e Inimigo como argumento, e a extração dos valores necessários vai ser automática
    //como argumentos extras, pode opcionalmente colocar 1 a 4 Strings que vão aparecer como opções do menu
    public void drawBattleScreen(Jogador jogador, Inimigo inimigo, String... args) {
        clear();
        telabatalha.drawUI(tela);
        telabatalha.drawPlayerSprite(tela, new Sprite(jogador.getSpriteList()));
        telabatalha.drawEnemySprite(tela, new Sprite(inimigo.getSpriteList())); //hp arredondado pra cima se nao for inteiro
        telabatalha.drawHPBar(tela, (int) (jogador.getVida() + 0.9999), (int) (jogador.getMax_vida() + 0.9999), "jogador");
        telabatalha.drawHPBar(tela, (int) (inimigo.getVida() + 0.9999), (int) (inimigo.getMax_vida() + 0.9999), "inimigo");
        telabatalha.drawMenuOptions(tela, args);
        telabatalha.drawName(tela, jogador.getNome(), "jogador");
        telabatalha.drawName(tela, inimigo.getNome(), "inimigo");
    }

    //sequencia de metodos que desenha tela inicial do inventario aberto
    //basta usar o objeto Inventario como argumento, e a extração dos valores necessários vai ser automática
    //como argumentos extras, pode opcionalmente colocar 1 a 2 Strings que vão aparecer como opções do menu
    public void drawInventoryMain(Inventario inventario, String... args) {
        clear();
        TelaInventario.drawUI(tela);
        for (int i = 1; i < 9; i++) {
            if (inventario.getItem(i) != null) {
                Sprite sprite = new Sprite(inventario.getItem(i).getSpriteList());
                if (sprite != null) {TelaInventario.drawItem(tela, sprite, i);}
            }
            else {TelaInventario.drawItem(tela, SpritesInterface.getEmptySlot(), i);}
        }
        TelaInventario.drawOptions(tela, args);
    }

    //sequencia de metodos que desenha pagina do inventario com item selecionado
    //basta usar o objeto Inventario e o número do slot do item selecionado como argumento, e a extração dos valores necessários vai ser automática
    //como argumentos extras, pode opcionalmente colocar 1 a 2 Strings que vão aparecer como opções do menu
    public void drawInventoryItemSelected(Inventario inventario, int index, String... args) {
        clear();
        Inventario_ItemSelecionado.drawUI(tela);
        Item item = inventario.getItem(index);
        String[] itemdesc = null;
        Sprite itemsprite = null;
        if (item != null) {
            itemdesc = item.getDescricao();
            itemsprite = new Sprite(item.getSpriteList());
        }
        if (itemsprite != null) {
            Inventario_ItemSelecionado.drawItem(tela, itemsprite);
            Inventario_ItemSelecionado.drawOptions(tela, args);
        } 
        if (itemdesc != null) {
            Inventario_ItemSelecionado.drawDesc(tela, itemdesc, "");
        }
    }


    //sequencia de metodos que desenha na tela o inventario durante a comparação entre um item novo e um selecionado
    //como argumentos, usar objeto Inventario, numero do slot do item selecionado, e objeto Item inteiro do novo item, e a extração dos valores necessários vai ser automática
    //como argumentos extras, pode opcionalmente colocar 1 a 2 Strings que vão aparecer como opções do menu
    public void drawInventorySwap(Inventario inventario, int index1, Item item2, String... args) {
        clear();
        Inventario_ItemSelecionado.drawSwapUI(tela);
        Item item1 = inventario.getItem(index1);
        String[] itemdesc1 = null;
        Sprite itemsprite1 = null;
        if (item1 != null) {
            itemdesc1 = item1.getDescricao();
            itemsprite1 = new Sprite(item1.getSpriteList());
        }

        String[] itemdesc2 = null;
        Sprite itemsprite2 = null;
        if (item2 != null) {
            itemdesc2 = item2.getDescricao();
            itemsprite2 = new Sprite(item2.getSpriteList());
        }

        if (itemsprite1 != null) Inventario_ItemSelecionado.drawItem(tela, itemsprite1, "swap1");
        if (itemsprite2 != null) Inventario_ItemSelecionado.drawItem(tela, itemsprite2, "swap2");
        if (itemdesc1 != null) Inventario_ItemSelecionado.drawDesc(tela, itemdesc1, "swap1");
        if (itemdesc2 != null) Inventario_ItemSelecionado.drawDesc(tela, itemdesc2, "swap2");

        Inventario_ItemSelecionado.drawOptions(tela, args);
    }

    public void drawMainMenuScreen(){
        clear();
        MenuPrincipal.drawUI(tela);
    }
}