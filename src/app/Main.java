package app;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ShortestPathProblem problem = new MyShortestPathProblem(); // Reemplaza esto con la instancia de tu problema de camino más corto
        int initialBestPathLength = Integer.MAX_VALUE;

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ParallelShortestPath parallelShortestPath = new ParallelShortestPath(problem, initialBestPathLength);
        List<Integer> shortestPath = forkJoinPool.invoke(parallelShortestPath);

        // Imprime el camino más corto encontrado
        if (shortestPath != null) {
            System.out.println("Camino más corto: " + shortestPath);
            System.out.println("Longitud del camino: " + shortestPath.size());
        } else {
            System.out.println("No se encontró ningún camino.");
        }
    }

}
