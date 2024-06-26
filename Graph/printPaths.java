import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, int n) {
        boolean[] vis = new boolean[n];
        String psf = "";
        printAllPathHelper(graph, src, dest, vis, psf + src);
    }

    public static void printAllPathHelper(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {

        if (src == dest) {
            System.out.println(psf);
            return;
        }

        vis[src] = true;

        for (Edge edge : graph[src]) {
            int nbr = edge.nbr;

            if (vis[nbr] == false) {
                printAllPathHelper(graph, nbr, dest, vis, psf + nbr);
            }

        }

        vis[src] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        printAllPath(graph, src, dest, vtces);
    }

}

// https://course.acciojob.com/idle?question=22e6cae8-a37e-4320-ae71-33322d382ed2