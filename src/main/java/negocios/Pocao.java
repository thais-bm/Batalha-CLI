package negocios;

public class Pocao extends Item{
    private float curaBonus;

    public Pocao(String nome, String descricao, float curaBonus) {
        super(nome, descricao);
        this.curaBonus = curaBonus;
    }

    public float getCuraBonus() {
        return curaBonus;
    }

    public void setCuraBonus(float curaBonus){
        this.curaBonus = curaBonus;
    }

}
