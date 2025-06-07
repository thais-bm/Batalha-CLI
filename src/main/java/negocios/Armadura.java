package negocios;

public class Armadura extends Item{
    private float defesaBonus;

    public Armadura(String nome, String descricao, float defesaBonus) {
        super(nome, descricao);
        this.defesaBonus = defesaBonus;
    }

    public float getDefesaBonus(){
        return this.defesaBonus;
    }

    public void setDefesaBonus(float defesaBonus){
        this.defesaBonus = defesaBonus;
    }


}
