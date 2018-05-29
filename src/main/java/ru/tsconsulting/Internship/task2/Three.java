package ru.tsconsulting.Internship.task2;

public class Three<K, V1, V2> {
    private K k;
    private V1 v1;
    private V2 v2;
    public Three(K k, V1 v1, V2 v2) {
        this.k = k;
        this.v1 = v1;
        this.v2 = v2;
    }
    public K getKey() {
        return k;
    }
    public V1 getValue1() {
        return v1;
    }
    public V2 getValue2() {
        return v2;
    }
//    @Override
//    public int hashCode() {
//        return 37*(int)getKey()*(getValue1().hashCode())*(getValue1().hashCode());
//    }
//    @Override
//    public boolean equals(Three<K,V1,V2> o) {
//        if (o instanceof Three)
//        Three three = (Three) o;
//        return (this.getKey() == )
//        return (this.k.equals(o.getKey()) && this.getValue1().equals(o.getValue1()) && this.getValue2().equals(o.getValue2()));
//    }
}
