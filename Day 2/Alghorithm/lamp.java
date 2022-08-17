import java.util.Scanner; 

public class lamp{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = 0, i; 
        for (i=1; i <= n; i++){
            if ( n % i == 0) {
                d++;
            }
        }
        if ( d % 2 == 0) {
            System.out.println("lampu mati");
        }
        else {
            System.out.println("lampu nyala");
        }
    }
}