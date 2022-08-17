import java.util.Scanner;

public class xo{
    public static void main(String args[]){
        int x = 0, o=0;
        System.out.print("input xo: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine().toLowerCase();

        for (int i=0 ; i<text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'x'){
                x++;
            }
            else if(ch == 'o'){
                o++;
            }
        }
        if (x == o){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}