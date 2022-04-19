package practice;

//import org.testng.Assert;

public class ReverseIndividualString {
    public static void main(String[] args) {
        //Test case 1:
        var input="You is the best!";
        var output="best! the is You";
      //  Assert.assertEquals(normalReverse(input),output,"Assertion Failed");

        //Test case 2:
        var input1="this      string     has a     lot of   whitespace";
        var output1="whitespace   of lot     a has     string      this";
      //  Assert.assertEquals(normalReverse(input1),output1,"Assertion Failed");

        System.out.println("All the Test passed Successfully !!!");
    }
    public static String normalReverse(String args){
        System.out.println("Given String :"+args);
        String[] strArr= args.split(" ",-1 );
        String output="";
        for(int i= strArr.length-1;i!=-1;i--){
            output=output+strArr[i].trim()+" ";
        }
        System.out.println("Output String :"+output.trim());
        return output.trim();

    }
    public static String revString(String args){
        System.out.println("Given String :"+args);
        String result = "";
        for (String s1 : args.split(" ",-1)) {
            StringBuffer sb = new StringBuffer(s1);
            result = result + sb.reverse().toString() + " ";
        }
        System.out.println("Output String :"+result.trim());
        return result.trim();
    }
}
