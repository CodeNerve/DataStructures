
// Linked List with implementation in classes


public class Link {
	
	public String bookName;
	public int millionsSold;
	
	public Link next; // all the links know is the address of the previous link
	
	public Link(String bookName, int millionsSold) {
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}
	
	public static void main(String[] args) {
		
		
		LinkList linkedlist = new LinkList();
		
		linkedlist.insertFirstLink("Harry Potter", 27);
		linkedlist.insertFirstLink("Don Jon", 50);
		linkedlist.insertFirstLink("Amazing wonders", 14);
		linkedlist.insertFirstLink("GhostBusters", 2);
		
		
		linkedlist.display();
		
		System.out.println(linkedlist.findLink("Amazing wonders"));
		
	}
	
	public void display() {
		
		System.out.println("The book "+bookName+" was sold "+millionsSold+" million times");
	}
	

}

class LinkList{
	
	public Link firstLink;
	
	public LinkList() {
		
		firstLink = null;
	}
	
	
	public boolean isEmpty() {
		
		if(firstLink == null)
			return true;
		else
			return false;
	}
	
	
	public void insertFirstLink(String bookName, int millionsSold) {
		
		Link newLink = new Link(bookName,millionsSold);
		
		newLink.next = firstLink;
		
		firstLink = newLink;
	}
	
	public Link removeFirst() {
		
		Link refLink = firstLink;
		
		if(!isEmpty())
			firstLink = firstLink.next;
		
		else
			System.out.println("Empty Linked list");
		
		return refLink;
		
		
	}
	
	public void display() {
		
		Link theLink = firstLink;
		
		while(theLink.next!=null) {
			
			theLink.display();
			
			System.out.println("Next Link "+theLink.next.bookName );
			
			theLink = theLink.next;
			
			System.out.println();
		}
		
	}
	
	public Link findLink(String bookName) {
		
		Link theLink = firstLink;
		
		if(!isEmpty()) {
		
			while(!theLink.bookName.equals(bookName)) {
			
				if(theLink.next==null)
					return null;
				
				else
					theLink = theLink.next;
			}
		}
		else
			System.out.println("Empty Linked List");
	
		return theLink;
	
	}
	
	public Link removeLink(String bookName) {
		
		Link curLink = firstLink;
		Link preLink = firstLink;
		
		while(!curLink.next.bookName.equals(bookName)) {
			
			if(curLink.next==null)
				return null;
			else {
				preLink = curLink;
				curLink = curLink.next;
			}
		}
		
		if(curLink == firstLink)
			firstLink = firstLink.next;
		
		else {
			preLink.next = curLink.next;
		}
		
		return curLink;
	}
}
