/** * Java Program to reverse a singly list without and with using recursion. */ 
public class LinkedListProblem {
	
	public static void main(String[] args) 
	{ 
		// creating a singly linked list 
		SinglyLinkedList.Node head = new SinglyLinkedList.Node(1); 
		SinglyLinkedList linkedlist = new SinglyLinkedList(head); 
		
		// adding node into singly linked list 
		linkedlist.add(new SinglyLinkedList.Node(2)); 
		linkedlist.add(new SinglyLinkedList.Node(3)); 
		linkedlist.add(new SinglyLinkedList.Node(4));
		linkedlist.add(new SinglyLinkedList.Node(5));
		linkedlist.add(new SinglyLinkedList.Node(5));
		linkedlist.addItems(new int[]{10,8,11}); 
		
		// printing a singly linked list 
		linkedlist.print(); 
		// reversing the singly linked list 
		
	//	linkedlist.reverse(); 
    //	linkedlist.print(); 
    	
	//	int a[] = {1,5};
    //    linkedlist.callRecursive();
        //linkedlist.removeItem(new int[]{1,2,5});

		// printing the singly linked list again 
    	linkedlist.print(); 
    	
    	linkedlist.sortLinkedList();
    	linkedlist.print(); 
	} 
	
}
/** * A class to represent singly list in Java * * @author WINDOWS 8 * */ 

class SinglyLinkedList 
{
	static class Node 
	{ 
		private int data; 
		private Node next; 
		
		//Construtor dos nodes
		public Node(int data) 
		{ 
			this.data = data; 
		} 
		
		//Retorna o conteúdo do node
		public int data() 
		{ 
			return data; 
		} 
		
		//Retorna o node next
		public Node next() 
		{ 
			return next; 
		} 
	} 	
	private Node head; 
	
	//Construtor da lista passando o node head
	public SinglyLinkedList(Node head) 
	{ 
		this.head = head; 
	} 
	
	/** * Java method to add an element to linked list * @param node */ 
	public void add(Node node) 
	{ 
		Node current = head; 
		while (current != null) 
		{ 
			if (current.next == null) 
			{ 
				current.next = node; 
				break; 
			} 
			
			current = current.next; 
		} 
	} 
	
	/** * Java method to print a singly linked list */ 
	public void print() 
	{ 
		Node node = head; 
		while (node != null) 
		{ 
			System.out.print(node.data() + " "); 
			node = node.next(); 
		} 
		
		System.out.println(""); 
	} 
	
	/** * Java method to reverse a linked list without recursion */ 
	public void reverse() 
	{ 
		Node pointer = head; 
		Node previous = null, 
		current = null; 
		while (pointer != null) 
		{ 
			current = pointer; 
			pointer = pointer.next; 
	
        	// reverse the link 
			current.next = previous; 
			previous = current; 
			head = current; 
		} 
	} 
	
	public void callRecursive()
	{
	    if (head != null)
	       head = reverseRecursive(null, head);
	}
	
	public Node reverseRecursive(Node prev, Node current)
    {
       Node next = current.next;
       current.next = prev;
       
       return (next == null) ? current : reverseRecursive(current, next);
       
    }
    
    public void removeItem(int items[])
    {
        for (int i = 0; i < items.length; i++)
        {
            if (head != null && head.data == items[i])
                head = head.next;

            Node pointer = head;
            Node previous = null;
            Node next = null;
        
            while (pointer != null)
            {
                next = pointer.next;
                
                if (next != null && next.data == items[i])
                {					
                    pointer.next = next.next;
					next = null;
                }
                else
                    pointer = pointer.next;
            }
        
        }
	
    }
	
	public void addItems(int items[])
	{
		for (int i = 0; i < items.length; i++)
		{
			add(new Node(items[i]));			
		}
	}
	
	public void sortLinkedList()
	{
	    boolean hasChanges = false;
	    Node pointer = head;
	    Node next = null;
	    Node previous = null;
	    
	    while(pointer != null)
	    {
	        
	        next = pointer.next;
	        
	        if (next != null)
	        {
	            if(pointer.data > next.data)
	            {
	                hasChanges = true;
	                pointer.next = next.next;
	                next.next = pointer;
	                
	               // if (pointer == head)
	               //     head = next;
	               // else
	                previous.next = next;
	            }
	            else
	            {
	                previous = pointer;
	                pointer = pointer.next;
	            }
	        }
	    //    else if (hasChanges)
	    //    {
	    //       pointer = head;
	    //       hasChanges = false;
	    //    }
	    }
	}

}
