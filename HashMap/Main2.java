 

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		
		int [] values = new int[]{1,1,1,1,2,3,3,4,5,6,4,3,3,3,4,5,6,7,8,8,5,4,3,2,3,2,3,4,5};

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for (Integer val : values) {
			int counter = 1;
			if (hm.containsKey(val))
				counter += hm.get(val);
			
			hm.put(val, counter);
		}

		Iterator<Map.Entry<Integer, Integer>> itr = hm.entrySet().iterator(); 
		while (itr.hasNext()) 
		    System.out.println(itr.next()); 
		 
	}
}
