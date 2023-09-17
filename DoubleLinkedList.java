package chap08;

import java.util.Comparator;

public class DoubleLinkedList<E> {
	
	class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		//생성자
		Node() {
			data = null;
			prev = next = this;
		}
		
		//생성자 2
		Node ( E obj, Node<E> prev, Node<E> next) {
			data = obj;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> crnt;
	
	//생성자3-더미노드(노드삭제와 삽입을 원활하게 하기위한 더미)
	public DoubleLinkedList() {
		head = crnt = new Node<E>();
	}
	
	//리스트가 비어있는가?
	public boolean isEmpty() {
		return head.next == head;
	}
	
	//노드검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;	//스캔중인 노드
		
		while (ptr != head) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data; //성공
			}
			ptr = ptr.next;	//다음노드
		}
		return null;	//실패
	}
	
		//선택 노드 출력
	public void printCurrentNode() {
		if (isEmpty()) 
			System.out.println("선택노드가없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	//모든노드출력
	public void dump() {
		Node<E> ptr = head.next;
		
		while (ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E> ptr = head.prev;
		
		while (ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.prev;
		}
	}
	
	//선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (isEmpty() || crnt.next == head)
			return false;
		crnt = crnt.next;
		return true;
	}
	
	//선택 노드를 하나 앞쪽으로 진행
	public boolean prev() {
		if (isEmpty() || crnt.prev == head)
			return false;
		crnt = crnt.prev;
		return true;
	}
	//선택노드 바로 뒤에 노드 삽입
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, crnt, crnt.next);
		crnt.next = crnt.next.prev = node;
		crnt = node;
	}
	
	//머리에 노드 삽입
	public void addFirst(E obj) {
		crnt = head;
		add(obj);
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		crnt = head.prev;
		add(obj);
	}
	
	//선택노드삭제
	public void removeCurrentNode() {
		if (!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if (crnt == head) crnt = head.next;
		}
	}
	
	//노드 p를 삭제
	public void remove(Node p) {
		Node<E> ptr = head.next;
		
		while (ptr != head) {
			if (ptr == p) {
				crnt = p;
				removeCurrentNode();
				break;
			}
			ptr = ptr.next;
		}
	}
	
	//머리노드 삭제
	public void removeFirst() {
		crnt = head.next;
		removeCurrentNode();
	}
	
	//꼬리노드삭제
	public void removeLast() {
		crnt = head.prev;
		removeCurrentNode();
	}
	
	//모든노드삭제
	public void clear() {
		while(!isEmpty())
		removeFirst();
	}
}
