import java.io.*;
import java.util.*;

/**
 * 대문자 알파벳으로 들어오는 Name을 - A를 해서 tree의 인덱스로 사용함
 */

public class Main {
    static class Node {
        char name;
        Node left;
        Node right;

        public Node(char name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }

    static int N, size;
    static Node[] tree;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 26)
        tree = new Node[N+1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            if(tree[root - 'A'] == null) tree[root - 'A'] = new Node(root);
            if(left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }
            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append("\n");

        inorder(tree[0]);
        sb.append("\n");

        postorder(tree[0]);

        System.out.println(sb.toString());
    }

    public static void preorder(Node node) {
        if(node == null) return;

        sb.append(node.name);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node == null) return;

        inorder(node.left);
        sb.append(node.name);
        inorder(node.right);

    }

    public static void postorder(Node node) {
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.name);
    }
}