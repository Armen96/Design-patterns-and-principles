/**
 * Factory pattern is one of the most used design patterns in Java. This type of design pattern
 * comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * In Factory pattern, we create object without exposing the creation logic to the client and
 * refer to newly created object using a common interface.
 */

public class FactoryPattern {
    public static void main(String[] args) {
        FactoryCar carFactory = new FactoryCar();
        IFactoryCar audi = carFactory.create("Audi");
        audi.drive();

        IFactoryCar toyota = carFactory.create("Toyota");
        toyota.drive();

        IFactoryCar xxx = carFactory.create("XXX");
        xxx.drive();
    }
}

interface IFactoryCar {
    void drive();
}


class AudiFactory implements IFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Audi");
    }
}

class ToyotaFactory implements IFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class DefaultFactory implements IFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Default");
    }
}

class FactoryCar {
    public IFactoryCar create(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota" : return new ToyotaFactory();
            case "Audi" : return new AudiFactory();
            default: return new DefaultFactory();
        }
    }
}
