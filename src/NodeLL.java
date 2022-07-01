// Coding a linked list

public class NodeLL {
	protected char data;
	protected NodeLL next;
	protected int intData;

	public NodeLL() {
		this(Character.MIN_VALUE, null);
	}

	public NodeLL(int i) {
		intData = i;

	}

	public NodeLL(char d) {
		data = d;
	}

	public NodeLL(char d, NodeLL n) {
		data = d;
		next = n;
	}

	//Determines if a NodeLL is empty
	public boolean isEmpty() {
		//If the next NodeLL is null, its empty
		if (this.next == null) {
			return true;
		} else {
			//If not, it has contents (its false)
			return false;
		}
	}

	public void setData(char newData) {
		data = newData;
	}

	public void setNext(NodeLL newNext) {
		next = newNext;
	}

	public int getIntData() {
		return intData;
	}

	public char getData() {
		return data;
	}

	public NodeLL getNext() {
		return next;
	}

	//Determines if there are Nodes after the current element

	public boolean hasNext() {
		//if the current Node is null, then nothing follows it (it's the tail)
		if (this.next != null) {
			return true;
		} else {
			// if not, then more Nodes follow
			return false;
		}
	}

	//Determines the length (number of elements) in a Node
	public int length() {
		//if the next Node after the head is null, return a length of zero
		if (this.next == null) {
			return 0;
		} else {
			//return number of elements in stack trace
			return 1 + next.length();
		}
	}

	//Inserts new Node at given position
	public void insert(NodeLL newNodeLL, int position) {
		//temporary NodeLL to traverse the stack
		NodeLL temp = this;
		int index = 0;
		//taverse the stack
		while (index < position) {
			temp = temp.next;
			index++;
		}
		//Places NodeLL in its given position
		newNodeLL.next = temp.next;
		temp.next = newNodeLL;
	}

	//Places data in a given Node at a given position
	public void insert(char data, int position) {
		//new NodeLL created with given data
		NodeLL newNodeLL = new NodeLL(data);
		//Same code as previous insert method implemented here
		insert(newNodeLL, position);
	}

	//Deletes a given Node in a certain position of the stack 

	public NodeLL delete(int position) {
		//temp NodeLL created to traverse the stack
		NodeLL temp = this;
		//if the stack is empty, exit
		if (this.isEmpty()) {
			System.exit(0);
		}
		int index = 0;
		//traverses stack for the given length of the stack and if the next NodeLL isn't null
		while (index < position && temp.next != null) {
			temp = temp.next;
			index++;
		}
		//defines the removed NodeLL and returns it
		NodeLL removed = temp.next;
		temp.next = temp.next.next;
		return removed;
	}

	public void print() {
		//temp Node created to traverse data
		NodeLL temp = this.next;
		//Before stack ends, traverse it and print the data within each stack
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public void print(NodeLL temp) {
		//temp NodeLL created to traverse data
		temp = this.next;
		//Before stack ends, traverse it and print the data within each stack
		while (this != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	//Main Method for testing
	public static void main(String[] args) {
		System.out.println("---Testing Linked List Operations---\n");
		NodeLL node = new NodeLL();

		node.insert('a', 0);
		node.insert('b', 0);
		node.insert('c', 0);
		node.insert('d', 0);

		System.out.println("Insert\n");
		System.out.println("Expected: dcba");
		System.out.print("Actual: ");
		node.print();

		node.delete(0);

		System.out.println("\n\nDelete\n");
		System.out.println("Expected: cba");
		System.out.print("Actual: ");
		node.print();

		System.out.println("\n\nLength\n");
		System.out.println("Expected: 3");
		System.out.print("Actual: ");
		System.out.print(node.length());

		node.insert('v', 1);
		System.out.println("\n\nInsert for given postion (other than at head):\n");
		System.out.println("Expected: cvba");
		System.out.print("Actual: ");
		node.print();

		node.delete(2);
		System.out.println("\n\nDelete for given postion (other than at head):\n");
		System.out.println("Expected: cva");
		System.out.print("Actual: ");
		node.print();


		System.out.println("\n\nIs Empty:\n");
		System.out.println("Expected: false");
		System.out.print("Actual: ");
		System.out.print(node.isEmpty());

	}

}
