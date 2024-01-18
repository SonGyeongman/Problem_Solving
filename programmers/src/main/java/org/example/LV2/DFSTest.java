package org.example.LV2;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class DFSTest {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,4,3}, {1,4,5}, {1,4}, {1,2,3,5}, {2,4,6,7}, {5}, {5}};
        DFS(graph);
        System.out.println(Arrays.toString(visited));
    }

    public static Stack<Integer> dfs = new Stack<>();

    public static boolean[] visited = new boolean[8];

    public static void DFS(int[][] arr){
        dfs.push(1);
        visited[1] = true;
        while(!dfs.isEmpty()){
            int nodeList = dfs.pop();

            System.out.print(nodeList + " -> ");

            for(int node : arr[nodeList]){
                if(!visited[node]){
                    dfs.push(node);
                    visited[node] = true;
                }
            }
        }
    }
}
