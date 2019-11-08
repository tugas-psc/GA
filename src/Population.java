
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
    private double[] fitnessFunction;
    public Population(CityRepresentation cityRepresentation){
        listOfPopulation = new SalesmanRoute[10]; // population 10 dahulu
        this.cityRepresentation = cityRepresentation;
    }
    public Population(){
        this.listOfPopulation = new SalesmanRoute[10];
    }
    public void generateAll(){
        for(int i=0;i<10;i++){
            listOfPopulation[i] = new SalesmanRoute(this.cityRepresentation);
            listOfPopulation[i].generateRoute();
        }
    }
    public SalesmanRoute getRoute(int i){
        return listOfPopulation[i];
    }
 
    public SalesmanRoute getFittest(){
        SalesmanRoute fittest=listOfPopulation[0];
        for(int i=1;i<listOfPopulation.length;i++){
            if(listOfPopulation[i].getFitnessFunction()> fittest.getFitnessFunction() && 
                    !listOfPopulation[i].isDuplicate()){
                fittest = listOfPopulation[i];
            }
        }
        return fittest;
    }
    public double getWorstPathCost(){
        double worst=listOfPopulation[0].getPathCost();
        for(int i=1;i<listOfPopulation.length;i++){
            if(listOfPopulation[i].getPathCost()> worst){
                worst = listOfPopulation[i].getPathCost();
            }
        }
        return worst;
    }
    public int getSize(){
        return this.listOfPopulation.length;
    }
    public void addSalesManRoute(int indeks,SalesmanRoute route){
        this.listOfPopulation[indeks] = route;
    }
    public double[] getAllFitnessFunction(){
        if(fitnessFunction != null){
            return fitnessFunction;
        }
        else{
            fitnessFunction = new double[listOfPopulation.length];
            for(int i=0;i<listOfPopulation.length;i++){
                fitnessFunction[i] = listOfPopulation[i].getFitnessFunction();
            }
        }
        return fitnessFunction;
    }
    
}
