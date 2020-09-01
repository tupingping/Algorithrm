package DynamicProgram;

public class WaysToChange {
    public static void main(String[] args) {

        System.out.println(waysToChange(5));
    }

    // 一维动态规划
    public static int waysToChange(int n){
        int dp[] = new int[n+1];
        int[] tokens = {1,5,10,25};
        int mod = 1000000007;

        for(int i=0; i<4; i++){
            for(int j=1; j<=n; j++){
                if(tokens[i]==j){
                    dp[j]=(dp[j]+1)%mod;
                }else if(tokens[i] < j){
                    dp[j] = (dp[j]+dp[j-tokens[i]])%mod;
                }
            }
        }
        return dp[n];

    }
}
