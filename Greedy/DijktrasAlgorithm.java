package com.comp.prog;

public class DijsktrasAlgorithm {

	private static final int V=9;
	
	public static void main(String[] args) {
		
		 int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
			 		       { 4, 0, 8, 0, 0, 0, 0, 11, 0}, 
			 		       { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
			 		       { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
			 		       { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
			 		       { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
			 		       { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
			 		       { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
			 		       { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
		 dijsktras(graph, 0);
	}

	private static int findMinDistanceVertex(boolean visited[], int[] dist) {

		int vertex = -1;
		int min = Integer.MAX_VALUE;
		for (int v = 0; v < V; v++) {
			if (visited[v] == false && dist[v] <= min) {
				min = dist[v];
				vertex = v;
			}
		}
		return vertex;
	}

	private static void dijsktras(int[][] graph, int source) {

		boolean visited[] = new boolean[V];

		// dist[i] will hold the shortest distance from src to i
		int dist[] = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dist[source] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = findMinDistanceVertex(visited, dist);
			visited[u] = true;

			for (int v = 0; v < V; v++) {
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}

			}
		}
		printDistance(dist);

	}

	private static void printDistance(int[] dist) {

		for (int i = 0; i < V; i++) {
			System.out.println("Vertex : " + i + " Distance : " + dist[i]);
		}
	}

}
