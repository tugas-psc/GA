
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
        System.out.println("masukkan berapa banyak city yang akan diambil");
        Scanner sc = new Scanner(System.in);
//        int cityCount = sc.nextInt();
        CityRepresentation cityRepresentation = new CityRepresentation();
//        System.out.println("masukkan sebanyak city yang dipilih  diurutkan dengan kota ke berapa,posisi x,posisi y");
//        for(int i=0;i<cityCount;i++){
//            int identifier = sc.nextInt();
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            cityRepresentation.add(identifier, x, y);
//        }

        try {
            File f = new File("testcase.txt");
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
        Population population = new Population(cityRepresentation);
        population.generateAll();
        for (int i = 0; i < 10; i++) {
            List<City> listOfCity = population.getRoute(i);
            for (int j = 0; j < listOfCity.size(); j++) {
                System.out.println(listOfCity.get(j).getIdentifier());
            }
            System.out.println("Next City");
        }

    }
}
