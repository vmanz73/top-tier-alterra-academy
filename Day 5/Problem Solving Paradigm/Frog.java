import java.util.ArrayList;
import java.util.Scanner;

public class Frog {
    static int getRes(ArrayList <Integer> h){
        int elm;
        ArrayList <Integer> cost = new ArrayList<Integer>();
        cost.add(0);
        cost.add(Math.abs( h.get(1) - h.get(0)));
        for (int i = 2; i < h.size(); i++) {
            elm = Math.min(cost.get(i-1) + Math.abs(h.get(i) - h.get(i-1)), cost.get(i-2) + Math.abs(h.get(i) - h.get(i-2)));
            cost.add(elm);
        }
        return cost.get(h.size()-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input list menggunakan ' ' (spasi) untuk pemisah: ");
        String num_list = input.nextLine();

        String[] split = num_list.split(" ");

        ArrayList <Integer> mylist = new ArrayList<Integer>();
        for (String value : split){
            mylist.add(Integer.parseInt(value));
        }
        int res = getRes(mylist);
        System.out.println(res);
    }
    
}
