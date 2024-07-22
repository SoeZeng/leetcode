package daily_task;

import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 */
public class AccountConsolidation_721 {

}

/**
 * 把每个账户用其在 accounts 中的下标表示，即节点 0 到 3。
 * 同时，把每个账户的邮箱地址，也视作节点。我们在账户下标与其邮箱地址之间连边，得到一个无向图（二分图）。
 * 题目相当于求出这个图的每个连通块，这可以用 DFS 解决。
 */
class Solution721{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(j), x -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < accounts.size(); i++) {
            if(visited[i]) continue;

            emails.clear();
            dfs(i, accounts, emailToIdx, visited, emails);

            List<String> tempList = new ArrayList<>(emails);
            Collections.sort(tempList);
            tempList.add(0, accounts.get(i).get(0));

            ans.add(tempList);
        }

        return ans;
    }

    private void dfs(int k, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] visited, Set<String> emails) {
        visited[k] = true;
        List<String> account = accounts.get(k);

        for (int i = 1; i < account.size(); i++) {
            String email = account.get(i);
            if(emails.contains(email)) continue;
            emails.add(email);

            for (int j : emailToIdx.get(email)) {
                if(!visited[j]) {
                    dfs(j, accounts, emailToIdx, visited, emails);
                }
            }
        }
    }
}
