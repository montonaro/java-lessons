package human;

import java.io.Serializable;

public class Human implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;  
	
	private String name;
	private int growth;
	private int weight;
	
	Human(String name, int growth, int weight){
		this.name  	= name;
		this.growth = growth;
		this.weight	= weight;
	}
	
	public String getName(){
		return name;
	}
	
	public int getGrowth(){
		return growth;
	}
	
	public double getWeight(){
		return weight;
	}  
	
	@Override 
	public int hashCode(){
		return growth^weight^name.toLowerCase().hashCode();
	}
	
	@Override
    public boolean equals(Object obj) { 
		
		if (obj == null) 
              return false;
		
		if(this == obj)
	       	  return true;  
		
        if (this.getClass() != obj.getClass()) 
              return false;

        if (super.equals(obj))
              return true; 
        
        Human human = (Human) obj;
        if (weight != human.weight)
            return false;
        
        if (growth != human.growth)
            return false;
        
        if (name.toLowerCase().hashCode() != human.name.toLowerCase().hashCode())
            return false;
        
        return true;
    } 
	
	@Override
    public Object clone() throws CloneNotSupportedException {
		Human o = (Human) super.clone(); 
        return o;    
    }

	@Override
    public String toString() { 
		return "Рост:" +growth+" , Вес:"+weight+", Имя:"+name;
    }
}
