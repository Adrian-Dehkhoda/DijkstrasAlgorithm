import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Map 
{
    private HashMap<String, City> cities;
    private City[] done;

    public Map(String file) 
    {
        cities = new HashMap<>();
        loadCities(file);

        int maxId = 0;

        for(City city: cities.values())
        {
            if(city.id > maxId) maxId = city.id;
        }
        
        done = new City[maxId + 1];
    }

    public void loadCities(String file)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            String line;
            int id = 0;
            while ((line = br.readLine()) != null) 
            {
                String[] row = line.split(",");

                City one = lookup(row[0], id++);
                City two = lookup(row[1], id++);
                Integer distance = Integer.valueOf(row[2]);

                one.connect(two, distance);
                two.connect(one, distance);
            }
        } 
        catch (Exception e) 
        {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public City lookup(String name, int id)
    {
        return cities.computeIfAbsent(name, k -> new City(name, id)); //Built in function in Java that creates a City if it is not in the HashMap
    }

    public Integer shortestPath(String from, String to)
    {
        City start = cities.get(from);
        City destination = cities.get(to);

        if(start == null || destination == null) return null;

        PriorityQueue<Paths> queue = new PriorityQueue<>();
        queue.add(new Paths(start, null, 0));

        while(!queue.isEmpty())
        {
            Paths currentPath = queue.poll();
            City currentCity = currentPath.getCity();

            if(done[currentCity.id] != null) continue;

            done[currentCity.id] = currentCity;
            
            if(done[currentCity.id] == destination) return currentPath.getDistance();

            for(Connection connection: currentCity.getNeighbours())
            {
                City neighbor = connection.getDestination();

                if(done[neighbor.id] == null)
                {
                    int newDist = currentPath.getDistance() + connection.getTime();
                    queue.add(new Paths(neighbor, currentCity, newDist));
                }
            }
        }
        return null;
    }
    
}
    