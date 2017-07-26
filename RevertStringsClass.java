public class RevertStringsClass {
    public static void main(String args[]) {
        //System.out.println(reverseRecursively("Teste string reversa"));
        //System.out.println(reverseRecursively(args[0]));
        //System.out.println(reversePhrase2(args[0]));
        System.out.println(revertPhraseWithoutSpace(args[0]));
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

    public static String reversePhrase2(String str)
    {
        int nextWordPosition = 0;
        int spacePosition = 0;
        
        for (int i = 0; i < str.length(); i++)
        {
           if (spacePosition == 0)
           {
              if (str.charAt(i) == ' ')
              {
                 spacePosition = i;
              }
           }
           else
           {
              if (str.charAt(i) != ' ') 
              {
                 nextWordPosition = i;
                 break;
              }
           }
        }
        
        if (spacePosition == 0)
           return str + " ";  
        else if (nextWordPosition == 0)
           return str.substring(0,spacePosition) + " ";
        else
           return reversePhrase2(str.substring(nextWordPosition)) + str.substring(0, spacePosition)+ " ";
    }    
    
    public static String revertPhraseWithoutSpace(String source)
    {
        String revertedPhrase = reversePhrase2(source);
        return revertedPhrase.substring(0, revertedPhrase.length() - 1) + ".";
    }
}