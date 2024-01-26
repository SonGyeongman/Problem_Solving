package org.example.baekjoon.silver;

public class 트리_순회 {
    public static void main(String[] args) {
        /*
        * 7
        * A B C
        * B D .
        * C E F
        * E . .
        * F . G
        * D . .
        * G . .
        * */
        char[][] tree = {{'A', 'B','C'},
                {'B', 'D', ' '},
                {'C', 'E', 'F'},
                {'E', ' ', ' '},
                {'F', ' ', 'G'},
                {'D', ' ', ' '},
                {'G', ' ', ' '}};
        preOrder(tree, tree[0][0], 0);

    }

    public static void preOrder(char[][] tree, char root, int deep){
        if(tree.length < deep){
            return;
        }else{
            System.out.println(root);
            deep++;
            preOrder(tree, tree[deep][1], deep);
            preOrder(tree, tree[deep][2], deep);
        }
    }
}
