package dessignPatterns.decorator;

public abstract class TerrainDecorator extends Terrain{
    protected Terrain terrain;
    public TerrainDecorator(Terrain terrain) {
        super("nothing", 0);
        this.terrain = terrain;
    }
}
