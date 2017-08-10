package corejavaprograms;

import java.util.*;
public class UniqueNumbers {
	public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int Num : numbers) {
			if(map.containsKey(Num)){
				map.put(Num,(map.get(Num)+1));
			}
			else{
				map.put(Num,1);
			}
		}
		Set<Integer> set = map.keySet();

		for (Integer integer : set) {
			if(map.get(integer)==1){
				list.add(integer);
			}
		}			
		return list;
	}

	public static void main(String[] args) {
		Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3,5,6,7,8,1);
		for (int number : findUniqueNumbers(numbers))
			System.out.println(number);
	}
}