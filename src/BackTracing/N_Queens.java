package BackTracing;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        solveNQueens(8);
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] a = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = '.';
            }
        }

        dfs(res, n, 0, a);

        return res;
    }

    public static void dfs(List<List<String>> res, int n, int deep, char[][] a){

        if(deep == n){
            res.add(toList(a,n));
            return;
        }

        for(int i = 0; i < n; i++){
            if(isValid(deep,i, a, n)){
                a[deep][i]='Q';
                dfs(res, n,deep+1, a);
                a[deep][i]='.';
            }
        }

    }

    public static boolean isValid(int deep,int k, char[][] a, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(a[i][j]=='Q'){
                    if(Math.abs(deep-i) == Math.abs(k-j) || deep==i || k==j)
                        return false;
                }
            }
        }

        return true;
    }

    public static List<String> toList(char[][] a, int n){
        List<String> result = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String tmp="";
            for(int j = 0; j<n; j++){
                tmp += a[i][j];
            }
            result.add(tmp);
        }

        return result;
    }


}
