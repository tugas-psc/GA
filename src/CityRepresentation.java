
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 * berisi seluruh kota yang ada. dan digunakan untuk men-generate populasi pertama kali
 */

//modelling for all available city
public class CityRepresentation {
    private ArrayList<City> listOfCity;
    public CityRepresentation(){
        this.listOfCity=  new ArrayList<City>();
    }
    public void add(int identifier,int x,int y){
        this.listOfCity.add(new City(identifier,x,y));
    }
    // generate populasi pertama
    public List<City> generateCity(){
        Random random = new Random();
        List<City> generatedListOfCity = new ArrayList<City>();
        List<City> temp = new ArrayList<City>();
        temp.addAll(listOfCity);
        for(int i=0;i<listOfCity.size();i++){
            // random number dan memasukkan pada list of city yang baru dan remove temp agar tidak ada duplicate
            int n =random.nextInt(temp.size());
            generatedListOfCity.add(temp.get(n));
            temp.remove(n);
        }
        return generatedListOfCity;
    }
    
}
