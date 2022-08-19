import java.util.Scanner;

abstract class CalculateValue {
    public abstract double calculate(double val1, double val2);
    // public abstract float devide(float val1, float val2);
}

class Add extends CalculateValue {

    @Override
    public double calculate(double val1, double val2) {
        return val1 + val2;
    }
}

class Sub extends CalculateValue {

    @Override
    public double calculate(double val1, double val2) {
        return val1 - val2;
    }
}

class Multiply extends CalculateValue {

    @Override
    public double calculate(double val1, double val2) {
        return val1 * val2;
    }
}

class Devide extends CalculateValue {

    @Override
    public double calculate(double val1, double val2) {
        return val1 / val2;
    }
}



public class Calculator {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        double result = 0;
        System.out.println("CALCULATOR");
        System.out.print("masukan value 1: ");
        double val1 = input.nextDouble();
        System.out.print("masukan value 2: ");
        double val2 = input.nextDouble();

        System.out.println("=======CALCULATOR======");
        System.out.println("pilih calulate : ");
        System.out.println("1. Add Value");
        System.out.println("2. Sub Value");
        System.out.println("3. Multiply Value");
        System.out.println("4. devide Value");
        System.out.print("masukan value pilihan: ");
        int x = input.nextInt();

        switch (x) {
            case 1:
                Add add = new Add();
                result = add.calculate(val1, val2);
                break;
            case 2:
                Sub sub = new Sub();
                result = sub.calculate(val1, val2);
                break;
            case 3:
                Multiply multy = new Multiply();
                result = multy.calculate(val1, val2);
                break;
            case 4:
                Devide div = new Devide();
                result = div.calculate(val1, val2);
                break;
            default:
                System.out.println("not found");
                break;
        }
        System.out.println("Hasilnya adalah :" + result);

    }
}
