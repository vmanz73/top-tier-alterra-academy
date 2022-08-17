import java.util.Scanner; 
public class exponential {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("input number x: ");
        int x= input.nextInt();
        System.out.print("input number n: ");
        int n= input.nextInt();
        int result=1, i;

        for(i=1; i<=n; i++){
            result = result * x;
        }
        System.out.println("result : " + result);
    }
}
