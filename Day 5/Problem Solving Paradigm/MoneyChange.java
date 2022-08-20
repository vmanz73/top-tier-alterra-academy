import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class MoneyChange {

    static ArrayList<Integer> change(int Val, Integer[] money_list)
    {
        SortedSet <Integer> money = new TreeSet<Integer>(Arrays.asList(money_list)).descendingSet();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer value : money){
            while (Val >= value) 
            {
                Val -= value;
                result.add(value);
            }
        }
        return result;
    }
    public static void main(String []args) {
        Integer[] money_list = new Integer[] {1, 10, 20, 50, 200, 100,  500, 1000, 2000, 5000, 10000};
        Scanner input = new Scanner(System.in);
        System.out.println("Input uang yang akan di tukar: ");
        int money = input.nextInt();
        System.out.println(change(money, money_list));
        
    }
}
