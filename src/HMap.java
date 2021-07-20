
public class HMap {
	EntryList[] t;
	int size;
	HMap(int n)
	{
		this.t = new EntryList[n];
	}
	
	HMap()
	{
		this.t = new EntryList[20];
	}
	
	WordList find(Prefix key)
	{
		int k = key.hashCode(t.length);
		EntryList cur = this.t[k];
		
		while(cur !=null )
		{
			if(Prefix.eq(cur.head.key,key))
				break;
			cur = cur.next;
		}
		if(cur==null)
			return null;
		return cur.head.value;
	}
	
	void addSimple(Prefix key, String w)
	{
		int k = key.hashCode(t.length);
		if(find(key)==null)
		{
			this.size++;
			Entry n = new Entry(key, new WordList(new Node(w,null)));
			this.t[k] = new EntryList(n,this.t[k]);
		}else
		{
			EntryList cur = this.t[k];
			while(!Prefix.eq(cur.head.key,key))
			{
				cur = cur.next;
			}
			cur.head.value.addLast(w);
			
		}
	}
	
	void rehash(int n)
	{
		EntryList[] nt = new EntryList[n];
		for(int i = 0; i<this.t.length; i++)
		{
			EntryList cur = this.t[i];
			while(cur !=null)
			{
				Entry temp = cur.head;
				nt[temp.key.hashCode(n)] = new EntryList(new Entry(temp.key,temp.value), nt[temp.key.hashCode(n)]);
				cur = cur.next;
			}
		}
		this.t=nt;
	}
	
	void add(Prefix key, String w)
	{
		this.addSimple(key,w);
		if(size>0.75*this.t.length)
		{
			rehash(this.t.length*2);
		}
		
	}

}
