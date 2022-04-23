class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        List<int[]> ans = new ArrayList<>();
        int half = target / 2;
        int sum = 0;
        while(i <= half){
            if(sum == target){
                ans.add(getArray(i, j));
                sum -= i;
                i++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                sum += j;
                j++;
            }
        }
        return ans.toArray(new int[0][]);
    }

    int[] getArray(int i, int j){
        int[] a = new int[j - i];
        for(int index = 0; i < j; index++, i++){
            a[index] = i;
        }
        return a;
    }
}