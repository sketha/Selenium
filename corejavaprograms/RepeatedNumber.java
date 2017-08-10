package corejavaprograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RepeatedNumber {

	public static void main(String[] args) {
		int num[]={1,2,4,5,6,3,4,2,4,7,3,8,9,1,2,3,3};
		Map<Integer,Integer> demo = new HashMap<>();
		for (int i : num) {
			if(demo.containsKey(i)){
				demo.put(i, (demo.get(i)+1));
			}else{
				demo.put(i, 1);
			}
		}
	Set<Integer> set=demo.keySet();
	int count=0,keyCount= 0;
	for (Integer setVal : set) {
		if(demo.get(setVal)>1){
			if(count<demo.get(setVal)){
				count=demo.get(setVal);
				keyCount=setVal;
			}	
			
		}
	}
	System.out.println("The highesh values which repeating is :"+ keyCount);
	}

}
