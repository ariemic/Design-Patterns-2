package dessignPatterns.templeteMethod;

public class ButtonCarStartingSequence {
    public void startTheCar(){
        fastenSeatbelts();
        startTheEngine();
        setTheGear();
        go();
    }

    private void go() {
        System.out.println("wciskamy pedał gazu");
    }

    private void setTheGear() {
        System.out.println("wybieramy bieg");
    }

    private void startTheEngine() {
        System.out.println("wciśnij guzik");
    }

    private void fastenSeatbelts() {
        System.out.println("zapinamy pasy");
    }
}
