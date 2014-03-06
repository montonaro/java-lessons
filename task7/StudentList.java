package task7; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentList {
	private Student[] list = new Student[100];
	private int p = 0;
	
	private void expand(){
		Student[] newList = new Student[list.length*2];
		System.arraycopy(list,0,newList,0,list.length);
	}
	
	public void add(Student s) {
		
		if(list.length == p+1){
			expand();
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
	
	public Student get(int n) {
		return list[n];
	}
	
	public void showAll(){
		
		if(p > 0){
			for(int i = 0; i < p; i++){
				
				Student item = list[i]; 
				System.out.println(item.getName()+" "+item.getSurname());
				
			}
		}
	}
	
	public int find(String q) {
		for (int i = 0; i < p; i++) {
			if (list[i].getName().equalsIgnoreCase(q) || list[i].getSurname().equalsIgnoreCase(q))
				return i;
		}
		
		return -1;
	}
	
	public int find(Date q) {
		for (int i = 0; i < p; i++) {  
 
			if (list[i].getBirth().equals(new SimpleDateFormat("dd/MM/yyyy").format(q)))
				return i;
		}
		
		return -1;
	}
	
 
}
