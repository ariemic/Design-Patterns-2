package dessignPatterns.templeteMethod;

public abstract class CarStartingSequence {
    // it's final to prevent changing order of the startTheCar sequence
    public final void startTheCar(){
        fastenSeatbelts();
        startTheEngine();
        setTheGear();
        go();
    }

    private void go() {
        System.out.println("wciskamy pedał gazu");
    }

    private void fastenSeatbelts() {
        System.out.println("zapinamy pasy");
    }

    public abstract void startTheEngine();
    public abstract void setTheGear();

}
