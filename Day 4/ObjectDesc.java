import java.util.Scanner;

public class ObjectDesc {
    private String name, type, color, feed;
    private int num;
    Scanner input = new Scanner(System.in);

    void InputObj(){
        System.out.print("Masukan jenis objek :");
        name = input.nextLine();
        switch (name.toLowerCase()) {
            case "kucing":
                InputCat();
                break;
            case "ikan":
                InputFish();
                break;
            case "bunga":
                InputFlower();
                break;
            case "mobil":
                InputCar();
            default:
                System.out.printf("%s tidak ditemukan", name);
                break;
        }
    }

    void InputCat(){
        System.out.print("Masukan warna bulu :");
        color = input.nextLine();

        System.out.print("Masukan jumlah kaki :");
        num = input.nextInt();
        Cat(color, num);
    }

    void InputFish(){
        System.out.print("Masukan jenis ikan :");
        type = input.nextLine();

        System.out.print("Masukan jenis makanan :");
        feed = input.nextLine();
        Fish(type, feed);
    }

    void InputFlower(){
        System.out.print("Masukan jenis bunga :");
        type = input.nextLine();

        System.out.print("Masukan warna bunga :");
        color = input.nextLine();

        System.out.print("Masukan jumlah petal :");
        num = input.nextInt();
        Flower(type, color, num);
    }

    void InputCar(){
        System.out.print("Masukan jenis mobil :");
        type = input.nextLine();

        System.out.print("Masukan warna mobil :");
        color = input.nextLine();

        System.out.print("Masukan jumlah roda :");
        num = input.nextInt();
        Car(type, color, num);
    }

    void Cat(String color, int num){
        this.color = color;
        this.num = num;

        System.out.printf("saya Kucing dengan detail, warna bulu: %s, jumlah kaki : %d \n", this.color,this.num);
        
    }

    void Fish(String type,String feed){
        this.type = type;
        this.feed = feed;

        System.out.printf("saya Ikan dengan detail, jenis: %s, makan: %s \n", this.type, this.feed);
        
    }

    void Flower(String type,String color, int num){
        this.type = type;
        this.color = color;
        this.num = num;

        System.out.printf("saya Bunga dengan detail, jenis: %s, warna: %s, jumlah petal : %d\n", this.type, this.color, this.num);
        
    }

    void Car(String type,String color, int num){
        this.type = type;
        this.color = color;
        this.num = num;

        System.out.printf("saya %s dengan detail, Type: %s, warna: %s, jumlah roda : %d\n", this.name, this.type, this.color, this.num);
        
    }
}

class Main{
    public static void main(String [] args){
        ObjectDesc obj = new ObjectDesc();
        obj.InputObj();
        
    }
    
}
