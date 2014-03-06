package task7;

import java.util.Date;

public class MyClass {

	public static void main(String[] args) {
		StudentList sl = new StudentList();
		
		sl.add(new Student("Seva", "Evgienko", new Date(1986-1900, 1, 1)));
		sl.add(new Student("Vasya1", "1Pupkin", new Date(1970-1900, 3, 28)));
		sl.add(new Student("Vasya2", "2Pupkin", new Date(2000-1900, 3, 28)));
		sl.add(new Student("Vasya3", "3Pupkin", new Date(1990-1900, 2, 28)));
		sl.add(new Student("Vasya4", "4Pupkin", new Date(1970-1900, 3, 28)));
		sl.add(new Student("Vasya5", "5Pupkin", new Date(1988-1900, 4, 28)));
		
		
		int n = sl.find("Seva");
		if(n >= 0){
			System.out.println("find Seva "+sl.get(n).getBirth());
		}
		
		n = sl.find(new Date(1990-1900, 2, 28));
		if(n >= 0){
			System.out.println("find Date "+sl.get(n).getBirth());
		}
		
		
		//sl.del(0);
		//sl.del(1);
		sl.del(5);
		sl.showAll();
	}
}
