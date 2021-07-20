
class WordList {
	  Node content;
	  WordList() {
	    content = null;
	  }
	
	  WordList(Node n) {
		    this.content = n;
	  }
	  
	  WordList(String[] t){
		  for(int i = 0; i<t.length;i++)
		  {
			  this.addLast(t[i]);
		  }
	  }
	
	  int length() {
		  int cnt = 0;
		  for (Node cur = this.content; cur != null; cur = cur.next) {
			  cnt++;
		  }
		  return cnt;
	  }
	
	  String print() {
		  String res = "[";
		  if(this.content==null)
			  return "[]";
		  for (Node cur = this.content; cur != null; cur = cur.next) {
			  res = res + cur.head;
			  if(cur.next==null)
				  res = res+"]";
			  else
				  res=res+", ";
				  
		  }
		  return res;
	  }
	  
	  void addFirst(String w) {
		  Node F = new Node(w,this.content);
		  this.content = F;
	  }
	  
	  void addLast(String w) {
		  Node L = new Node(w,null);
		  Node cur=this.content;
		  if(cur==null)
			   this.content=L;
		  else
		  {
			   while(cur.next!= null) {
				   cur = cur.next;
			   }
			   cur.next = L; 
		  }
		 
	  }
	  
	  String removeFirst() {
		  if(this.content==null)
			  return null;
		  String res = this.content.head;
		  this.content = this.content.next;
		  return res;
	  }
	  
	  String removeLast() {
		  if(this.content==null)
			  return null;
		  if(this.content.next==null)
		  {
			  String res = this.content.head;
			  this.content=null;
			  return res;
		  }
		  String s;
		  Node cur = this.content;
		  while(cur.next.next != null) {
			  cur = cur.next;
		  }
		  
		  s = cur.next.head;
		  cur.next = null;
		  return s;
		  
	  }
	  
	  void insert(String s) {
		  Node ins = new Node(s,null);
		  if(this.content==null||s.compareTo(this.content.head)<=0)
		  {
			  ins.next = this.content;
			  this.content=ins;
		  }else
		  {
			  Node cur = this.content;
			  while(cur.next!=null&&s.compareTo(cur.next.head)>0)
				  cur = cur.next;
			  ins.next=cur.next;
			  cur.next=ins;
		  }
		  
	  }
		
	  void insertionSort() {
		  WordList sorted = new WordList();
		  Node cur = this.content;
		  while(cur!=null)
		  {
			  sorted.insert(cur.head);
			  cur = cur.next;
		  }
		  this.content = sorted.content;
	  }
	  
	  String[] toArray()
	  {
		  String[] res = new String[this.length()];
		  Node cur = this.content;
		  for(int i = 0; i<this.length();i++)
		  {
			  res[i] = cur.head;
			  cur=cur.next;
		  }
		  return res;
		  
		  
	  }
}
