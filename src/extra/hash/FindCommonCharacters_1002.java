package extra.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindCommonCharacters_1002 {

    public static void main(String[] args) {
        Solution1002 sol = new Solution1002();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            List<String> res = sol.commonChars(words);
            System.out.println(res);
        }
    }
}

class Solution1002 {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[] chars = new int[26];
        String word = words[0];

        for(int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a'] += 1;
        }

        for(int i = 1; i < words.length; i++) {
            word = words[i];
            int[] temp = new int[26];
            for(int j = 0; j < word.length(); j++) {
                temp[word.charAt(j) - 'a'] += 1;
            }
            for(int k = 0; k < 26; k++) {
                if(chars[k] != temp[k]) {
                    chars[k] = Math.min(chars[k], temp[k]);
                }
            }
        }

        for(int i = 0; i < 26; i++) {
            while(chars[i] > 0) {
                res.add(String.valueOf((char)(i + 'a')));
                chars[i]--;
            }
        }

        return res;

    }
}
