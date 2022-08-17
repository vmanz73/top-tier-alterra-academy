import java.util.Scanner; 
public class Faktor {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("input number: ");
        int n = input.nextInt();
        int i;
        for (i=1; i<=n; i++){
            if (n%i == 0){
                System.out.println(i);
            }
        }
    }

}
