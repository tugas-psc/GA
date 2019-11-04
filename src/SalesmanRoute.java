
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 * berisi rute yang akan diambil oleh salesmane tersebut
 */
public class SalesmanRoute {
    private List<City> route;
    private CityRepresentation cityRepresentation;
    public SalesmanRoute(CityRepresentation cityRepresentation){
        this.route = new ArrayList<City>();
        this.cityRepresentation = cityRepresentation;
    }
    public void generateRoute(){
        this.route.clear();
        this.route.addAll(this.cityRepresentation.generateCity());
    }
    public List<City> getRoute(){
        return this.route;
    }
    
}
