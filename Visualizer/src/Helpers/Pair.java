package Helpers;

/**
 * Created by batto on 09-Mar-17.
 */
public class Pair<T, T1> {
    private T first;
    private T1 second;

    public Pair(T first, T1 second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T1 getSecond() {
        return second;
    }

    public void setSecond(T1 second) {
        this.second = second;
    }


}
