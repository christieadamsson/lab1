

import javax.crypto.Mac;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CarTransport extends Truck {

    private boolean rampDown;
    private static final int MaxCars = 6;
    private Deque<Car> loadedCars = new ArrayDeque<>(); //kolla upp overloads osv, static dynamic;


    public CarTransport(){
        super(200,0,Color.BLACK,"Car Transport");
    }


    public void lowerRamp(){
        if(getCurrentSpeed() !=0) return;
        rampDown = true;
    }

    private boolean closeEnough(Car car){
        double dx = (car.getX() - this.getX());
        double dy = (car.getX()- this.getX());

        double distance = Math.sqrt((dx*dx) + (dy*dy));
        return distance < 1;
    }

    public void addCar(Car car) {
        if (loadedCars.size() < MaxCars && closeEnough(car) && rampDown) {
            loadedCars.push(car);
        }
    }

    public void removeCar(){
            if(rampDown){
                Car removedCar = loadedCars.pop();
                removedCar.setPosition(this.getX()-1, this.getY()-1);
            }
    }

    @Override
    protected boolean isSafeForDriving() {
        return !rampDown;
    } //check för om rampDown är false

    @Override
    protected void incrementSpeed(double amount) {

    }

    @Override
    protected void decrementSpeed(double amount) {

    }

    @Override
    protected double speedFactor() {
        return 0;
    }

}
