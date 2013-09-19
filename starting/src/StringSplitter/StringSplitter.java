package StringSplitter;

import java.util.ArrayList;
import java.util.List;
/** 
 * This implementation requires haystack and needle not to be null
 */
 
public class StringSplitter {

    public static String[] splitString1(String haystack, String needle) {
        if (haystack.equals("") || needle.equals("") // non empty strings are
                                                        // not accepted
                || haystack.indexOf(needle) == -1) { // haystack must have at
                                                        // least one needle
            throw new IllegalArgumentException();
        }

        // Split using indexOf method.
        String newHaystack = haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();

        do {
            resultList.add(newHaystack.substring(0, index));
            newHaystack = newHaystack.substring(index + needle.length());
            index = newHaystack.indexOf(needle);

        } while (index != -1);

        resultList.add(newHaystack); // add remaining haystack 

        // Return an array not ArrayList.
        String[] res = new String[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }
        return res;

    }

    public static String[] splitString2(String haystack, String needle) {
        if (haystack.equals("") || needle.equals("") // non empty strings are
                                                        // not accepted
                || haystack.indexOf(needle) == -1 // haystack must have at least
                                                    // one needle
                || haystack.startsWith(needle) // needle must not be at the
                                                // beginning of haystack
                || haystack.endsWith(needle)// needle must not be at the end of
                                            // haystack
                || haystack.contains(needle + needle) // needle must not repeat
        ) {
            throw new IllegalArgumentException();
        }
        // Split using StringBuilder.
        String newHaystack = haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();

        do {
            StringBuilder before = new StringBuilder();
            for (int i = 0; i < index; i++) {
                before.append(newHaystack.charAt(i));
                if (i == index - 1)
                    resultList.add(before.toString());
            }
            StringBuilder after = new StringBuilder();
            for (int i = index + needle.length(); i < newHaystack.length(); i++) {
                after.append(newHaystack.charAt(i));
                if (i == newHaystack.length() - 1)
                    newHaystack = after.toString();
            }
            index = newHaystack.indexOf(needle);
        } while (index != -1);

        resultList.add(newHaystack); // add remaining haystack  
                                    

        // Return an array not ArrayList.
        String[] res = new String[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }
        return res;

    }
    
    public static String[] splitString3(String haystack, String needle) {
        // return array of one empty string element if haystack is empty
        if (haystack.equals("")){
            return new String[] {};
        }
        // for empty needle, just return array of characters (cast to String)
        if (needle.equals("")){
            char[] charArray = haystack.toCharArray();
            String[] result = new String[charArray.length];
            
            for(int i = 0; i < charArray.length; i++){
                result[i] = Character.toString(charArray[i]);
            };
            return result;
        }
        // Split using String.indexOf() method
        String newHaystack= haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();
        
        while (index != -1){ 
            resultList.add(newHaystack.substring(0, index));            
            newHaystack = newHaystack.substring(index + needle.length());   
            index = newHaystack.indexOf(needle); 
            if(index == -1) resultList.add(newHaystack); // add remaining string before exit loop
        }
        
        // Return an array not ArrayList.
        String[] res = new String[resultList.size()];
        for(int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }        
        return res;        
            
    }
    
    public static String[] splitString4(String haystack, String needle) {
        
        // return array of one empty string element if haystack is empty
        if (haystack.equals("")){
            return new String[] {""};
        }
        // for empty needle, just return array of single element = the whole haystack string - still valid
        if (needle.equals("")){
            return new String[] { haystack };
        }
        
        // Split using String.indexOf() method.
        String newHaystack= haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();
        
        while (index != -1){ 
            if(index > 0) {
                resultList.add(newHaystack.substring(0, index));     
            }
            newHaystack = newHaystack.substring(index + needle.length());   
            index = newHaystack.indexOf(needle); 
            if(index == -1 && !newHaystack.equals("")) {
                resultList.add(newHaystack); // add remaining string before exit loop
            }
        }
        
        // Return an array not ArrayList.
        String[] res = new String[resultList.size()];
        for(int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }        
        return res;        
        
    }
    
    
}
