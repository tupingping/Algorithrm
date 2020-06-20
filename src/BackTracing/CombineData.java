package BackTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineData {

    public static void main(String[] args) {
        int[] cadinates = new int[]{10,1,2,7,6,1,5};
        CombineData t = new CombineData();
        Arrays.sort(cadinates);
        List<List<Integer>> a = t.combinationSum2(cadinates,8);
        System.out.println(a);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        int index = 0;
        List<Integer> s = new ArrayList<>();
        dfs(candidates, index, sum, res, s, target);

        return res;
    }

    public void dfs(int[] candidates, int index, int sum, List<List<Integer>> res, List<Integer> s,int target){
        if(sum == target){
            res.add(new ArrayList(s));
            return;
        }

        if(sum>target)
            return;

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            s.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, i+1, sum, res, s, target);
            s.remove(s.size()-1);
            sum -= candidates[i];
        }
    }
}
