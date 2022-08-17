import java.util.Scanner;
public class multiplication {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("input number: ");
        int n = input.nextInt();
        int x, i;

        for(i=1; i<=n; i++){
            for(x=1; x<=n; x++){
                System.out.print((x*i) + "\t");
            }
            System.out.println("");
        }

    }
}
