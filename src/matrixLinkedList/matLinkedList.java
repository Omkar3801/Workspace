package matrixLinkedList;



public class matLinkedList {
	
	node head;

	public void constructMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        node[] prevRow = new node[cols];
        node prev = null;

        for (int i = 0; i < rows; i++) {
            prev = null;
            for (int j = 0; j < cols; j++) {
                int value = arr[i][j];
                node newNode = new node(value);
                if (prev != null) {
                    prev.right = newNode;
                } else {
                    if (i == 0 && j == 0) {
                        head = newNode;
                    }
                }

                if (i > 0) {
                    prevRow[j].down = newNode;
                }
                prevRow[j] = newNode;
                prev = newNode;
            }
        }
    }

    // Method to insert at a specified row and column, with automatic row expansion
    public void insertAt(int row, int col, int value) {
    	
    	if(col==0) {
        	System.out.println("use InsertAtbeg. method");
        	return;
        }
        if (row < 0 || col < 0) {
            System.out.println("Invalid position");
            return;
        }

        // Expand matrix by adding new rows if necessary
        while (getRowCount() <= row) {
            addRow();
        }

        node newNode = new node(value);
        node curr = head;

        // Traverse to the specified row
        for (int i = 0; i < row; i++) {
            curr = curr.down;
        }

        // Traverse to the specified column
        for (int j = 0; j < col-1; j++) {
            curr = curr.right;
        }

        // Insert the new node
        newNode.right = curr.right;
        curr.right = newNode;
    }

    // Helper method to get the current number of rows in the matrix
    private int getRowCount() {
        int count = 0;
        node temp = head;
        while (temp != null) {
            count++;
            temp = temp.down;
        }
        return count;
    }

    // Method to add a new row at the end of the matrix
    private void addRow() {
        if (head == null) {
            return;
        }

        node curr = head;
        while (curr.down != null) {
            curr = curr.down;
        }

        node newRow = new node(0);
        node newRowHead = newRow;
        node prev = curr;
        curr = curr.right;

        while (curr != null) {
            newRow.right = new node(0);
            prev.down = newRowHead;
            prev = curr;
            newRow = newRow.right;
            curr = curr.right;
        }
        prev.down = newRowHead;
    }

    public void replaceAt(int row, int col, int newValue) {
        node curr = head;
        
        

        for (int i = 0; i < row; i++) {
            if (curr != null) {
                curr = curr.down;
            }
        }

        for (int j = 0; j < col; j++) {
            if (curr != null) {
                curr = curr.right;
            }
        }

        if (curr != null) {
            curr.data = newValue;
        } else {
            System.out.println("Invalid position");
        }
    }

    public void deleteAt(int row, int col) {
        node curr = head;
        node prev = null;

        for (int i = 0; i < row; i++) {
            if (curr != null) {
                prev = curr;
                curr = curr.down;
            }
        }

        node rowStart = curr;

        for (int j = 0; j < col; j++) {
            if (curr != null) {
                prev = curr;
                curr = curr.right;
            }
        }

        if (curr != null) {
            if (prev != null) {
                if (prev.right == curr) {
                    prev.right = curr.right;
                }
                if (rowStart == curr) {
                    if (curr.down != null) {
                        rowStart.data = curr.down.data;
                        rowStart.right = curr.down.right;
                        rowStart.down = curr.down.down;
                        prev = rowStart;
                        curr = curr.down;
                    } else {
                        rowStart = curr.right;
                    }
                }
            } else {
                head = curr.right != null ? curr.right : curr.down;
            }
        }
    }

    // Method to insert a new row or column at the beginning of the matrix
    public void insertAtBeginning(int value, boolean insertRow) {
        node newNode = new node(value);

        if (insertRow) {
            // Insert a new row at the beginning
            newNode.down = head;
            node curr = newNode;
            node temp = head;
            while (temp != null) {
                temp = temp.right;
                if (temp != null) {
                    curr.right = new node(0);  // Initialize new nodes in the row with 0
                    curr = curr.right;
                }
            }
            head = newNode;
        } else {
            // Insert a new column at the beginning
            newNode.right = head;
            node curr = newNode;
            node temp = head;
            while (temp != null) {
                temp = temp.down;
                if (temp != null) {
                    curr.down = new node(0);  // Initialize new nodes in the column with 0
                    curr = curr.down;
                }
            }
            head = newNode;
        }
    }

    public void displayMatrix() {
        node row = head;
        while (row != null) {
            node curr = row;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            System.out.println();
            row = row.down;
        }
    }
	

}
