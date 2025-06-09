package negocios;
import java.util.ArrayList;

public abstract class Entidade {
    private String nome;
    private float max_vida;
    private float min_vida = 0;
    private float vida;
    private float atk;
    private float def;
    private ArrayList<String> spritelist;

    public Entidade(String nome, float max_vida,float vida, float atk, float def) {
        this.nome = nome;
        this.max_vida = max_vida;
        this.vida = vida;
        this.atk = atk;
        this.def = def;
    }

    //Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtk(float atk) {
        this.atk = atk;
    }
    public void setDef(float def) {
        this.def = def;
    }
    public void setMax_vida(float max_vida) {
        this.max_vida = max_vida;
    }
    public void setMin_vida(float min_vida) {
        this.min_vida = min_vida;
    }
    public void setVida(float vida) {
        this.vida = vida;
        if (this.vida < 0) this.vida = 0;
    }
    public void setSpriteList(ArrayList<String> list) {
        this.spritelist = list;
    }

    public float getAtk() {
        return atk;
    }
    public float getDef() {
        return def;
    }
    public float getMax_vida() {
        return max_vida;
    }
    public float getMin_vida() {
        return min_vida;
    }
    public float getVida() {
        return vida;
    }
    public ArrayList<String> getSpriteList() {
        return spritelist;
    }

    //Métodos


    public void atacar(Batalha batalha,Entidade entidade) {

        entidade.vida -= this.atk;

    }

    public void defender(Batalha batalha,Entidade entidade) {

        //adicionar os calculos com a defesa
    }

}
