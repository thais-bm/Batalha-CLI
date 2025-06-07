package negocios;
import java.util.ArrayList;

public class Entidade {
    private float max_vida;
    private float min_vida = 0;
    private float vida;
    private float atk;
    private float def;
    private ArrayList<String> spritelist;

    public Entidade(float max_vida,float vida, float atk, float def) {
        this.max_vida = max_vida;
        this.vida = vida;
        this.atk = atk;
        this.def = def;
    }

    //Getters e setters
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
    //Os parametros estao errados mas é so pra nao dar erro
    public void atacar(Entidade entidade) {

    }

    public void defender(Entidade entidade) {

    }

    public boolean seVivo(){
        return false;
    }

    public void sofrerDano(Entidade entidade) {

    }

    public void draw(Entidade entidade) {

    }

}
