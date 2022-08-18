import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PairTarget {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        ArrayList<Integer> myresultlist = new ArrayList<>();
        System.out.print("input number list: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.print("input target: ");
        int target = input.nextInt();  
        int result = 0;

        for (int i=0; i<text.length(); i++)
        {
            mylist.add(Integer.parseInt(String.valueOf( text.charAt(i))));
        }
        
        SortedSet<Integer> temp = new TreeSet<Integer>();
        for(Integer number : mylist) {
            temp.add(number);
        }
        
        while(result != target){
            result = temp.first() + temp.last();
            if(result != target){
                if (target > result){
                    temp.remove(temp.first());
                }
                else{
                    temp.remove(temp.last());
                }
            }
        
        }

        myresultlist.add(mylist.indexOf(temp.first()));
        myresultlist.add(mylist.indexOf(temp.last()));

        System.out.println(myresultlist);
    }
}
