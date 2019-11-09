
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Stephen berisi rute yang akan diambil oleh salesman tersebut
 */
public class SalesmanRoute {

    private List<City> route;
    private CityRepresentation cityRepresentation;
    private int[] sortedRoute;

    public SalesmanRoute(CityRepresentation cityRepresentation) {
        this.route = new ArrayList<City>();
        this.cityRepresentation = cityRepresentation;
    }
    // empty constructor
    public SalesmanRoute() {
        this.route = new ArrayList<City>();
    }
    // generate populasi pertama kali
    public void generateRoute() {
        this.route.clear();
        this.route.addAll(this.cityRepresentation.generateCity());
    }

    public City getCity(int i) {
        return this.route.get(i);
    }

    public int getSize() {
        return this.route.size();
    }
    // mengembalikan path cost 
    public double getPathCost() {
        double result = 0;
        for (int i = 0; i < route.size() - 1; i++) {

            result += this.route.get(i).calDistance(this.route.get(i + 1));

        }
        return result;
    }
    // path cost dibagi 1
    public double getFitnessFunction() {
        return 1.0 / getPathCost();
    }
    
    public void addRoute(City city) {
        this.route.add(city);
    }
    
    // menukar 1 kota dengan kota lain dipanggil saat mutate
    public void swapCity(int pos1, int pos2) {
        City city1 = this.route.get(pos1);
        City city2 = this.route.get(pos2);
        this.route.set(pos1, city2);
        this.route.set(pos2, city1);
    }
    // cek apakah route diatas sudah memiliki kota pada parameter 
    public boolean isContain(City city) {
        return this.route.contains(city);
    }
    
    // mengembalikan identifier yaitu urutan keberapa kota itu dimasukkan dalam input oleh user
    public String getAllCityIdentifier() {
        this.sortedRoute = new int[this.route.size()];
        String n = " ";
        for (int i = 0; i < route.size(); i++) {
            n += this.route.get(i).getIdentifier() + " ";
            sortedRoute[i] = this.route.get(i).getIdentifier();
        }
        
        // cek apakah ada duplicate untuk debugging saja
        Arrays.sort(sortedRoute);
        for (int i = 1; i < sortedRoute.length; i++) {
            if (sortedRoute[i] == sortedRoute[i - 1]) {
                System.out.println("DUPLICATE");
            }
        }
        return n;
    }
}
