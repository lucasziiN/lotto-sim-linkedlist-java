public class Node{

    String value;   //the value stored in this node
    Node next;      //reference to the next node in the linked list

    //constructor to initialize a new node with a given value
    public Node(String str){
        value = str;    //set the value of the node
        next = null;    //initialize the next node reference to null
    }
}