class Solution { 
    public List<Integer> findMissingElements(int[] nums) { 
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        Arrays.sort(nums); 
        for (int i=0;i<nums.length-1;i++) { 
            for (int j=nums[i]+1;j<nums[i+1];j++) { 
                res.add(j); 
            } 
        } 
        return res;
    } 
}
