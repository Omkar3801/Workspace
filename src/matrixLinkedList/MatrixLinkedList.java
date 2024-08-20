package matrixLinkedList;

class node {
	int data;
	node right, down;

	node(int data) {
    this.data = data;
    this.right = null;
    this.down = null;
}
}

public class MatrixLinkedList extends matLinkedList {
    

    public static void main(String[] args) {
    	
    	//create an 5x5 array
        int[][] arr = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        
        //create an object of MatrixLinkedList which has inherited matLinkedlist

        MatrixLinkedList matrix = new MatrixLinkedList();
        
        //convert arr into matrix linked list containing .right and .down ref.
        matrix.constructMatrix(arr);

        System.out.println("Original Matrix:");
        //display method of matLinkedList
        matrix.displayMatrix();
        
        // Inserting any number at desire location. Here we can add any number between boundary of an matrix. 
        //after addition matrix size will change.

        matrix.insertAt(1, 4, 99);
        System.out.println("\nMatrix after inserting 99 at position (1, 4):");
        matrix.displayMatrix();
        
        matrix.insertAt(4, 2, 0);
        System.out.println("\nMatrix after inserting 0 at position (4, 2):");
        matrix.displayMatrix();
        
        matrix.insertAt(7,1, 939);
        System.out.println("\nMatrix after inserting 939 at position (4, 6):");
        matrix.displayMatrix();
        
        matrix.insertAt(0, 2, 100);
        System.out.println("\nMatrix after inserting 100 at position (0, 2):");
        matrix.displayMatrix();

        // replace any value of any node
        matrix.replaceAt(3, 3, 42);
        System.out.println("\nMatrix after replacing value at position (3, 3) with 42:");
        matrix.displayMatrix();

        //delete any desire node
        matrix.deleteAt(2, 4);
        System.out.println("\nMatrix after deleting node at position (2, 4):");
        matrix.displayMatrix();
    }
}


