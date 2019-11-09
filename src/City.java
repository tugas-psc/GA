/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stephen
 * model untuk City berisi indentifier,lokasi x,y juga menghitung jarak dengan kota lainnya
 */
public class City {
    private int identifier; // kota ke berapa
    private int x;
    private int y;

    public City(int identifier, int x, int y) {
        this.identifier = identifier;
        this.x = x;
        this.y = y;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public double calDistance(City city){
        int xDistance=  Math.abs(this.x-city.x);
        int yDistance = Math.abs(this.y-city.y);
        return Math.sqrt((xDistance*xDistance) + (yDistance*yDistance));
    }
    
   
}
