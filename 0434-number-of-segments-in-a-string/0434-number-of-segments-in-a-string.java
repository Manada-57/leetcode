class Solution {
    public int countSegments(String s) {
        s=s.trim();
        if(s.equals(""))return 0;
        
        String[] arr=s.split("\\s+");
        System.out.println(arr);
        return arr.length;
    }
}