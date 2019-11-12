
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stephen
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CityRepresentation cityRepresentation = new CityRepresentation();
        System.out.println("masukkan test case yang diinginkan, 1 untuk 101-city problem dan 2 untuk 51-city problem");
        int inputCity = sc.nextInt();
        String fileName ="";
        switch(inputCity){
            case 1:
                fileName = "testcase.txt";
                break;
            case 2:
                fileName = "testcase2.txt";
                break;
            default:
                System.out.println("salah input");
        }
        try {
            File f = new File(fileName);
            Scanner sc2 = new Scanner(f);
            while(sc2.hasNextLine()){
                String[] n =sc2.nextLine().split(" ");
                int identifier = Integer.parseInt(n[0]);
                int x=  Integer.parseInt(n[1]);
                int y = Integer.parseInt(n[2]);
                cityRepresentation.add(identifier, x, y);
                
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        //test
        Population firstPopulation = new Population(cityRepresentation);
        firstPopulation.generateAll();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        Population parentPopulation = firstPopulation;
        long start = System.currentTimeMillis();
        for(int i=1;i<=1000;i++){
            
            parentPopulation = geneticAlgorithm.findBestRoute(i,parentPopulation);
           
        }
        long end = System.currentTimeMillis()-start;
        System.out.printf("path cost terbaik %.3f \n", geneticAlgorithm.getBestRoute().getPathCost());
        System.out.println("path yang diambil"+geneticAlgorithm.getBestRoute().getAllCityIdentifier());
        System.out.printf("Path cost terburuk %.3f \n", geneticAlgorithm.getWorstPathCost());
        System.out.println("waktu yang dibutuhkan" + end+" MS");

    }
}
