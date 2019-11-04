
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 */
public class Population {
    private SalesmanRoute[] listOfPopulation;
    private CityRepresentation cityRepresentation;
    public Population(CityRepresentation cityRepresentation){
        listOfPopulation = new SalesmanRoute[10]; // population 10 dahulu
        this.cityRepresentation = cityRepresentation;
    }
    public void generateAll(){
        for(int i=0;i<10;i++){
            listOfPopulation[i] = new SalesmanRoute(this.cityRepresentation);
            listOfPopulation[i].generateRoute();
        }
    }
    public List<City> getRoute(int i){
        return listOfPopulation[i].getRoute();
    }
    
}
