package negocios;

public class Arma extends Item{
    private float danoBonus;

    public Arma(String nome, String descricao, float danoBonus) {
        super(nome, descricao);
        this.danoBonus = danoBonus;
    }

    public float getDanoBonus() {
        return danoBonus;
    }

    public void setDanoBonus(float danoBonus) {
        this.danoBonus = danoBonus;
    }
}
