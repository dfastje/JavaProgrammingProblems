package me.dfastje.programmingproblems.palindrome;

import org.springframework.stereotype.Service;

@Service
public class Palindrome {

        public boolean isPalindrome(String inputString){
            if(inputString.length() < 2){
                return true;
            }
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length()-1);
            if(firstChar != lastChar){
                return false;
            }
            String subString = inputString.substring(1,inputString.length()-1);
            return isPalindrome(subString);
        }
}
