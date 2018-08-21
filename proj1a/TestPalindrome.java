import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne obo = new OffByOne();
    static OffByN obo5 = new OffByN(5);


    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("Aba"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("abcdedcba"));

    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertTrue(palindrome.isPalindrome("ab", obo));
        assertFalse(palindrome.isPalindrome("Aba", obo));
        assertTrue(palindrome.isPalindrome("bba", obo));
        assertTrue(palindrome.isPalindrome("bcbeedcba", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));

        assertTrue(palindrome.isPalindrome("", obo5));
        assertTrue(palindrome.isPalindrome("a", obo5));
        assertFalse(palindrome.isPalindrome("ab", obo5));
        assertTrue(palindrome.isPalindrome("af", obo5));
        assertTrue(palindrome.isPalindrome("abf", obo5));
        assertFalse(palindrome.isPalindrome("bba", obo5));
        assertTrue(palindrome.isPalindrome("flaqa", obo5));
    }
}
