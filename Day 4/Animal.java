
abstract class Hewan {
    public String name, theet;
    abstract void indentity_myself();
    public Hewan(){
        System.out.println("Hi");
    }
}

class Carnivora extends Hewan {
    protected String food = "'daging'";

    @Override
    
    public void indentity_myself() {
        System.out.printf("Hi I'm Carnivora, My name is %s, My food is %s , I have %s theeth", super.name, this.food, super.theet);
    }
}

class Herbivora extends Hewan {
    protected String food = "'tumbuhan'";

    @Override
    
    public void indentity_myself() {
        System.out.printf("Hi I'm Herbivora, My name is %s, My food is %s , I have %s theeth", super.name, this.food, super.theet);
    }
}

class Omnivora extends Hewan {
    protected String food = "'semua'";

    @Override
    
    public void indentity_myself() {
        System.out.printf("Hi I'm Herbivora, My name is %s, My food is %s , I have %s theeth", super.name, this.food, super.theet);
    }
}


public class Animal {
    public static void main(String []args) {
        Omnivora tikus = new Omnivora();
        tikus.name = "tikus";
        tikus.food = "sabun";
        tikus.theet = "tajam";
    
        tikus.indentity_myself();
    }
}
