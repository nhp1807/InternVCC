package data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    static class Graph{
        int dinh;
        LinkedList<Integer>[] listKe;

        public Graph(int dinh){
            this.dinh = dinh;
            listKe = new LinkedList[dinh];

            for(int i = 0; i < dinh; i++){
                listKe[i] = new LinkedList<>();
            }
        }

        public void addEdge(int start, int end){
            listKe[start].add(end);
        }
    }

    public static void bfs(Graph graph, int start){
        boolean[] visited = new boolean[graph.dinh];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int current = queue.poll();

            System.out.print(current + " ");

            for(Integer adj : graph.listKe[current]){
                if(!visited[adj]){
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 7);
        graph.addEdge(7, 8);


        bfs(graph, 0);
    }
}
