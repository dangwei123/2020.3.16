给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int len=s.length();
        if(len==1) return 1;
        int[] dp=new int[len];
        dp[0]=1;
        if(s.substring(0,2).compareTo("26")>=0){
            dp[1]=1;
        }else{
            dp[1]=2;
        }
        for(int i=2;i<s.length();i++){
            if(s.charAt(i-1)=='0'||s.substring(i-1,i+1).compareTo("26")>=0){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-2]+dp[i-1];
            }
        }
        return dp[len-1];
    }

}

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> deque;
    public MaxQueue() {
        queue=new LinkedList<>();
        deque=new LinkedList<>();
    }
    
    public int max_value() {
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty()&&deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int re=queue.poll();
        if(re==deque.peekFirst()){
            deque.pollFirst();
        }
        return re;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
 
 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    boolean[][] isVisited;
    public int movingCount(int m, int n, int k) {
        isVisited=new boolean[m][n];
        return dfs(m,n,0,0,k,isVisited);
    }
    private int dfs(int m,int n,int i,int j,int k,boolean[][] isVisited){
        if(i<0||j<0||i>=m||j>=n||(i/10+i%10+j/10+j%10)>k||isVisited[i][j]){
            return 0;
        }
        isVisited[i][j]=true;
        return 1+dfs(m,n,i+1,j,k,isVisited)+dfs(m,n,i-1,j,k,isVisited)
               +dfs(m,n,i,j+1,k,isVisited)+dfs(m,n,i,j-1,k,isVisited);
    }
}

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;
        return isSameTree(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    private boolean isSameTree(TreeNode A,TreeNode B){
        if(B==null) return true;
        if(A==null) return false;
        return A.val==B.val&&isSameTree(A.left,B.left)&&isSameTree(A.right,B.right);
    }
}

