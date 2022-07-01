
// QueueLL Class Created
public class QueueLL extends NodeLL {

	protected NodeLL front;
	protected NodeLL rear;
	protected static int size;

	public QueueLL() {
		size = 0;
		front = null;
		rear = null;
	}

	public boolean empty() {
		return (size == 0);
	}

	public void enqueue(char ch) {
		//NodeLL newNode = new NodeLL(ch);
		if (front == null) {
			rear = new NodeLL(ch);
			front = rear;
			size++;
		} else {
			rear.next = new NodeLL(ch);
			rear = rear.next;
			size++;
		}
	}

	public char dequeue() {
		char i;
		i = front.getData();
		front = front.getNext();
		size--;
		if (this.isEmpty()) {
			rear = null;
		}
		return i;
	}

	public char front() {
		return front.getData();
	}

	public void displayQueue() {
		NodeLL currentNode = new NodeLL();
		currentNode = front;
		while (currentNode != null) {
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public int size() {
		return size;
	}


	//Main method for testing
	public static void main(String[] args) {
		QueueLL queue = new QueueLL();

		System.out.println("---Testing Queue Operations---\n");

		//front
		queue.enqueue('v');
		queue.enqueue('i');
		queue.enqueue('n');
		queue.enqueue('n');
		queue.enqueue('y');
		//rear

		System.out.println("enqueue\n");
		System.out.println("Expected: vinny");
		System.out.print("Actual: ");
		queue.displayQueue();
		System.out.println("\nSize: " + queue.size());

		queue.dequeue();
		System.out.println("\n\ndequeue\n");
		System.out.println("Expected: inny");
		System.out.print("Actual: ");
		queue.displayQueue();
		System.out.println("\nSize: " + queue.size());

		System.out.println("\n\nget front\n");
		System.out.println("Expected: i");
		System.out.print("Actual: ");
		System.out.print(queue.front());

		System.out.print("\n\n\nqueue will now dequeue the remaining characters...\n");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		System.out.println("\n\nsize\n");
		System.out.println("Expected: 0");
		System.out.print("Actual: ");
		System.out.print(queue.size());
		queue.enqueue('h');
		queue.enqueue('i');
		System.out.print("\n\nTwo characters have been added, testing size again: \n\n");
		System.out.println("Expected: 2");
		System.out.print("Actual: ");
		System.out.print(queue.size() + "\n");

	}

}
