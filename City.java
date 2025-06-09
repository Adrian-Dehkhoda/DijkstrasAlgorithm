import java.util.ArrayList;

public class City
{
    String name;
    Integer id;
    ArrayList<Connection> neighbours;
    
    public City(String name, Integer id)
    {
        this.name = name;
        this.id = id;
        this.neighbours = new ArrayList<>();
    }

    public ArrayList<Connection> getNeighbours()
    {
        return neighbours;
    }

    public void connect(City destination, int time)
    {
        neighbours.add(new Connection(destination, time));
    }
}