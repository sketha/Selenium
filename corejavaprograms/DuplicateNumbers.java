package corejavaprograms;

import java.util.HashMap;
import java.util.Set;

public class DuplicateNumbers {

	public static void main(String[] args) {
		int[]a={1,2,1,5,9,5,8,3,5,1,6,1,8,9};
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int Num : a) {
			if(map.containsKey(Num)){
				map.put(Num,(map.get(Num)+1));
			}
			else{
				map.put(Num,1);
			}
		}
		//System.out.println(map.toString());
		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			System.out.println("The Number "+integer+" occurs "+map.get(integer));
		}
		System.out.println(map.toString());
	}

}
