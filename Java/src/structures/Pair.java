package src.structures;

/**
 * @author : Natalie Dorshimer
 * @since : 9/5/2020, Sat
 **/
public class Pair<T1, T2> {
    private T1 i1;
    private T2 i2;
    public Pair(T1 i1, T2 i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public T1 getKey() {
        return i1;
    }

    public T2 getValue() {
        return i2;
    }
}
