public class ProxyPattern {
    public static void main(String[] args) {
        ICarDrive reno = new CarXProxy(new CarX());
        reno.drive();
    }
}

interface ICarDrive {
    void drive();
}

class CarXProxy implements ICarDrive {
    private CarX carX;

    CarXProxy(CarX carX) {
        this.carX = carX;
    }

    @Override
    public void drive() {
        System.out.println("Proxy job: adding additional header");
        carX.drive();
    }
}

class CarX implements ICarDrive {

    @Override
    public void drive() {
        System.out.println("Car is driving!!!");
    }
}
