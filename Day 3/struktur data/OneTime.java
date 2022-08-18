import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OneTime {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        System.out.print("input number list: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        for (int i=0; i<text.length(); i++)
        {
            mylist.add(Integer.parseInt(String.valueOf( text.charAt(i))));
        }

        Set<Integer> s = new HashSet<Integer>();

        for(Integer name : mylist) {
            if(s.add(name) == false)
                s.remove(name);
        }
        System.out.println(s);
    }
}
