class Solution {
    // public static void printPermutation(String str,int idx,String perme){
    //     if(str.length()==0){
    //         System.out.println(perme);
    //         return;
    //     }
    //     for(int i=0;i<str.length();i++){
    //         char currChar=str.charAt(i);
    //         char newChar=str.substring(0,i)+str.substring(i+1);
    //         printPermutation(newStr,idx+1,perme+currChar);

    //     }
    // }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];
        helper(nums,visited,new ArrayList<>(),ans);
        return ans;

        
    }
    public static void helper(int[]nums,boolean[]visited,List<Integer>temp,List<List<Integer>>ans){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            temp.add(nums[i]);
            helper(nums,visited,temp,ans);
            
            temp.remove(temp.size()-1);
            visited[i]=false;     }
    }
}