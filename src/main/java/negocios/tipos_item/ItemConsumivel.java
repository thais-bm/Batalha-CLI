package negocios.tipos_item;
import negocios.Item;

public abstract class ItemConsumivel extends Item{
    public ItemConsumivel(String nome, String... descricao) {
        super(nome, descricao);
        
    }
}
