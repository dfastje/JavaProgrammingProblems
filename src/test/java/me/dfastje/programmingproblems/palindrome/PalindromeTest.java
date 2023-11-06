package me.dfastje.programmingproblems.palindrome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PalindromeTest {

    @Autowired
    private Palindrome palindrome;

    @Test
    void isPalindrome_EmptyString() {
        String emptyString = "";
        boolean isPalindrome = palindrome.isPalindrome(emptyString);
        assertTrue(isPalindrome, "Empty string should be a palindrome");
    }

    @Test
    void isPalindrome_SingleCharacterString() {
        String singleCharacterString = "a";
        boolean isPalindrome = palindrome.isPalindrome(singleCharacterString);
        assertTrue(isPalindrome, "Single character string should be a palindrome");
    }

    @Test
    void isPalindrome_TwoCharacterString() {
        String twoCharacterString = "aa";
        boolean isPalindrome = palindrome.isPalindrome(twoCharacterString);
        assertTrue(isPalindrome, "Two character string with matching characters should be a palindrome");
    }

    @Test
    void isPalindrome_TwoCharacterStringWithDifferentCharacters() {
        String twoCharacterString = "ab";
        boolean isPalindrome = palindrome.isPalindrome(twoCharacterString);
        assertFalse(isPalindrome, "Two character string with different characters should not be a palindrome");
    }

    @Test
    void isPalindrome_ThreeCharacterStringWithMatchingCharacters() {
        String threeCharacterString = "aaa";
        boolean isPalindrome = palindrome.isPalindrome(threeCharacterString);
        assertTrue(isPalindrome, "Three character string with matching characters should be a palindrome");
    }

    @Test
    void isPalindrome_ThreeCharacterStringWithDifferentCharacters() {
        String threeCharacterString = "abc";
        boolean isPalindrome = palindrome.isPalindrome(threeCharacterString);
        assertFalse(isPalindrome, "Three character string with different characters should not be a palindrome");
    }
}