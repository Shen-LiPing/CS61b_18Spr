package Lecture04.src;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public void addAdjacent() {
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.rest.first += p.first;
                p = new IntList(p.rest.first, p.rest.rest);
            } else {
                p = this.rest;
            }
        }
    }


    public static void main(String[] args) {
        IntList one = new IntList(1,null);
        one.rest = new IntList(1, null);
        one.rest.rest = new IntList(2,null);
        one.rest.rest.rest = new IntList(3,null);
        one.addAdjacent();
    }

}
