import java.util.Scanner;

public class TextCheck{
    public static void main(String args[]){
        int vowel = 0, consonant=0;
        System.out.print("input text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine().toLowerCase();

        for (int i=0 ; i<text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
                vowel++;
            }
            else if(ch != ' '){
                consonant++;
            }
        }
        System.out.println("Jumlah vokal "+ vowel);
        System.out.println("Jumlah konsonan "+ consonant);
        System.out.println("total karakter "+ (vowel+consonant));
    }
}