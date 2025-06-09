public class Paths implements Comparable<Paths>
{
    private City city;
    private City previous;
    private Integer distance;

    public Paths(City city, City previous, Integer distance) 
    {
        this.city = city;
        this.previous = previous;
        this.distance = distance;
    }

    public City getCity()
    {
        return city;
    }

    public City getPrevious()
    {
        return previous;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public int compareTo(Paths otherPath) //Overrides the java.lang method compareTo()
    {
        return this.distance.compareTo(otherPath.distance);
    }
}
