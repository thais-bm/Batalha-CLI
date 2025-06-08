package negocios;
import java.util.ArrayList;

public abstract class Item {
    private ArrayList<String> spritelist;
    private String nome;
    private String raridade;
    private String[] descricao;
    private Inventario inventario;


    public Item(String nome, String... descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    //Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String[] getDescricao() {
        return descricao;
    }
    public void setDescricao(String... descricao) {
        this.descricao = descricao;
    }
    public String getRaridade() {
        return raridade;
    }
    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }
    public void setSpriteList(ArrayList<String> spritelist) {
        this.spritelist = spritelist;
    }
    public ArrayList<String> getSpriteList() {
        return spritelist;
    }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    public Inventario getInventario() {
        return inventario;
    }

}
