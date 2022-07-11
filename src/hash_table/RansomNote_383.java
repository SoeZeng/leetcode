package hash_table;

public class RansomNote_383 {

    public static void main(String[] args) {

    }

    static class Solution {

        /**
         * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
         *
         * 如果可以，返回 true ；否则返回 false 。
         *
         * magazine 中的每个字符只能在 ransomNote 中使用一次。
         *
         * @param ransomNote
         * @param magazine
         * @return
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            // if(ransomNote.length() > magazine.length()) return false;

            int[] letter = new int[26];
            for(char c : ransomNote.toCharArray()) {
                letter[c - 'a']--;
            }

            for(char c : magazine.toCharArray()) {
                letter[c - 'a']++;
            }

            for(int num : letter) {
                if(num < 0) return false;
            }

            return true;
        }
    }
}
