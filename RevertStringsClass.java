public class RevertStringsClass {
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;

        //System.out.println("Sum of x+y = " + z);
        //System.out.println(reverseRecursively("Teste string reversa"));
        //System.out.println(reverseRecursively(args[0]));
        System.out.println(reversePhrase(args[0]));
        System.out.println();
    }
    
    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        //System.out.println(str.substring(1) + str.charAt(0));
        return reverseRecursively(str.substring(1)) + str.charAt(0);
        //return str.substring(1) + str.charAt(0);
    }
    
    public static String reversePhrase(String str)
    {
        int spacePosition = 0;
        char[] strChars = str.toCharArray();
        
        for (int i = 0; i <= strChars.length - 1; i++)
        {
           if (strChars[i] == ' ')
           {
               spacePosition = i;
               break;
           }
            
        }
        
        if (spacePosition == 0)
           return str + " ";  
        else  
           return reversePhrase(str.substring(spacePosition + 1)) + str.substring(0, spacePosition)+ " ";
          // return str.substring(spacePosition);
    }

}
