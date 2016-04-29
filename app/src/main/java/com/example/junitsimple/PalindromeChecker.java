package com.example.junitsimple;

/**
 * Created by evin on 4/28/16.
 */
public class PalindromeChecker {
    public boolean isPalindrome(char[] sentence) {
        int end = sentence.length - 1;

        for (int i = 0; i < sentence.length / 2; i++) {
            if (sentence[i] != sentence[end--])
                return false;
        }

        return true;
    }
}
