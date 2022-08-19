class Vehicle {
    public String name, vehicle, with_engine, type_engine;
    public int wheels;
    void show(){
        System.out.printf("Hi I'm %s, My name is %s, My engine is %s, I have %d wheels, type engine: %s \n", vehicle, name, with_engine, wheels, type_engine);
    }
}

class Bike extends Vehicle {
    protected int wheel_count = 2;
    protected String with_engine = "'with no engine'", vehicle = "Bike"; 
    public Bike(String name){
        super.vehicle = vehicle;
        super.name = name;
        super.type_engine = type_engine;
        super.with_engine = with_engine;
        super.show();
    }
}

class Car extends Vehicle {
    protected int wheel_count = 4;
    protected String with_engine = "'with engine'", vehicle = "Car"; 
    public Car(String name, String type_engine){
        super.vehicle = vehicle;
        super.name = name;
        super.type_engine = type_engine;
        super.with_engine = with_engine;
        super.show();
    }
}

class Bus extends Vehicle {
    protected int wheel_count = 4;
    protected String with_engine = "'with engine'", vehicle = "Bus"; 
    public Bus(String name, String type_engine){
        super.vehicle = vehicle;
        super.name = name;
        super.type_engine = type_engine;
        super.with_engine = with_engine;
        super.show();
    }
}

public class Vehicles {
    public static void main(String []args) {
        Bike bike = new Bike("BMW");
    }
}
