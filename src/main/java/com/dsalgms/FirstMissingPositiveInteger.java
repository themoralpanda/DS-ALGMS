package com.dsalgms;

import java.util.Arrays;

class FirstMissingPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        boolean[] bitVector = new boolean[nums.length];        
        int j;
        for(j=0;j<nums.length;j++) {
         if(nums[j] <= 0 || nums[j] > (nums.length) ) 
             continue;
         bitVector[nums[j]-1] = true;
             
        }
        System.out.println(Arrays.toString(bitVector));
        int k =0;
        for(; k< bitVector.length; k++) {
            if(!bitVector[k])
                return k+1;
        }  
        return k+1;
    }
}
