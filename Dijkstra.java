public class Dijkstra 
{
    public static void main(String[] args) 
    {
        Map map = new Map("europe.csv");
        String from; 
        String to;
        
        try
        {
            from = args[0];
            to = args[1];
        }
        catch(Exception e)
        {
            System.out.println("Usage: java Dijkstra <from> <to>");
            return;
        }

        long t0 = System.nanoTime();
        Integer distance = map.shortestPath(from, to);
        long t1 = System.nanoTime();

        if(distance != null)
        {
            System.out.println("Shortest path from " + from + " to " + to + " is " + distance + " minutes.");
            System.out.println("Time taken " + (t1-t0) + " ns");
        }
        else System.out.println("Path not found");
    }

}