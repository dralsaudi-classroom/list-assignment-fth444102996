package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {

        
        DLLNode<T> tmp1, tmp2, tmp3; 
        
        if(head!=null) {
        	tmp1 = head;
        	
        	while(tmp1.data!=e1 && tmp1.next!=null) {
             	tmp1 = tmp1.next;
            }
        	if(tmp1.next != null) {
        		current = tmp1;
        		while(current.data!=e2 && current.next!=null) {
        			current = current.next;
        		}
        		if(current.data == e2 && tmp1.next!=current) {
        			tmp2 = tmp1.next;
        			do {
        				tmp3 = tmp2;
        				tmp2 = tmp2.next;
        				tmp3 = null;
        			}while(tmp2!=current);
        			
        			tmp1.next = current;
        			current.previous = tmp1;
        		}
        	}
        }
        
        // Write the method removeBetween, member of the class DoubleLinkedList. The method
        // takes two elements e1 and e2, and removes all the elements between the two elements
        // (e1 and e2 not included). If e1 or e2 or both doesn’t exist, no element will be removed. You can assume the elements to be unique, e1 comes before e2, and that
        // e1 ̸= e2. Current is moved to head if the removal is successful. Do not call any
        // methods and do not use any auxiliary data structures. The method signature
        // is: public void removeBetween(T e1, T e2).
        // Example 3.1. Given the list: A ↔ B ↔ C ↔ D ↔ E ↔ F, removeBetween(’B’,
        // ’E’) results in: A ↔ B ↔ E ↔ F.
    }
}