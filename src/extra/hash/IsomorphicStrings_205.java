package extra.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        Solution205 sol = new Solution205();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            String t = in.nextLine();
            boolean ans = sol.isIsomorphic(s, t);
            System.out.println(ans);
        }

    }
}

class Solution205 {

    /**
     * 给定两个字符串s和t，判断它们是否是同构的。
     *
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
     * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i = 0; i < sChars.length; i++) {
            if(map.containsKey(sChars[i])) {
                if(map.get(sChars[i]) != tChars[i]) {
                    return false;
                }
            }else if(map.containsValue(tChars[i])) {
                return false;
            }else {
                map.put(sChars[i],tChars[i]);
            }
        }
        return true;


//            Map<Character, Character> map1 = new HashMap<>();
//            Map<Character, Character> map2 = new HashMap<>();
//            for (int i = 0, j = 0; i < s.length(); i++, j++) {
//                if (!map1.containsKey(s.charAt(i))) {
//                    map1.put(s.charAt(i), t.charAt(j)); // map1保存 s[i] 到 t[j]的映射
//                }
//                if (!map2.containsKey(t.charAt(j))) {
//                    map2.put(t.charAt(j), s.charAt(i)); // map2保存 t[j] 到 s[i]的映射
//                }
//                // 无法映射，返回 false
//                if (map1.get(s.charAt(i)) != t.charAt(j) || map2.get(t.charAt(j)) != s.charAt(i)) {
//                    return false;
//                }
//            }
//            return true;
    }
}
