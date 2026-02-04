import java.awt.*;

public class Scania extends Truck {

    private double rampAngle =0;

    public Scania() {
    super(200,0,Color.blue,"Scania");

}
    public double getRampAngle() {
        return rampAngle;
    }
    public void raiseRampAngle(double angle) {
        if (angle <0) return;
        if(getCurrentSpeed() !=0) return;
        double newAngle = rampAngle + angle;

        if (newAngle > 70) {
            rampAngle = 70;
        } else {
            rampAngle = newAngle;
        }

    }

    public void lowerRampAngle(double angle) {
        if (angle <0) return;
        if(getCurrentSpeed() !=0) return;
        double newAngle = rampAngle - angle;
        if (newAngle<0){
            rampAngle = 0;
        }
        else {
            rampAngle = newAngle;
        }
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    @Override
    protected void incrementSpeed(double amount) {

    }
    @Override
    protected void decrementSpeed(double amount) {

    }

    @Override
    protected boolean isSafeForDriving() {
        return rampAngle ==0;
    }

}
