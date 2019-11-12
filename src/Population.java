
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
        listOfPopulation = new SalesmanRoute[50]; 
        this.cityRepresentation = cityRepresentation;
    }
    //empty constructor
    public Population(){
        this.listOfPopulation = new SalesmanRoute[50];
    }
    //generate populasi awal
    public void generateAll(){
        for(int i=0;i<listOfPopulation.length;i++){
            listOfPopulation[i] = new SalesmanRoute(this.cityRepresentation);
            listOfPopulation[i].generateRoute();
        }
    }
    // mengembalikan individu
    public SalesmanRoute getRoute(int i){
        return listOfPopulation[i];
    }
    
    // mencari individu dengan fitness function tertinggi
    public SalesmanRoute getFittest(){
        SalesmanRoute fittest=listOfPopulation[0];
        for(int i=1;i<listOfPopulation.length;i++){
            if(listOfPopulation[i].getFitnessFunction()> fittest.getFitnessFunction()){
                fittest = listOfPopulation[i];
            }
        }
        return fittest;
    }
    // mengembalikan nilai path cost tertinggi
    public double getWorstPathCost(){
        double worst=listOfPopulation[0].getPathCost();
        for(int i=1;i<listOfPopulation.length;i++){
            if(listOfPopulation[i].getPathCost()> worst){
                worst = listOfPopulation[i].getPathCost();
            }
        }
        return worst;
    }
    // mengembalikan ukuran populasi
    public int getSize(){
        return this.listOfPopulation.length;
    }
    // menambahkan individu dengan indeks
    public void addSalesManRoute(int indeks,SalesmanRoute route){
        this.listOfPopulation[indeks] = route;
    }
    
    // berguna untuk mengambil semua fitness function, method ini dipanggil saat mencari parents candidate
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
