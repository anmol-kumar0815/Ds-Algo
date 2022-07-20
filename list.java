import java.util.Scanner;
public class list extends DoublyLinkedListImplementation{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList list1 = new DoublyLinkedList();
        int n = scn.nextInt();
        for(int i=0; i<n; i++){
            int data = scn.nextInt();
            list1.addLast(data);
        }
        list1.display();
    }
}