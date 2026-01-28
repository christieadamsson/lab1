import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ConvolveOp;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {


    @Test
    void TestConstructor() {
        Volvo240 myVolvo = new Volvo240();
        assertEquals("Volvo240", myVolvo.getModelName());
        assertEquals(4, myVolvo.getNrDoors());
        assertEquals(100, myVolvo.getEnginePower());
        assertEquals(0, myVolvo.getCurrentSpeed());
        assertEquals(Color.BLACK, myVolvo.getColor());
    }

    @Test
    void TestChangeColor() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.setColor(Color.BLUE);
        assertEquals(Color.BLUE, myVolvo.getColor());
    }

    @Test
    void TestEngine(){
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine();
        assertEquals(0.1, myVolvo.getCurrentSpeed());
        myVolvo.stopEngine();
        assertEquals(0, myVolvo.getCurrentSpeed());
    }

    @Test
    void TestSpeedFactor() {
        Volvo240 myVolvo = new Volvo240();
        assertEquals(1.25, myVolvo.speedFactor());
    }

    @Test
    void TestIncrementSpeed() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.gas(0.5);
        assertEquals(0.625, myVolvo.getCurrentSpeed());
    }

    @Test
    void TestDecrementSpeed() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.setCurrentSpeed(1);
        myVolvo.brake(0.5);
        assertEquals(0.375, myVolvo.getCurrentSpeed());
    }

    @Test
    void TestMove() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.setCurrentSpeed(0.5);
        myVolvo.move();
        assertEquals(0.5, myVolvo.getY());
        myVolvo.turnRight();
        myVolvo.move();
        assertEquals(0.5, myVolvo.getX());
    }

    @Test
    void TestTurnLeft() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.turnLeft();
        assertEquals(Direction.WEST, myVolvo.getDirection());
    }

    @Test
    void TestTurnLeftAgain() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.turnLeft();
        myVolvo.turnLeft();
        assertEquals(Direction.SOUTH, myVolvo.getDirection());
    }

    @Test
    void TestTurnRight() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.turnRight();
        assertEquals(Direction.EAST, myVolvo.getDirection());
    }


    @Test
    public void TestGasAndBrake() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine(); // 0.1

        myVolvo.gas(0.5);
        assertTrue(myVolvo.getCurrentSpeed() > 0.1);

        double speedBeforeBrake = myVolvo.getCurrentSpeed();
        myVolvo.brake(0.1);
        assertTrue(myVolvo.getCurrentSpeed() < speedBeforeBrake);
    }

    @Test
    public void TestInvalidGasAndBrake() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine(); // 0.1

        myVolvo.gas(1.1);
        assertEquals(0.1, myVolvo.getCurrentSpeed());

        double speedBeforeBrake = myVolvo.getCurrentSpeed();
        myVolvo.brake(-0.1);
        assertEquals(0.1, myVolvo.getCurrentSpeed());
    }

    @Test
    public void TestSpeedLimit() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.setCurrentSpeed(100);
        myVolvo.gas(1);
        assertEquals(100, myVolvo.getCurrentSpeed());

        myVolvo.setCurrentSpeed(0);
        myVolvo.brake(1);
        assertEquals(0, myVolvo.getCurrentSpeed());
    }
}