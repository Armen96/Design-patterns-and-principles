<?php

/**
 * Interface ICar
 */
interface ICar {
    function cost();
    function description();
}


/**
 * The decorator
 *
 * Class CarFeature
 */
abstract class CarFeature implements ICar {
    protected $car;

    function __construct(ICar $car)
    {
        $this->car = $car;
    }

    abstract function cost();

    abstract function description();
}

/**
 * The abstract class CarFeature implements the Car interface in an unusual way by re-defining the interface
 * methods as abstract methods. The abstract class also holds a reference to an object that was created
 * from one of the basic classes.
 */





/**
 * The sub-classes that inherit the decorator
 */
class SunRoof extends CarFeature {
    function cost ()
    {
        return $this->car->cost() + 1500;
    }

    function description()
    {
        return $this->car->description() . ",  sunroof";
    }
}

class HighEndWheels extends CarFeature
{
    public function cost()
    {
       return $this->car->cost() + 4000;
    }

    public function description()
    {
       return $this->car->description() . ", high end wheels";
    }
}


/**
 * Class Suv
 */
class Suv implements ICar {

    function cost()
    {
        return 30000;
    }

    function description ()
    {
        return "Suv";
    }

}



$basicCar = new Suv();

// Pass the object from the basic class as a parameter to the first feature class.
$carWithSunRoof = new SunRoof($basicCar);

// Pass the object from the first feature class as a parameter to the second feature class.
$carWithSunRoofAndHighEndWheels = new HighEndWheels($carWithSunRoof);


echo $carWithSunRoofAndHighEndWheels->description();
echo " <br> ";
echo $carWithSunRoofAndHighEndWheels->cost();