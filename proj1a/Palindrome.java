public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque d = new LinkedListDeque<>();
        int length = word.length();
        for ( ;length > 0; length--) {
            d.addFirst(word.charAt(length - 1));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        //This implementation convert string to a character, compare the first char and last,
        // go closer until meet. But it uses get function which is not recommended.
//        Deque d = wordToDeque(word);
//        for (int front = 0, behind = d.size() - 1; front < behind; front++, behind--) {
//            if (d.get(front) != d.get(behind)) {
//                return false;
//            }
//        }
//        return true;
        // This implementation uses recursive function to reverse the string and compare each other.
        return word.equals(reversedString(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() > 1) {
            Deque d = wordToDeque(word);
            for (int front = 0, behind = d.size() - 1; front < behind; front++, behind--) {
                if (!cc.equalChars((char) d.get(front), (char) d.get(behind))) {
                    return false;
                }
            }
        }
        return true;
    }

    private String reversedString(String word) {
        if (word.length() <= 1) {
            return word;
        }
        return reversedString(word.substring(1)) + word.charAt(0);
    }

}
