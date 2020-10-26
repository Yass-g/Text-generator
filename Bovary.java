
public class Bovary {
	static HMap buildTable(String[] files, int n)
	{
		HMap table = new HMap();
		for(int f = 0; f<files.length;f++)
		{
			Prefix cur = new Prefix(n);
			WordReader wr = new WordReader(files[f]);
			String w;
			for (w = wr.read(); w != null; w = wr.read()) {
				table.add(cur, w);
				cur = cur.addShift(w);
			}
			table.add(cur, Prefix.end);
			
			
		}
		return table;
	}
	
	static String rand(HMap t,Prefix P)
	{
		WordList wl = t.find(P);
		Node cur = wl.content;
		int r = (int)(Math.random()*wl.length());
		for(int i = 0;i<r;i++)
			cur=cur.next;
		return cur.head;
			
		
	}
	
	static void generate(HMap t, int n) {
		Prefix cur = new Prefix(n);
		String s = rand(t,cur);
		while(!s.equals(Prefix.end))
		{
			if(s.equals(Prefix.par))
			{
				System.out.print("\n\n");
			}else
			{
				System.out.print(s+" ");
				
			}
			cur = cur.addShift(s);
			s = rand(t,cur);
			
		}
		System.out.println();
		
		
	}
	public static void main(String[] args) {
		int n = 3;
		String[] files = {"bovary/01.txt","bovary/20.txt","bovary/35.txt"};
		HMap t = buildTable(files,n);
		generate(t,n);

	}

}
