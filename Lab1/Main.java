public class Main {
    public static void main(String[] args) {
        Volvo240 myVolvo = new Volvo240();
        Saab95 mySaab = new Saab95();

        // Testa att starta och gasa
        myVolvo.startEngine();
        myVolvo.gas(0.5);

        mySaab.startEngine();
        mySaab.setTurboOn();
        mySaab.gas(0.5);

        // Kontrollerar resultatet
        System.out.println(myVolvo.getModelName() + " fart: " + myVolvo.getCurrentSpeed());
        System.out.println(mySaab.getModelName() + " fart: " + mySaab.getCurrentSpeed());

        // Test för att se att vi inte kan nå privata variabler
        // myVolvo.currentSpeed = 100;
        Vehicle v = new Volvo240();
    }
}
