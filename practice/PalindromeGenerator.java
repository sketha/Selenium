package practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeGenerator {
    public static void palindromeGen(int N, int K){
        String s="abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer(K);
        for(int i=K;i!=0;i--){
            sb.append(s.charAt(i));
        }
        String intialStr= sb.toString();
        String mid =IntStream.range(0, N-(K*2)).mapToObj(index -> "" + 'z').collect(Collectors.joining());

        System.out.println(intialStr+mid+new StringBuffer(intialStr).reverse().toString());
    }
    public static void main(String[] args) {
        palindromeGen(5,2);
    }
}
