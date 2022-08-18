import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; 

public class ArrayUnique {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        System.out.print("input number list-2: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        for (int i=0; i<text.length(); i++)
        {
            mylist.add(Integer.parseInt(String.valueOf( text.charAt(i))));
        }

        ArrayList<Integer> mylist2 = new ArrayList<>();
        System.out.print("input number list-1: ");
        String text2 = input.nextLine();

        for (int i=0; i<text2.length(); i++)
        {
            mylist2.add(Integer.parseInt(String.valueOf( text2.charAt(i))));
        }
        
        mylist.addAll(mylist2);

        System.out.println("array merged : ");
        System.out.println(mylist);

        Set<Integer> s = new HashSet<Integer>();

        for(Integer number : mylist) {
            s.add(number);
        }
        System.out.println("remove array duplicate : ");
        System.out.println(s);
    }
}
