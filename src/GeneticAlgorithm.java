
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
 */
public class GeneticAlgorithm {

    private SalesmanRoute bestRoute;
    private double bestRouteFitness = Integer.MIN_VALUE;
    private double worstPathCost = Integer.MIN_VALUE;
    private final double mutationChance = 0.015;

    public GeneticAlgorithm() {

    }

    public Population findBestRoute(int indeks, Population previousGeneration) {
        Population newGeneration = new Population();
        SalesmanRoute fittest = previousGeneration.getFittest();
        newGeneration.addSalesManRoute(0, fittest);
        for (int i = 1; i < newGeneration.getSize(); i++) {
            SalesmanRoute parent1 = getParentCandidate(previousGeneration);
            SalesmanRoute parent2 = getParentCandidate(previousGeneration);
            while (parent2 == parent1) {
                parent2 = getParentCandidate(previousGeneration);
            }
//            System.out.println(parent1);
//            System.out.println(parent2);
            SalesmanRoute child = this.crossOver(parent1, parent2);
            this.mutate(child);
            newGeneration.addSalesManRoute(i, child);

        }
        SalesmanRoute bestOfPopulation = newGeneration.getFittest();
        if (bestRouteFitness < bestOfPopulation.getFitnessFunction()) {
            bestRoute = bestOfPopulation;
            bestRouteFitness = bestOfPopulation.getFitnessFunction();
        }
        if (worstPathCost < newGeneration.getWorstPathCost()) {
            worstPathCost = newGeneration.getWorstPathCost();
        }
        if (indeks % 10 == 0) {
            System.out.println("path cost terbaik untuk generasi ke-"
                    + indeks + " " + newGeneration.getFittest().getPathCost());
        }

        return newGeneration;
    }

    public SalesmanRoute getBestRoute() {
        return this.bestRoute;
    }

    public double getWorstPathCost() {
        return this.worstPathCost;
    }

    public SalesmanRoute getParentCandidate(Population previousGeneration) {
        double[] fitnessFunction = previousGeneration.getAllFitnessFunction();
        double divider = 0;
        for (int i = 0; i < fitnessFunction.length; i++) {
            divider += fitnessFunction[i];
        }
        for (int i = 0; i < fitnessFunction.length; i++) {
            fitnessFunction[i] = fitnessFunction[i] / divider;
        }
        double chances = Math.random();
        if (fitnessFunction[0] > chances) {
            return previousGeneration.getRoute(0);
        }
        for (int i = 1; i < fitnessFunction.length; i++) {
            fitnessFunction[i] += fitnessFunction[i - 1];
            if (fitnessFunction[i] > chances) {
                return previousGeneration.getRoute(i);
            }
        }
        return previousGeneration.getRoute(fitnessFunction.length - 1);
    }

    public SalesmanRoute crossOver(SalesmanRoute parent1, SalesmanRoute parent2) {
        SalesmanRoute child = new SalesmanRoute();
        int max = parent1.getSize();
        int cutPos = (int) (Math.random() * max);
        for (int i = 0; i < cutPos; i++) {
            child.addRoute(parent1.getCity(i));
        }
        for (int i = cutPos; i < max; i++) {
            if (!child.isContain(parent2.getCity(i))) {
                child.addRoute(parent2.getCity(i));
            } else {
                for (int j = cutPos; j>=0; j--) {
                    if (!child.isContain(parent2.getCity(j))) {
                        child.addRoute(parent2.getCity(j));
                        break;
                    }
                }
            }

        }
        return child;
    }

    public void mutate(SalesmanRoute route) {
        int max = route.getSize();
        for (int i = 0; i < max; i++) {
            if (Math.random() < this.mutationChance) {
                int pos2 = (int) (Math.random() * max);
                route.swapCity(i, pos2);

            }
        }
    }
}
