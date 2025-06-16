public class StrLinkedList {

    //head of the linked list
    Node head;
    
    /**
     *constructs for an empty linked list.
     */
    public StrLinkedList(){
        head = null;
    }

    /**
     *checks if the linked list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty(){
        //check if the head node is null, indicating an empty list
        if(head == null){
            return true;
        }
        return false;
    }

    /**
     *gets the length of the linked list.
     *
     * @return the number of elements in the list.
     */
    public int getLength(){
        Node curr = head;   //start at the head of the list
        int length = 0;     //initialize the length counter to 0

        //loop through the list and increment the counter for each node visited
        while (curr != null){   
            length++;
            curr = curr.next;
        }
        
        return length;
    }

    /**
     *checks if the linked list contains a specific value.
     *
     * @param s the value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean hasValue(String s){
        Node curr = head;   //atart at the head of the list
        //loop through the list until the end is reached
        while(curr != null){    
            //check if the current node's value matches the input string
            if(curr.value.equals(s)){   
                return true;
            }
            curr = curr.next;   // Move to the next node in the list
        }
        return false;
    }

    /**
     *gets the value at a specific index in the linked list.
     *
     * @param i the index of the value to retrieve.
     * @return the value at the specified index, or null if the index is invalid.
     */
    public String getValueAt(int i){
        Node curr = head;   //start at the head of the list
        String str = "";    //initialize an empty string to hold the value

        //check if the index is out of bounds
        if (i<0 || i>getLength()){
            System.out.println("Invalid index!");   // Print an error message for invalid index
            return null;
        }

        //loop through the list to the specified index
        for (int j = 0; j<i; j++){
            //move to the next node in the list
            curr = curr.next;
        }
        str = curr.value;   // Get the value at the specified index
        return str;     // Return the value
    }

    /**
     *adds a new value to the beginning of the linked list.
     *
     * @param s the value to add.
     */
    public void add(String s){
        
        Node newNode = new Node(s);

        //if list is empty
        if (head == null){
            head = newNode; //set head as the new node created with the input value
            
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     *prints the elements of the linked list.
     */
    public void print(){
        Node curr = head;   //start at the head of the list

        //loop through the list and print each node's value
        while (curr != null){
            System.out.print(curr.value + "->");    // Print the current node's value followed by an arrow
            curr = curr.next;   // Move to the next node in the list
        }
        
    }

    /**
     *removes a specific value from the linked list.
     *
     * @param s the value to remove.
     */
    public void remove(String s){
        
        // IF List is empty or does not contain the value s, no need to remove
        if (isEmpty() && !hasValue(s)){
            return;
        }


        Node prev = head;   //initialize prev as the head of the list
        Node curr = head.next;  //initialize curr as the next node after head

        //check if the first node contains the value to be removed
        if (prev.value == s){
            head = curr;
            return;
        }

        //loop through the list to find the node containing the value s
        while (prev.value != null){
            if (curr.value == s){
                prev.next = curr.next; //remove the current node by linking prev to curr's next node
                return; //exit the method after removing the node
            }
        
        }
        
    }
}
