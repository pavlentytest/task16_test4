import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;
    Node(int value) {
       this.value = value;
       this.left = null;
       this.right = null;
    }
}

public class BinaryTree {
    Node root;

    public void add(int value) {
        root = addRecurs(root, value);
    }


    public Node addRecurs(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if(value < current.value) {
            current.left = addRecurs(current.left, value);
        } else if (value > current.value) {
            current.right = addRecurs(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public int size() {
        return sizeRecurs(root);
    }
    public int sizeRecurs(Node node) {
        if(node.left == null && node.right == null) {
            return 0;
        } else if(node.left == null) {
            return sizeRecurs(node.right) + 1;
        } else if(node.right == null) {
            return sizeRecurs(node.left) + 1;
        } else {
            int v1 = sizeRecurs(node.left);
            int v2 = sizeRecurs(node.right);
            return Math.max(v1,v2) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int n =  scanner.nextInt(); // считываем до пробела
        // 7 3 2 1 9 5 4 6 8 0
        while(n != 0) {
            // добавление в дерево
            tree.add(n);
            n = scanner.nextInt();
        }
        System.out.println(tree.size());

    }
}