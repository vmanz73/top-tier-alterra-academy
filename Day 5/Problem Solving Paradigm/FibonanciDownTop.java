import java.util.Scanner;

public class FibonanciDownTop {

    static int downtop(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input ke-n : ");
        int n = input.nextInt();
        System.out.println(downtop(n));
    }
}
