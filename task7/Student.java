
package task7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {
	private String name;
	private String surname;
	private Date birth;
	
	public Student(String name, String surname, Date birth) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getBirth(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.format(birth);
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
