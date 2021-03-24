public class Exercise221 {

    public static class IntNode {
        public int item;
        private IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

        public IntNode addFirst(int x) {
            IntNode added = new IntNode(x,this);
        return added;
        }
    }

    public static void main(String[] args) {
        IntNode one = new IntNode(1,null);
        IntNode added = one.addFirst(0);

    }

}
