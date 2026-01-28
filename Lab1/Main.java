public class Main {
    public static void main(String[] args) {
        Volvo240 myVolvo = new Volvo240();
        Saab95 mySaab = new Saab95();

        // Test for starting, gas, move, turnleft
        myVolvo.startEngine();
        myVolvo.gas(0.5);
        myVolvo.move();
        myVolvo.turnLeft();
        myVolvo.move();

        mySaab.startEngine();
        mySaab.setTurboOn();
        mySaab.gas(0.5);

        // result
        System.out.println(myVolvo.getModelName() + " fart: " + myVolvo.getCurrentSpeed() + " position: " + myVolvo.getX() + myVolvo.getY() + " direction " + myVolvo.getDirection());
        System.out.println(mySaab.getModelName() + " fart: " + mySaab.getCurrentSpeed());

        // testing if we can reach private variables
        // myVolvo.currentSpeed = 100;
        // works fine

        Vehicle v = new Volvo240();
    }
}
