import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchAlgorithm {
    static int binarySearch(ArrayList <Integer> mylist, int first, int last, int x)
    {
        if (last >= first) {
            int mid = first + (last - first) / 2;

            if (mylist.get(mid) == x)
                return mid;

            if (mylist.get(mid) > x)
                return binarySearch(mylist, first, mid - 1, x);
            return binarySearch(mylist, mid + 1, last, x);
        }

        return -1;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input list menggunakan ' ' (spasi) untuk pemisah: ");
        String num_list = input.nextLine();

        String[] split = num_list.split(" ");

        ArrayList <Integer> mylist = new ArrayList<Integer>();
        for (String value : split){
            mylist.add(Integer.parseInt(value));
        }
        Collections.sort(mylist);
        System.out.println("sorted list : " + mylist);
        System.out.print("Cari :");
        int x = input.nextInt();
        int result = binarySearch(mylist, 0, mylist.size() - 1, x);
        System.out.print("Hasil index : ");
        System.out.println(result);
    }
}
