字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compress-string-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String compressString(String S) {
        int len=S.length();
        StringBuilder sb=new StringBuilder();
        int i=0;
        int tmp=0;
        for(int j=0;j<S.length();j++){
            sb.append(S.charAt(i));
            tmp=0;
            while(j!=S.length()&&S.charAt(j)==S.charAt(i)){
                tmp++;
                j++;
            }
            i=j;
            sb.append(String.valueOf(tmp));
            if(j!=S.length()) j--;
        }
        return sb.length()>=len?S:sb.toString();
    }
}

