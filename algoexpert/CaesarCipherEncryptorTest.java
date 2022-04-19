package algoexpert;

public class CaesarCipherEncryptorTest {
    public static String caesarCypherEncryptor(String str, int key) {
        String result = "";
        if(key%26==0)
            return str;
        else {
            int sum = 0;
            for (char s : str.toCharArray()) {
                if(key/26>0)
                    result=result+(char)(key%26+(int)s);
                if(key<26) {
                    sum = (int) s + key;
                    if (sum <= 122)
                        result = result + (char) sum;
                    else
                        result = result + (char) ((sum - 122) + 96);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc",57));
    }
}
