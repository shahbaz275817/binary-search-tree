import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Shahbaz on 2/13/2018.
 */
public class BST
{
    static boolean goalFound=false;
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(20);
        int nums[] = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};

        for(int i : nums)
        {
            binaryTree.addNode(i);
        }

        System.out.println("Enter the goal node");
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();

        /*
        This is also a DFS search algorithm for a tree
        */
        System.out.println("**************");
        System.out.println("In Order Traversal:");
        binaryTree.inorder(goal,goalFound);
        System.out.println("**************");
//        if(goalFound==true)
//            System.out.println("Goal Found");
//        if(goalFound==false)
//            System.out.println("Goal not found");
        System.out.println("Pre Order Traversal:");
        binaryTree.preorder(goal);
        System.out.println("\n**************");
        System.out.println("Post Order Traversal:");
        binaryTree.postorder(goal);
        System.out.println("\n**************");
        System.out.println();
        System.out.println("\n**************");

        /*
        * BFS traversal using a queue (level order traversal)
        */
        System.out.println("BFS traversal:");
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);
        while(!queue.isEmpty()){
            BinaryTree tempNode = queue.poll();
            System.out.print(tempNode.getData() + " ");
            if(tempNode.getLeft()!=null){
                queue.add(tempNode.getLeft());
            }
            if(tempNode.getRight()!=null){
                queue.add(tempNode.getRight());
            }
        }
        System.out.println("\n**************");
    }



}

class BinaryTree{

    private int data;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void addNode(int data){
        if(data<this.data){
            if(this.left!=null){
                this.left.addNode(data);
            }
            else{
                this.left = new BinaryTree(data);
            }
        }
        else{
            if(this.right!=null){
                this.right.addNode(data);
            }
            else{
                this.right = new BinaryTree(data);
            }
        }
    }

    public void inorder(int goal,boolean goalFound){

        if(this.left!=null){
            this.left.inorder(goal,goalFound);
        }
        System.out.print(this.data+" ");
        if(this.data==goal){
            goalFound=true;
            System.out.println("goal found");
            //System.exit(0);
        }

        if(this.right!=null){
            this.right.inorder(goal,goalFound);
        }

    }

    public void preorder(int goal){
        System.out.print(this.data+" ");
        if(this.left!=null){
            this.left.preorder(goal);
        }
        if(this.right!=null){
            this.right.preorder(goal);
        }
    }

    public void postorder(int goal){
        if(this.left!=null){
            this.left.preorder(goal);
        }
        if(this.right!=null){
            this.right.preorder(goal);
        }
        System.out.print(this.data+" ");
    }

    public int getData()
    {
        return this.data;
    }

    public BinaryTree getLeft()
    {
        return this.left;
    }

    public BinaryTree getRight()
    {
        return this.right;
    }
}
