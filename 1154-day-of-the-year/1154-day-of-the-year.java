class Solution {
    public int dayOfYear(String date) {
        int[] day={31,28,31,30,31,30,31,31,30,31,30,31};
        int y=Integer.parseInt(date.substring(0,4));
        int mo=Integer.parseInt(date.substring(5,7));
        int dat=Integer.parseInt(date.substring(8,10));
        int tot=0;
        for(int i=0;i<mo-1;i++){
            tot+=day[i];
        }
        tot+=dat;
        if(((y%4==0&&y%100!=0) || y%400==0)&&mo>2){
            tot+=1;
        }
        return tot;
    }
}