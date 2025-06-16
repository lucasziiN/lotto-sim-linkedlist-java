public class Main {
    public static void main(String[] args){
        StrLinkedList strLinkedList = new StrLinkedList();
        
        
        System.out.println("Creating an instance of the StrLinkedList...");
        System.out.println("List is empty: " + strLinkedList.isEmpty());
        System.out.println("List length is: " + strLinkedList.getLength());
        System.out.println();

        System.out.println("Adding values A,B,C to the StrLinkedList ...");
        strLinkedList.add("A");
        strLinkedList.add("B");
        strLinkedList.add("C");
        strLinkedList.print();
        System.out.println("List is empty: " + strLinkedList.isEmpty());
        System.out.println("List has value A: " + strLinkedList.hasValue("A"));
        System.out.println("List has value F: " + strLinkedList.hasValue("F"));
        System.out.println("List length is: " + strLinkedList.getLength());
        System.out.println();

        System.out.println("Removing value B from the StrLinkedList ...");
        strLinkedList.remove("B");
        strLinkedList.print();

        System.out.println();
        System.out.println("Removing value A from the StrLinkedList ...");
        strLinkedList.remove("A");
        strLinkedList.print();

        System.out.println();
        System.out.println("Removing value C from the StrLinkedList ...");
        strLinkedList.remove("C");
        strLinkedList.print();

        System.out.println();
        System.out.println("List length is: " + strLinkedList.getLength());

        System.out.println();
        System.out.println("Adding values A, B, C, B, D to the StrLinkedList ...");
        strLinkedList.add("A");
        strLinkedList.add("B");
        strLinkedList.add("C");
        strLinkedList.add("B");
        strLinkedList.add("D");
        strLinkedList.print();

        System.out.println();
        System.out.println("Removing first value B from the StrLinkedList ...");
        strLinkedList.remove("B");
        strLinkedList.print();

        System.out.println();
        System.out.println("Retrieving value at position 0 ...");
        System.out.println("The value at position 0: " + strLinkedList.getValueAt(0));
        

        System.out.println();
        System.out.println("Retrieving value at position 3 ...");
        System.out.println("The value at position 3: " + strLinkedList.getValueAt(3));
        
        System.out.println("Full number list");
        
    }
}
