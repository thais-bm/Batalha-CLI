package negocios.tipos_item;
import negocios.Item;
import negocios.Jogador;

public abstract class ItemConsumivel extends Item{
    public ItemConsumivel(String nome, String descricao) {
        super(nome, descricao);
    }

    public abstract void Efeito(Jogador jogador);
}
