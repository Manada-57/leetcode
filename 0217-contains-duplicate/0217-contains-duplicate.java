class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for (int n : nums) {
           if (store.add(n) == false) {
               return true;
            }
        }
        return false;
    }
}