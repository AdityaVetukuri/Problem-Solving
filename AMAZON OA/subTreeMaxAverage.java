import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class subTreeMaxAverage {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static int subtreeMaxAvg(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE

        return 0;
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<T>(f.apply(val), children);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
        scanner.close();
//        int res = subtreeMaxAvg(root);
//        System.out.println(res);
    }
}
