package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import negocios.*;

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
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

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
                Jogador jogador = GSON.fromJson(reader, Jogador.class);
                return jogador;
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

        Inventario inv = new Inventario();

        Jogador jogador = new Jogador("Max", 8, inv, 100, 80, 10, 20);
        SaveManager.Salvar(jogador);

        jogador = null;

        jogador = SaveManager.Carregar();
        if (jogador == null){
            System.out.println("Erro ao carregar o arquivo!");
        } else {
            System.out.println("Arquivo carregado!");
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("ATK: "+ jogador.getAtk());
            System.out.println("DEF: "+ jogador.getDef());
            System.out.println("MAX VIDA: " + jogador.getMax_vida());
            System.out.println("MIN VIDA: "+jogador.getMin_vida());
            System.out.println("VIDA: "+ jogador.getVida());
            System.out.println("MAX INV: "+ jogador.getMax_inv_tam());
            System.out.println("SPRITE LIST: "+jogador.getSpriteList());
        }




    }

}
