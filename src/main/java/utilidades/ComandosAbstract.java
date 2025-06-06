package utilidades;
import java.util.ArrayList;
public abstract class ComandosAbstract<Type1, Type2> {
    //Argumento 1: Lista de termos Dict
    //Argumento 2: Chave pra buscar na lista
    //Encontra o primeiro Dict com essa chave e retorna o valor associado, ou null se não achar nada
    public static <Type1, Type2> Type2 searchDict(ArrayList<Dict<Type1, Type2>> lista, Type1 key) {
        int size = lista.size();
        //criar uma variável pra guardar o tamanho da lista é um pouquinho mais eficiente que verificar o tamanho
        //da lista dentro da declaração do loop porque não vai chamar o método .size toda vez que rodar o loop
        //a diferença é pequena mas é uma boa prática
        for (int i = 0; i < size; i++) {
            Dict<Type1, Type2> dict = lista.get(i);
    //usar comparação "==" funciona pra valores primitivos como int e char
    //mas no java, String é uma classe mais avançada construida em cima do String, ou seja
    //cada string é um objeto diferente, então é necessário usar .equals()
    //porque .equals() compara o conteúdo dentro do objeto e não só a referência de memória
            if (dict.equals(key)) {
                return dict.getValue();
            }
        }
        return null;
        //Null joined the game
        //>Can you see me?
        //>Hello?
        //>Who are you?
    }
}
