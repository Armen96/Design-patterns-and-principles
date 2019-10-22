public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbsFactoryCreate factoryType = new AbstractFactory();

        ICarOrTank car = factoryType.create("Car");
        ICarOrTank tank = factoryType.create("Tank");

        IAbstractFactoryCar audi = car.createCar("Audi");

        IAbstractFactoryTank t90 = tank.createTank("T90");
        IAbstractFactoryTank t95 = tank.createTank("T95");

        t90.drive();
        t95.drive();
        audi.drive();
    }
}

interface IAbstractFactoryCar {
    void drive();
}

class AbstractAudiFactory implements IAbstractFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Audi");
    }
}

class AbstractToyotaFactory implements IAbstractFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class AbstractDefaultFactory implements IAbstractFactoryCar {

    @Override
    public void drive() {
        System.out.println("Drive Default");
    }
}

class AbstractFactoryCar implements ICarOrTank {

    @Override
    public IAbstractFactoryCar createCar(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota" : return new AbstractToyotaFactory();
            case "Audi" : return new AbstractAudiFactory();
            default: return new AbstractDefaultFactory();
        }
    }

    @Override
    public IAbstractFactoryTank createTank(String typeOfTank) {
        return null;
    }
}

// Tank

interface ICarOrTank {
    IAbstractFactoryCar createCar(String type);
    IAbstractFactoryTank createTank(String type);
}

interface IAbstractFactoryTank {
    void drive();
}

class AbstractT90Factory implements IAbstractFactoryTank {

    @Override
    public void drive() {
        System.out.println("Drive T90");
    }
}

class AbstractT95Factory implements IAbstractFactoryTank {

    @Override
    public void drive() {
        System.out.println("Drive T95");
    }
}

class AbstractFactoryTank implements ICarOrTank {

    @Override
    public IAbstractFactoryCar createCar(String type) {
        return null;
    }

    @Override
    public IAbstractFactoryTank createTank(String typeOfCar) {
        switch (typeOfCar) {
            case "T90" : return new AbstractT90Factory();
            case "T95" : return new AbstractT95Factory();
            default: return null;
        }
    }
}

interface AbsFactoryCreate {
    ICarOrTank create(String type);
}

class AbstractFactory implements AbsFactoryCreate{

    @Override
    public ICarOrTank create(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Car" : return new AbstractFactoryCar();
            case "Tank" : return new AbstractFactoryTank();
            default: return null;
        }
    }
}
