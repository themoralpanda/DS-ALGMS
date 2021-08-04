package java.com.dsalgms;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length==0){
            return 0.0;
        }
        if(nums1.length ==0 && nums2.length > 0) {
            return findMedianInSingleSortedArray(nums2);
        }
        if(nums1.length >0 && nums2.length == 0) {
            return findMedianInSingleSortedArray(nums1);
        }
        int combinedLength = nums1.length + nums2.length;
        int []c = new int[combinedLength/2 +1];
        int i=0,j=0,counter=0;
        while(counter<c.length) {
            if(nums1[i]<=nums2[j]) {
                c[counter] = nums1[i];
                if(i<nums1.length-1) {
                    i++;                    
                } else {
                    int max = c.length -(counter+1);
                    counter++;
                    for(int k=0;k<max;k++,j++,counter++)
                        c[counter]=nums2[j];
                    if(combinedLength %2 == 0) 
                        return (double)(c[c.length-1]+c[c.length-2])/2;
                    else
                        return (double) c[c.length-1];
                }
                                                
            } else {
                c[counter] = nums2[j];
                if(j<nums2.length-1) {
                    j++;                    
                } else {
                    int max = c.length -(counter+1);
                    counter++;
                    for(int k=0;k<max;k++,i++,counter++)
                        c[counter]=nums1[i];
                    if(combinedLength %2 == 0) 
                        return (double)(c[c.length-1]+c[c.length-2])/2;
                    else
                        return (double) c[c.length-1];
                }
            }
            counter++;
        }
        if(combinedLength %2 == 0) 
            return (double)(c[c.length-1]+c[c.length-2])/2;
        else
            return (double) c[c.length-1];                   
    }
    
    private double findMedianInSingleSortedArray(int []a) {
        if(a.length == 0) {
            return 0.0;
        } else if (a.length ==1) {
            return (double)a[0];
        } else {
            int mid = a.length/2;
            if(a.length %2 ==0) {            
                return (double)(a[mid] + a[mid-1])/2;
            } else {
                return (double)a[mid];
            }     
        }          
    }
}
