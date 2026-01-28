import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void TestConstructor(){
    Saab95 mySaab = new Saab95();
        assertEquals("Saab95", mySaab.getModelName());
        assertEquals(2, mySaab.getNrDoors());
        assertEquals(125, mySaab.getEnginePower());
        assertEquals(0, mySaab.getCurrentSpeed());
        assertEquals(Color.RED, mySaab.getColor());
    }

    @Test
    void TestSpeedFactor() {
        // Also tests if TurboOn and TurboOff works.
        Saab95 mySaab = new Saab95();
        mySaab.setTurboOn();
        assertEquals(1.625, mySaab.speedFactor());
        mySaab.setTurboOff();
        assertEquals(1.25,mySaab.speedFactor());
    }

    @Test
    void TestChangeColor() {
        Saab95 mySaab = new Saab95();
        mySaab.setColor(Color.BLUE);
        assertEquals(Color.BLUE, mySaab.getColor());
    }

    @Test
    void TestEngine(){
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();
        assertEquals(0.1, mySaab.getCurrentSpeed());
        mySaab.stopEngine();
        assertEquals(0, mySaab.getCurrentSpeed());
    }

    @Test
    void TestIncrementSpeedWithoutTurbo() {
        Saab95 mySaab = new Saab95();
        mySaab.gas(0.5);
        assertEquals(0.625, mySaab.getCurrentSpeed());
    }

    @Test
    void TestIncrementSpeedWithTurbo() {
        Saab95 mySaab = new Saab95();
        mySaab.setTurboOn();
        mySaab.gas(0.5);
        assertEquals(0.8125, mySaab.getCurrentSpeed());
    }



    @Test
    void TestDecrementSpeedWithoutTurbo() {
        Saab95 mySaab = new Saab95();
        mySaab.setCurrentSpeed(1);
        mySaab.brake(0.5);
        assertEquals(0.375, mySaab.getCurrentSpeed());
    }

    @Test
    void TestDecrementSpeedWithTurbo() {
        Saab95 mySaab = new Saab95();
        mySaab.setTurboOn();
        mySaab.setCurrentSpeed(1);
        mySaab.brake(0.5);
        assertEquals(0.1875, mySaab.getCurrentSpeed());
    }

    @Test
    void TestMove() {
        Saab95 mySaab = new Saab95();
        mySaab.setCurrentSpeed(0.5);
        mySaab.move();
        assertEquals(0.5, mySaab.getY());
        mySaab.turnRight();
        mySaab.move();
        assertEquals(0.5, mySaab.getX());
    }

    @Test
    void TestTurnLeft() {
        Saab95 mySaab = new Saab95();
        mySaab.turnLeft();
        assertEquals(Direction.WEST, mySaab.getDirection());
    }

    @Test
    void TestTurnLeftAgain() {
        Saab95 mySaab = new Saab95();
        mySaab.turnLeft();
        mySaab.turnLeft();
        assertEquals(Direction.SOUTH, mySaab.getDirection());
    }

    @Test
    void TestTurnRight() {
        Saab95 mySaab = new Saab95();
        mySaab.turnRight();
        assertEquals(Direction.EAST, mySaab.getDirection());
    }
}