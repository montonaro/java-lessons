package task8;  


public class ActivePhones {

	private Phone[] list = new Phone[10];
	private int p = 0;
	
	public void add(Phone s) {
		
		if(list.length == p+1){
			Phone[] newList = new Phone[list.length*2];
			System.arraycopy(list,0,newList,0,list.length);
		}
		
		list[p++] = s; 
	}
	
	public void del(int n) {		 
		
		if(n >= 0 && p > 0 &&  p > n ){
			
			if(n < p-1){
				list[n] = list[p-1];
			}  
			
		} else if(p == n){
			list[n] = null;
		}
		p--;
	}
	
	public int find(String q) { 
		 
		for (int i = 0; i < p; i++) {
			if (list[i].getPhone().equalsIgnoreCase(q))
				return i;
		} 
		return -1;
	}
	
	public Phone get(int n) {
		return list[n];
	}
	
	private void showAll(){
		
		if(p > 0){
			for(int i = 0; i < p; i++){  
				System.out.println(list[i].getPhone()); 
			}
		}
	}
}
