package com.dsalgms;

import java.util.Stack;

class TrapRainWater {
    public int trap(int[] height) {            
        int i = 0;
        //Loop until first non zero +ve int.
        if(height.length <= 2) {
            return 0;
        }
        while(height[i] == 0 ) {
            i++;
        }
        if(i<height.length) {
            Stack<Integer> st = new Stack<Integer>();
            int waterCapacity = 0;
            int currentBiggest = 0;        
         
            for(;i<height.length;i++) {
                if(height[i] >= currentBiggest) {                    
                    if(st.empty()) {
                        continue;
                    }
                    int sum = 0;
                    while(!st.empty()) {
                        sum += (currentBiggest - st.pop());
                    }
                    waterCapacity += sum;
                    currentBiggest = height[i];
                } else {
                    st.push(height[i]);
                }    
            }
            
            if(!st.empty()){
                int[] stArray = new int[st.size()];
                int k=0;
                for(Object el: st.toArray()){
                    stArray[k] = (Integer)(el);
                }
                return waterCapacity + trap(stArray);
            }
            return waterCapacity;
            
            
        } else {
            return 0;
        }
        
        
        
        
    }
}
