public class Connection 
{
    private City destination;
    private int time;
    
    public Connection(City destination, int time)
    {
        this.destination = destination;
        this.time = time;
    }

    public City getDestination()
    {
        return destination;
    }

    public int getTime()
    {
        return time;
    }
        
}
