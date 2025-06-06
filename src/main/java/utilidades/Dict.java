package utilidades;

public class Dict<Type1, Type2> {
    private Type1 key;
    private Type2 value;
    public Dict(Type1 key, Type2 value) {
        this.key = key;
        this.value = value; 
    }
    public Type1 getKey() {
        return key;
    }
    public Type2 getValue() {
        return value;
    }
}
