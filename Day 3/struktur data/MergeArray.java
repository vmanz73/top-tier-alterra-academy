import java.util.ArrayList;
import java.util.Scanner; 

public class MergeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input long array number : ");
        int n= input.nextInt();
        ArrayList<String> mylist = new ArrayList<String>();

        System.out.println("input array values : ");
        input.nextLine();
        for (int i=0; i<n; i++) {
            String x = input.nextLine();
            mylist.add(x);
        }
        System.out.println(mylist);
        
        System.out.print("input long array-2 number : ");
        n= input.nextInt();
        ArrayList<String> mylist2 = new ArrayList<String>();
        System.out.println("input array-2 values : ");
        input.nextLine();
        for (int i=0; i<n; i++) {
            String x = input.nextLine();
            mylist2.add(x);
        }
        System.out.println(mylist2);
        
        mylist.addAll(mylist2);

        System.out.println("array merged : ");
        System.out.println(mylist);
    }
}
