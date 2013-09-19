package StringSplitter;

import java.util.ArrayList;
import java.util.List;
/** 
 * This implementation requires haystack and needle not to be null
 */
 
public class StringSplitterSol {

    /**
     * needle empty or haystack empty is not allowed
     * 
     * needle at beginning or at end is allowed
     * 
     * Consecutive needles are allowed
     * 
     * needle must appear in haystack at least once
     * 
     * 
     * @param haystack
     *            non empty, non null, with at least one occurrence of needle.
     * @param needle
     *            non empty, non null
     * @return string array for values split around needle string.
     *         The resulting array is such that s[0] + needle + s[1] + ... +
     *         needle + s[k] = haystack 
     *         string s[i] for i from 0 to k can be empty
     *         string s[i] for i from 0 to k can not contain needle
     * 
     */
    public static String[] splitString1(String haystack, String needle) {
        if (haystack.equals("") || needle.equals("") // non empty strings are
                                                        // not accepted
                || haystack.indexOf(needle) == -1) { // haystack must have at
                                                        // least one needle
            throw new IllegalArgumentException();
        }

        // Do actual splitting using String.indexOf() method and do-while loop 
        String newHaystack = haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();

        do {
            resultList.add(newHaystack.substring(0, index));
            newHaystack = newHaystack.substring(index + needle.length());
            index = newHaystack.indexOf(needle);

        } while (index != -1);

        resultList.add(newHaystack); // add remaining haystack 

        // need to return an array not Array List
        String[] res = new String[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }
        return res;

    }

    /**
     * This implementation requires haystack and needle not to be null
     * 
     * needle empty or haystack empty is not allowed
     * 
     * needle cannot be at beginning or at end
     * 
     * Consecutive needles not allowed
     * 
     * needle must appear in haystack at least once
     * 
     * 
     * @param haystack
     *            non empty, non null, with at least one occurrence of needle.
     *            Doesn't start or end with needle. and does not contain
     *            consecutive needles.
     * @param needle
     *            non empty, non null
     * @return string array for values split around needle string.
     * 
     *         The resulting array is such that s[0] + needle + s[1] + ... +
     *         needle + s[k] = haystack 
     *         string s[i] for i from 0 to k can not contain needle 
     * 
     */
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
        // Do actual splitting using string builder method
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
                                    

        // need to return an array not Array List
        String[] res = new String[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }
        return res;

    }
    
    /**
     * 
     *  needle at beginning or at end is allowed
     *  needle empty or haystack empty is allowed
     *  Consecutive needles allowed
     *       
     *  
     * @param haystack
     * @param needle
     * @return string array for values split around needle string.
     *         The resulting array is such that s[0] + needle + s[1] + ... +
     *         needle + s[k] = haystack 
     *         string s[i] for i from 0 to k can be empty
     *         string s[i] for i from 0 to k cannot contain needle
     * 
     */
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
        // Do actual splitting using String.indexOf() method
        String newHaystack= haystack;
        int index = newHaystack.indexOf(needle);
        List<String> resultList = new ArrayList<String>();
        
        while (index != -1){ 
            resultList.add(newHaystack.substring(0, index));            
            newHaystack = newHaystack.substring(index + needle.length());   
            index = newHaystack.indexOf(needle); 
            if(index == -1) resultList.add(newHaystack); // add remaining string before exit loop
        }
        
        // need to return an array not Array List
        String[] res = new String[resultList.size()];
        for(int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }        
        return res;        
            
    }
    
    /**
     * 
     * needle at beginning or at end is allowed
     * needle empty or haystack empty is allowed
     * Consecutive needles allowed     * 
     * 
     * @param haystack
     * @param needle
     * @return string array for values split around needle string.
     *         The resulting array is such that s[0] + needle + s[1] + ... +
     *         needle + s[k] = haystack 
     *         string s[i] for i from 0 to k CANNOT be empty
     *         string s[i] for i from 0 to k can not contain needle
     * 
     */
    public static String[] splitString4(String haystack, String needle) {
        
        // return array of one empty string element if haystack is empty
        if (haystack.equals("")){
            return new String[] {""};
        }
        // for empty needle, just return array of single element = the whole haystack string - still valid
        if (needle.equals("")){
            return new String[] { haystack };
        }
        
        // Do actual splitting using String.indexOf() method
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
        
        // need to return an array not Array List
        String[] res = new String[resultList.size()];
        for(int j = 0; j < resultList.size(); j++) {
            res[j] = resultList.get(j);
        }        
        return res;        
        
    }
    
    
}
