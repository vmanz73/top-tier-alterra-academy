import java.util.Scanner;
public class palindrome {
    public static void main (String[] args) {
        System.out.print("input text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine().toLowerCase();
        String nstr="";
        char ch;
        

        for (int i=0; i<text.length(); i++)
        {
            ch= text.charAt(i);
            nstr= ch+nstr;
        }
        System.out.println(text);
        System.out.println(nstr);
        if(text.equals(nstr)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Bukan Palindrome");
        }
    }
}
