class Solution {

    public int minimizedMaximum(int n,
                                int[] quantities) {

        int left = 1;

        int right = 0;

        for(int q : quantities)
            right = Math.max(right, q);

        while(left < right){

            int mid = left + (right-left)/2;

            if(canDistribute(mid,
                    n,
                    quantities))

                right = mid;

            else

                left = mid + 1;
        }

        return left;
    }

    boolean canDistribute(int x,
                          int stores,
                          int[] quantities){

        int required = 0;

        for(int q : quantities){

            required += (q + x - 1) / x;

            if(required > stores)
                return false;
        }

        return true;
    }
}