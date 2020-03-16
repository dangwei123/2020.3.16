给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
class Solution {
    List<String> res;
    public List<String> letterCasePermutation(String S) {
        res=new LinkedList<>();
        char[] c=S.toCharArray();
        backTrack(c,0);
        return res;
    }
    private void backTrack(char[] c,int index){
        if(index==c.length){
            res.add(new String(c));
            return;
        }
        backTrack(c,index+1);
        if(c[index]<'0'||c[index]>'9'){
            c[index]^=32;
            backTrack(c,index+1);
        }
    }
}


二进制手表
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res=new LinkedList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(oneNum(i)+oneNum(j)==num){
                    res.add(i+":"+(j<10?"0"+j:j));
                }
            }
        }
        return res;
    }
    private int oneNum(int n){
        int count=0;
        while(n!=0){
            count++;
            n&=(n-1);
        }
        return count;
    }
}

给定一个可包含重复数字的序列，返回所有不重复的全排列。
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new LinkedList<>();
        boolean[] flag=new boolean[nums.length];
        Arrays.fill(flag,false);
        Arrays.sort(nums);
        dfs(nums,0,new LinkedList<>(),flag);
        return res;
    }
    private void dfs(int[] nums,int index,List<Integer> row,boolean[] flag){
        if(index==nums.length){
            res.add(new LinkedList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flag[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!flag[i-1]){
                continue;
            }
            row.add(nums[i]);
            flag[i]=true;
            dfs(nums,index+1,row,flag);
            flag[i]=false;
            row.remove(row.size()-1);
        }
    }
}

输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
class Solution {
    List<String> res=new LinkedList<>();
    public String[] permutation(String s) {
        int len=s.length();
        boolean[] isUsed=new boolean[len];
        Arrays.fill(isUsed,false);
        char[] c=s.toCharArray();
        Arrays.sort(c);
        dfs("",c,len,0,isUsed);
        String[] str=new String[res.size()];
        int i=0;
        while(!res.isEmpty()){
            str[i++]=res.remove(0);
        }
        return str;
    }
    private void dfs(String tmp,char[] c,int len,int index,boolean[] isUsed){
        if(index==len){
            res.add(new String(tmp));
            return;
        }
        for(int i=0;i<len;i++){
            if(isUsed[i]){
                continue;
            }
            if(i>0&&c[i]==c[i-1]&&!isUsed[i-1]){
                continue;
            }
            tmp+=c[i];
            isUsed[i]=true;
            dfs(tmp,c,len,index+1,isUsed);
            isUsed[i]=false;
            tmp=tmp.substring(0,tmp.length()-1);
        }
    }
}

