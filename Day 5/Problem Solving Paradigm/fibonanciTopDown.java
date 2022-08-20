import java.util.Scanner;

class Fibonacci {
    int[] cache;

    public Fibonacci(int[] cache){
        this.cache = cache;
    }

    int topdown(int n) {
        if (cache[n] == 0) {
            if (n < 2) cache[n] = n;
            else cache[n] = topdown(n-1) + topdown( n-2);
        }

        return cache[n];
    }
}

public class fibonanciTopDown {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input ke-n : ");
        int n = input.nextInt();
        System.out.println(new Fibonacci(new int[n+1]).topdown(n));
    }
}
