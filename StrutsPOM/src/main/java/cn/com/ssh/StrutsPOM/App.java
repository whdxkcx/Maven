package cn.com.ssh.StrutsPOM;

/**
 * Hello world!
 *
 */
public class App 
{
	
//  System.out.println( "Hello World!" );
	//思路：
//	dp[i][j]指把word1[0..i - 1]转换为word2[0..j - 1] 的最小操作数。
//
//	边界条件：
//
//	dp[i][0] = i; 从长度为 i 的字符串转为空串 要删除 i 次
//	dp[0][j] = j. 从空串转为长度为 j 的字符串 要添加 j 次
//
//	一般情况：
//
//	如果word[i - 1] == word2[j - 1]，则dp[i][j] = dp[i - 1][j - 1]，因为不需要进行操作，即操作数为0.
//
//	如果word[i - 1] != word2[j - 1]，则需考虑三种情况，取最小值：
//
//	Replace word1[i - 1] by word2[j - 1]： (dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));
//	Delete word1[i - 1]：                             (dp[i][j] = dp[i - 1][j] + 1 (for deletion));
//	Insert word2[j - 1] to word1[0..i - 1]：   (dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
    public static void main( String[] args )
    {
         String  word1="fail";
         String  word2="sai";
         System.out.println(minDistance(word1, word2));
    }
    
    public static  int minDistance(String word1,String word2) {
    	int i=word1.length();
    	int j=word2.length();
    	if(i==0) return j;
    	if(j==0) return i;
    	System.out.println("i:"+i+"  j:"+j);
    	int d1=minDistance(word1.substring(0, i-1), word2.substring(0, j-1));
    	
    	if(word1.toCharArray()[i-1]==word2.toCharArray()[j-1])
    	{
    		return d1;
    	}
    	int d2=minDistance(word1.substring(0, i-1), word2);
    	int d3=minDistance(word1, word2.substring(0, j-1));
    	return Math.min(Math.min(d1+1, d2+1), d3+1);
    }
    
    //计算"sai"和"fail"的过程。
   //第一步:i=4,j=3. 两个字符串最后一个字符不相等，计算d1为"sa"和"fai"的距离。d2为"sa"和"fail"的距离。d3为"sai"和"fai"的距离。
    //第二步：递归计算d3时，两个字符串，最后一个字符相等，所以d3为"sa"和"fa"的距离，
    //第三步：递归计算两个字符串，最后一个字符再次相等，等于”s“和”f“的距离。所以d3=1;
    //第四步：d3+1=2.故其编辑距离为2.
}
