package discussion;

public class Foo {
    public int x, y;

         public Foo (int x, int y) {
         this.x = x;
         this.y = y;
         }

         public static void switcheroo (Foo a, Foo b) {
         Foo temp = a;
         a = b;
         b = temp;
         }

         public static void fliperoo (Foo a, Foo b) {
         Foo temp = new Foo(a.x, a.y);
         a.x = b.x;
         a.y = b.y;
         b.x = temp.x;
         b.y = temp.y;
         }

         public static void swaperoo (Foo a, Foo b) {
         Foo temp = a;
         a.x = b.x;
         a.y = b.y;
         b.x = temp.x;
         b.y = temp.y;
         }

         public static void main (String[] args) {
         Foo foobar = new Foo(10, 20);
         Foo baz = new Foo(30, 40);
         switcheroo(foobar, baz);
         System.out.print("foobar.x:"+ foobar.x + " " + "foobar.y:"+ foobar.y + " ");
         System.out.println("baz.x: " + baz.x + " " + "baz.y: " + baz.y);
         fliperoo(foobar, baz);
         System.out.print("foobar.x:"+ foobar.x + " " + "foobar.y:"+ foobar.y + " ");
         System.out.println("baz.x: " + baz.x + " " + "baz.y: " + baz.y);
         swaperoo(foobar, baz);
         System.out.print("foobar.x:"+ foobar.x + " " + "foobar.y:"+ foobar.y + " ");
         System.out.println("baz.x: " + baz.x + " " + "baz.y: " + baz.y);
         }
}
