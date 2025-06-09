package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import negocios.*;
import negocios.tipos_item.ItensAtk.*;
import negocios.tipos_item.ItensConsumiveis.CuraGrande;
import negocios.tipos_item.ItensConsumiveis.CuraMedia;
import negocios.tipos_item.ItensConsumiveis.CuraPequena;
import negocios.tipos_item.ItensDef.EscudoFoda;
import negocios.tipos_item.ItensDef.EscudoMarroMeno;
import negocios.tipos_item.ItensDef.EscudoRuim;
import telas.MenuPrincipal;
import telas.ScreenManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;


/*
    Explicando o que vou fazer aqui!
    Vou salvar os atributos em um arquivo JSON porque, pelo que eu analisei
    sendo um arquivo JSON vai facilitar a questao de delimitar informacao e afins

    ainda mais porque ele parece mais simple de lidar
 */

public class SaveManager {
    private static final String NOME_ARQUIVO = "src/saves/save_01.json";
    // Adicione todas as suas subclasses de Item aqui
    // O campo 'type' será a etiqueta no JSON
    // Se for uma Pocao, a etiqueta será "pocao"
    private static final RuntimeTypeAdapterFactory<Item> itemAdapterFactory =
            RuntimeTypeAdapterFactory.of(Item.class, "type")
                    .registerSubtype(CuraGrande.class, "curaGrande")
                    .registerSubtype(CuraMedia.class, "curaMedia")
                    .registerSubtype(CuraPequena.class, "curaPequena")
                    .registerSubtype(EspadaBasica.class, "EspadaBasica")
                    .registerSubtype(EspadaFantasma.class, "EspadaFantasma")
                    .registerSubtype(EspadaManeira.class, "EspadaManeira")
                    .registerSubtype(PedraPolimento.class, "PedraPolimento")
                    .registerSubtype(EscudoFoda.class, "EscudoFoda")
                    .registerSubtype(EscudoMarroMeno.class, "EscudoMarroMeno")
                    .registerSubtype(EscudoRuim.class, "EscudoRuim")
                    .registerSubtype(EspadaBacaninha.class, "EspadaBacaninha");

    // 2. Crie o objeto Gson registrando a fábrica que acabamos de configurar
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapterFactory(itemAdapterFactory)
            .setPrettyPrinting()
            .create();

    /*
    SALVAR -> Pega os atributos do jogador e armazena num arquivo JSON
        = nome;
        = max_vida;
        = vida;
        = atk;
        = def;
        = max_inv_tam;
        = inventário;
        = sprite;
        = armadura;
        = arma;

     Primeira vez -> cria o arquivo
     varias vezes -> apenas sobreescreve
     */
    public static void Salvar(Jogador player){
        try (FileWriter writer = new FileWriter(NOME_ARQUIVO)){
            GSON.toJson(player, writer);
            System.out.println("Salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo!");
        }
    }

    public static Jogador Carregar(){
        File arquivo = new File(NOME_ARQUIVO);

        if (arquivo.exists()){
            try (FileReader reader = new FileReader(NOME_ARQUIVO)){
                Jogador player = GSON.fromJson(reader, Jogador.class);
                return player;
            } catch (IOException e) {
                System.out.println("Erro ao carregar o arquivo!");
            }
        }
        else{
            System.out.println("Arquivo nao encontrado");
        }
        return null;
    }

    public static void main(String[] args) {
        // AREA DE TESTES
        // Nao ta salvando objetos como o Inventario INV
        // TODO: mexer apenas quando estiver pronto

        Inventario inventario = new Inventario();
        inventario.setItem(new CuraGrande(), 1);
        inventario.setItem(new EspadaFantasma(), 2);
        inventario.setItem(new CuraPequena(), 3);
        inventario.setItem(new EspadaBasica(), 4);
        inventario.setItem(new EspadaManeira(), 5);
        inventario.setItem(new CuraMedia(), 7);
        inventario.setItem(new PedraPolimento(), 8);
        Jogador player = new Jogador("Trabalho de PE",0, inventario, 100, 100, 50, 0);
        player.setSpriteList(Spritesheets.getCavaleirinho());
        SaveManager.Salvar(player);

        player = null;

        player = SaveManager.Carregar();
        if (player == null){
            System.out.println("Erro ao carregar o arquivo!");
        } else {
            System.out.println("Arquivo carregado!");
            System.out.println("Nome: " + player.getNome());
            System.out.println("ATK: "+ player.getAtk());
            System.out.println("DEF: "+ player.getDef());
            System.out.println("MAX VIDA: " + player.getMax_vida());
            System.out.println("MIN VIDA: "+player.getMin_vida());
            System.out.println("VIDA: "+ player.getVida());
            System.out.println("SPRITE LIST: "+player.getSpriteList());
        }

        // RENDERIZANDO MENU
        ScreenManager tela = new ScreenManager();
        MenuPrincipal.drawUI(tela.getScreen());
        tela.renderScreen();

        // RECEBENDO COMANDOS




    }

}
