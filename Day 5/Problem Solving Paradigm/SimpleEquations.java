import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleEquations {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input Nilai A : ");
        int a = input.nextInt();
        System.out.print("input Nilai B : ");
        int b = input.nextInt();
        System.out.print("input Nilai C : ");
        int c = input.nextInt();
        Map resuList = new HashMap<String, Integer>();
        boolean is_true = false;

        for (int x =1; x<Math.sqrt((double) c); x++){
            for (int y=1; y<=x; y++){
                for(int z=1; z<=x; z++){
                    if ((x + y + z) == a && (x * y * z) == b && (((x*x)+ (y*y) + (z*z)) == c)){
                        is_true= true;
                        resuList.put('x', x);
                        resuList.put('y', y);
                        resuList.put('z', z);
                        break;
                    }
                }
            }
        }
        if (is_true){
            System.out.println(resuList);
        }
        else{
            System.out.println("no solution !!");
        }
        
    }
}