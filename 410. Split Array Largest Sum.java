class Solution {
    public int splitArray(int[] books, int studs) {
        long left = max(books) , right= sum(books);
        while(left<=right){
            long mid = (left+right)/2;
            if(isPossible(books, studs,mid) == true)
                right = mid-1;
            else left = mid+1;
        }   
        return (int)left;
    }


    public long max(int[] books){
        long ans = 0;
        for(long pages : books){
            ans = Math.max(ans,pages);
        }
        return ans;
    }

     public long sum(int[] books){
        long ans = 0;
        for(long pages : books){
            ans += pages;
        }
        return ans;
    }

    public boolean isPossible(int[] books, int allowedStuds, long maxLoad){
        long currLoad = 0;
        int reqdStuds = 1;

        for(long pages: books){
            if(currLoad + pages <= maxLoad)
                currLoad+=pages;
        
        else{
            currLoad = pages;
            reqdStuds++;
        }
        }
 return (reqdStuds<=allowedStuds);
    }
}
