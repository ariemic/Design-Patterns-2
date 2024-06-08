package dessignPatterns.adapter;

public class Main {
    public static void main(String[] args) {
        ContinentalDevice radio = new ContinentalDevice() {
            @Override
            public void on() {
                System.out.println("Gra muzyka");
            }
        };

        ContinentalSocket continentalSocket = new ContinentalSocket();

        UKSocket ukSocket = new UKSocket();
        UKDevice ukRadio = new UKDevice() {
            @Override
            public void powerOn() {
                System.out.println("English music is going");
            }
        };


        ContinentalDevice continentalDevice = new ContinentalDevice() {
            @Override
            public void on() {
                System.out.println("two way music is playing");
            }
        };

        TwoWayAdapter twoWayAdapter = new TwoWayAdapter(ukRadio, continentalDevice);
        continentalSocket.plugIn(twoWayAdapter);
        ukSocket.pluginIn(twoWayAdapter);

    }
}
