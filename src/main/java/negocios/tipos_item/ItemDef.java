package negocios.tipos_item;
import negocios.Item;
import negocios.Jogador;

public abstract class ItemDef extends Item {
    public ItemDef(String nome, String... descricao) {
        super(nome, descricao);
    }
    
    public abstract int Efeito(int entrada, Jogador jogador);
}
