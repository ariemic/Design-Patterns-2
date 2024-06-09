package dessignPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        generateMap();
    }

    private static void generateMap() {
        Terrain terrain = new Plain();
        Terrain terrain1 = new Hill();
        Terrain terrain2 = new SwampDecorator(new Hill());
        Terrain forestHill = new ForestDecorator(new Hill());
        Terrain swampForestHill = new SwampDecorator(forestHill);


        System.out.println("Swamp hill cost: " + terrain2.getFuelCost());
        System.out.println("forestHill cost: " + forestHill.getFuelCost());
        System.out.println("swamp Forest Hill cost: " + swampForestHill.getFuelCost());
    }


}
