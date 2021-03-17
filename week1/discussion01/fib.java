package week1.discussion;

public class fib{
    
    private int calFib(int i){
      if (i == 0) {
          return 0;
      } else if (i == 1 ) {
          return 1;
      } else {
          return calFib(i-1) + calFib(i-2);
      }
    }

    private void showFib(int n){
        for (int i = 2; i <= n; i++) {
            System.out.print(calFib(i) + " ");
        }
    }

    public static void main(String[] args) {
        new fib().showFib(5);
    }
}