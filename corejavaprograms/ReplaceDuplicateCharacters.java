package corejavaprograms;

import java.util.HashMap;

public class ReplaceDuplicateCharacters {

	public static void main(String[] args) {
		String str="Assassination";
		str=str.toUpperCase();
		char[] ch=str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<>();
		for (char c : ch) {
			if(map.containsKey(c)){
				map.put(c,(map.get(c))+1);}
			else{
				map.put(c,1);
			}
		}
		for (char comp : ch) {
				if(map.get(comp)>1){
					str=str.replace(comp,'X');
				}

			}
			System.out.println(str);
			


	}

}
