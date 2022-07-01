
// StackLL class created
public class StackLL extends NodeLL {

	protected int size;

	public StackLL() {
		next = null;
	}

	public StackLL(char data, NodeLL next) {
		super(data, next);
	}

	public StackLL(char data) {
		super(data);
	}

	//Pushes new element onto top of StackLL
	public NodeLL push(char data) {
		//New NodeLL created to represent the new element on StackLL
		NodeLL newNodeLL = new NodeLL(data);
		//The next element on the StackLL defined as the new NodeLL being pushed onto it
		newNodeLL.next = this.next;
		this.next = newNodeLL;
		return newNodeLL;
	}

	public NodeLL push(int data) {
		//New NodeLL created to represent the new element on StackLL
		NodeLL newNodeLL = new NodeLL(data);
		//The next element on the StackLL defined as the new NodeLL being pushed onto it
		newNodeLL.next = this.next;
		this.next = newNodeLL;
		return newNodeLL;
	}

	//Removes element from top of StackLL
	public NodeLL pop() {
		//if the StackLL trace is empty, return null
		if (isEmpty()) {
			System.out.println("The return value is 'null', program did not crash!!!");
			return null;
		} else {
			//temp defines the value after temp.next to be the new first value; the first element is removed
			NodeLL temp = this;
			this.next = this.next.next;
			return temp;
		}
	}

	//Returns the first element of the StackLL without removing that element
	public NodeLL peek() {
		//If the StackLL trace is empty, returns null
		if (isEmpty()) {
			return null;
		} else {
			//temp represents the NodeLL at the top of the StackLL
			NodeLL temp = new NodeLL(this.next.data);
			return temp;
		}
	}

	//Main Method for Testing

	public static void main(String[] args) {

		StackLL stack = new StackLL();

		System.out.println("---Testing Stack Operations---\n");

		//bottom
		stack.push('d');
		stack.push('c');
		stack.push('b');
		stack.push('a');
		//top

		System.out.println("push:\n");
		System.out.println("Expected: abcd");
		System.out.print("Actual: ");
		stack.print();

		stack.pop();

		System.out.println("\n\npop:\n");
		System.out.println("Expected: bcd");
		System.out.print("Actual: ");
		stack.print();


		System.out.println("\n\npeek:\n");
		System.out.println("Expected: b");
		System.out.print("Actual: ");
		NodeLL peek = stack.peek();
		System.out.print(peek.data);

		stack.pop();
		stack.pop();
		stack.pop();

		System.out.println("\n\nIs Empty:\n");
		System.out.println("Expected: true");
		System.out.print("Actual: ");
		System.out.print(stack.isEmpty());

		stack.push('y');
		stack.push('n');
		stack.push('n');
		stack.push('i');
		stack.push('v');

		System.out.println("\n\nLength\n");
		System.out.println("Expected: 5");
		System.out.print("Actual: ");
		System.out.print(stack.length());

	}

}
