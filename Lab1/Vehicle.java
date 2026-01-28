import java.awt.*;
// Varför ska vissa vara final? IntellIJ sa åt oss att ändra till det.
public abstract class Vehicle implements Movable{
    private final double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of vehicle
    private Color color; // Color of the vehicle
    private final String modelName; // The vehicle model name
    private double x;
    private double y;
    private Direction direction; // enum direction filen


    public Vehicle(double power, double speed, Color clr, String name) {
        this.enginePower = power;
        this.currentSpeed = speed;
        this.color = clr;
        this.modelName = name;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH; // Startar mot Norr
    }

    public double getEnginePower() {
        return enginePower;
    }

    protected void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setColor(Color clr) { //the color on the vehicle could be changed
        this.color = clr;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract void incrementSpeed(double amount);
    protected abstract void decrementSpeed(double amount);
    protected abstract double speedFactor();

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        switch (direction) {
            case NORTH -> y += getCurrentSpeed();
            case EAST  -> x += getCurrentSpeed();
            case SOUTH -> y -= getCurrentSpeed();
            case WEST  -> x -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        direction = switch (direction) {
            case NORTH -> Direction.WEST;
            case WEST  -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST  -> Direction.NORTH;
        };
    }

    @Override
    public void turnRight() {
        direction = switch (direction) {
            case NORTH -> Direction.EAST;
            case EAST  -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST  -> Direction.NORTH;
        };
    }

    // Getters för att Main ska kunna se var vi är
    public double getX() { return x; }
    public double getY() { return y; }
    public Direction getDirection() { return direction; }
}
