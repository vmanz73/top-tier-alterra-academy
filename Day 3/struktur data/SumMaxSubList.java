import java.util.ArrayList;
import java.util.Scanner;

public class SumMaxSubList {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        System.out.print("input number list: ");
        String text = input.nextLine();
        System.out.print("input k: ");
        int k = input.nextInt();
        for (int i=0; i<text.length(); i++)
        {
            mylist.add(Integer.parseInt(String.valueOf( text.charAt(i))));
        }
        int temp = 0;
        for (int i=0; i+k < mylist.size(); i++){
            int sum = mylist.subList(i, i+k).stream().mapToInt(Integer::intValue).sum();
            if(sum > temp){
                temp = sum;
            }
        }
        
        System.out.println(temp);
        

    }
}
