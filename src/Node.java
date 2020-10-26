
class Node {

	String head;
	  Node next;

	  Node(String head, Node next) {
	    this.head = head;
	    this.next = next;
	  }
	  static int lengthRec(Node l) {
		  if ( l == null ) return (0);
		  return (1 + lengthRec( l.next));
	  }
	  static int length(Node l) {
		  int cnt = 0;
		  for (Node cur = l; cur != null; cur = cur.next) {
			  cnt++;
		  }
		  return cnt;
		  
	  }
	  static String printNodes(Node l) {
		  String res = "[";
		  if(l==null)
			  return "[]";
		  for (Node cur = l; cur != null; cur = cur.next) {
			  res = res + cur.head;
			  if(cur.next==null)
				  res = res+"]";
			  else
				  res=res+", ";
				  
		  }
		  return res;
		  
	  }
	  static void addLast(String s, Node l)
	  {
		  Node cur;
		  for(cur = l; cur.next != null; cur = cur.next) {
			  
		  }
		  cur.next = new Node(s,null);
	  }
	  static Node copy(Node the) {
		  if(the ==null)
			  return null;
		  Node res = new Node(the.head,copy(the.next));
		  return res;
		  
	  }
	  static Node insert(String s, Node l) {
		  Node ins = new Node(s,null);
		  if(l==null||s.compareTo(l.head)<=0)
		  {
			  ins.next = l;
			  l=ins;
		  }else
		  {
			  Node cur = l;
			  while(cur.next!=null&&s.compareTo(cur.next.head)>0)
				  cur = cur.next;
			  ins.next=cur.next;
			  cur.next=ins;
		  }
		  return l;
			  
	  }
	  static Node insertionSort(Node l)
	  {
		  Node sorted = null;
		  Node cur = l;
		  while(cur!=null)
		  {
			  sorted = insert(cur.head,sorted);
			  cur = cur.next;
		  }
		  return sorted;
	  }

}
