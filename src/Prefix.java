
public class Prefix {
	 String[] t;
     	 Prefix(int n)
	 {
		 t = new String[n];
		 for(int i=0;i<n;i++)
		 {
			 t[i] = start; 
		 }
	 }
     
	 static boolean eq(Prefix p1, Prefix p2)
	 {
		 if(p1==null||p2==null)
			 return false;
		 int n1 = p1.t.length, n2 = p2.t.length;
		 if(n1!=n2)
			 return false;
		 for(int i = 0;i<n1;i++)
		 {
			 if(!p1.t[i].equals(p2.t[i]))
				 return false;
		 }
		 return true;
	 }
	 
	 Prefix addShift(String w)
	 {
		 int n = this.t.length;
		 Prefix shift = new Prefix(n);
		 for(int i = 1;i<n;i++)
		 {
			 shift.t[i-1]=this.t[i];
		 }
		 shift.t[n-1]=w;
		 return shift;
	 }
	 public int hashCode()
	 {
		 int h = 0;
		 for(int i=0;i<this.t.length;i++)
		 {
			 h = 37*h + t[i].hashCode();
		 }
		 return h;
	 }
	 
	 int hashCode(int n) {
		 return (this.hashCode()%n + n)%n;
	 }
	 
	 final static String start = "<START>", end = "<END>", par = "<PAR>";

}
