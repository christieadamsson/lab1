

import java.awt.*;

public class CarTransport extends Truck {

    private boolean rampDown;
    private static final int MaxCars = 6;


    public CarTransport() {
        super(200,0,Color.BLACK,"Car Transport");
    }


    public void lowerRamp(){
        if(getCurrentSpeed() !=0) return;
        rampDown = true;
    }

    @Override
    protected boolean isSafeForDriving() {
        return !rampDown;
    }

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
