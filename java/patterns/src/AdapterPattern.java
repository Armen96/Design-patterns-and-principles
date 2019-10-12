import org.jetbrains.annotations.NotNull;

public class AdapterPattern {
    public static void main(String[] args) {
        Car car = new Car();
        car.washCar(new Audi());

        car.washCar(new TrackAdapter(new BMW()));
    }
}

interface ICar {
    void wash();
}

interface ITrack {
    void clean();
}

class TrackAdapter implements ICar {
    ITrack track;

    TrackAdapter(ITrack track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}

class Car {

    public void washCar(@NotNull ICar car) {
        car.wash();
    }
}

class Audi implements ICar {

    @Override
    public void wash() {
        System.out.println("Wash Audi car");
    }

}

class BMW implements ITrack {

    @Override
    public void clean() {
        System.out.println("Clean bmw car");
    }
}