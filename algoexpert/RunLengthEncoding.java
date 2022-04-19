package algoexpert;

public class RunLengthEncoding {
    public static String runLengthEncoding(String string) {
        char compareElement=string.charAt(0);
        int count=0;
        String result="";
        for (int i = 0; i <string.length(); i++) {
            if(string.charAt(i)==compareElement) {
                count++;
                if(count==9){
                    result=result+9+compareElement;
                    count=0;
                }
            }
            else{
                result=(count>0)?result+count+compareElement:result;
                compareElement=string.charAt(i);
                count=1;
            }
        }

        return result+count+compareElement;
    }
    public static void main(String[] args) {
        System.out.println(runLengthEncoding("........______=========AAAA   AAABBBB   BBB"));
    }
}
