package extra.graphy;

import java.util.*;

public class WordLadder_127 {

    public static void main(String[] args) {

    }

    static class Solution {
        private List<String> visited = new ArrayList<>();
        private int res = Integer.MAX_VALUE;

        /**
         * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列
         * beginWord -> s1-> s2-> ... -> sk：
         *
         * 每一对相邻的单词只差一个字母。
         * 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在 wordList中。
         * sk == endWord
         * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
         * 如果不存在这样的转换序列，返回 0 。
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @return
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

//            if(!wordList.contains(endWord)) return 0;
//
//            dfs(beginWord, endWord, wordList, 1);
//
//            return res;

            /**
             * 广度优先遍历：无向图求最短路，广搜最为合适，广搜只要搜到了终点，那么一定是最短的路径
             */
            if(!wordList.contains(endWord)) return 0;

            Queue<String> que = new LinkedList<>();
            que.offer(beginWord);

            HashMap<String, Integer> map = new HashMap<>();
            map.put(beginWord, 1);

            while(!que.isEmpty()) {
                String curWord = que.peek();
                int path = map.get(curWord);
                que.poll();
                for(String word : wordList) {
                    if(!map.containsKey(word) && isValid(word, curWord)) {
                        if(word.equals(endWord)) return path + 1;

                        que.offer(word);
                        map.put(word,map.get(curWord) + 1);
                    }
                }
            }

//            HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
//            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
//                return 0;
//            }
//            Queue<String> queue = new LinkedList<>(); //bfs 队列
//            queue.offer(beginWord);
//            Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
//            map.put(beginWord, 1);
//
//            while (!queue.isEmpty()) {
//                String word = queue.poll(); //取出队头单词
//                int path  = map.get(word); //获取到该单词的路径长度
//                for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
//                    char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
//                    for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
//                        chars[i] = k; //替换第i个字符
//                        String newWord = String.valueOf(chars); //得到新的字符串
//                        if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
//                            return path + 1;
//                        }
//                        if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
//                            map.put(newWord, path + 1); //记录单词对应的路径长度
//                            queue.offer(newWord);//加入队尾
//                        }
//                    }
//                }
//            }

            return 0;

        }

        public void dfs(String beginWord, String endWord, List<String> wordList, int cnt) {
            System.out.println(beginWord + "," + endWord + "," + cnt);
            if(endWord.equals(beginWord)) {
                res = Math.min(cnt, res);
                return;
            }

            for(String word : wordList) {
                if(!visited.contains(word) && isValid(word, beginWord)) {
                    visited.add(word);
                    dfs(word, endWord, wordList, cnt + 1);
                }
            }
        }

        public boolean isValid(String word1, String word2) {
            int cnt = 0;

            for(int i = 0; i < word1.length(); i++) {
                if(word1.charAt(i) != word2.charAt(i)) cnt++;
                if(cnt > 1) return false;
            }

            return cnt == 1;
        }
    }
}
