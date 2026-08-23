class Solution { 
    public String reverseStr(String s, int k) { 
        int j=0,p=0; 
        char t=' '; 
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i+=2*k){ 
            j=i; 
            p=Math.min(i+k-1, arr.length-1); 
            while(j<p){ 
                t=arr[j]; 
                arr[j]=arr[p]; 
                arr[p]=t; 
                j++;
                p--;
            } 
        } 
        return new String(arr); 
    } 
}
