public class EjerciciosCodingbat{
    // Ejercicios Array 2
    /**
     * Return the number of even ints in the given array
    */
    public int countEvens(int[] nums){
    int cont = 0;
    for(int i=0; i<nums.length; ++i){
        if(nums[i]%2==0){
        ++cont;
        }
    }
    return cont;
    }

    /**
     *Return the sum of the numbers in the array, returning 0 for an empty array. 
     *Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
     */
    public int sum13(int[] nums) {
    int sum=0;
    if(nums.length>0){
        for(int i=0; i<nums.length; ++i){
        if(nums[i]==13){
            ++i;
        }
        else{
            sum+=nums[i];
        }
        }
        return sum;
    }
    return 0;
    }

    /**
     *Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in nums2 (at the same index).
     *Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
     */
    public int matchUp(int[] nums1, int[] nums2) {
    int cont = 0;
    for(int i=0; i<nums1.length; ++i){
        if(nums1[i]!=nums2[i]){
        if((nums1[i]-nums2[i])<=2 && nums2[i]-nums1[i]<=2){
            ++cont;
        }
        }
    }
    return cont;
    }

    /**
     *We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, at least one of the pair is that value.
     *Return true if the given value is everywhere in the array.
     */
    public boolean isEverywhere(int[] nums, int val) {
    for(int i=0; i<nums.length-1; ++i){
        if(nums[i]!=val && nums[i+1]!=val){
        return false;
        }
    }
    return true;
    }

    /**
     *Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come before all the odd numbers.
     *Other than that, the numbers can be in any order.
     *You may modify and return the given array, or make a new array.
     */
    public int[] evenOdd(int[] nums) {
    int temp=0;
    for(int i=0; i<nums.length; ++i){
        for(int j=0; j<nums.length; ++j){
            if(nums[i]%2==0){
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        } 
        }
    }
    return nums;
    }
    
    //Ejercicios Array 3
    /** 
     *Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive.
     *A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
     */
    public int maxSpan(int[] nums) {
        if (nums.length > 0) {
            int maxSpan = 1;
            for (int i = 0; i < nums.length; i++){
                for (int j = nums.length - 1; j > i; j--){
                    if (nums[j] == nums[i]) {
                        int count = (j - i) + 1;
                        if (count > maxSpan){
                            maxSpan = count;
                            break;
                        }
                        }
                    }
                }
             return maxSpan;
            } else  {
                return 0;
            }
        }
          
    /**
     *Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4.
     *Do not move the 3's, but every other number may move. 
     *The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
     */
    public int[] fix34(int[] nums) {
        for(int i = 0; i < nums.length; ++i ){
            if (nums[i]==3){
                int temp = nums[i+1];
                nums[i+1]= 4;
                for(int j=i+2; j <nums.length; ++j){
                    if(nums[j]==4){
                        nums[j] = temp;
                    }
                }
            }
        }
            return nums;
        }
        
    /**
     * (This is a slightly harder version of the fix34 problem.)
     * Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5.
     * Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4.
     * In this version, 5's may appear anywhere in the original array.
     */
    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 5 && i == 0 || nums[i] == 5 && nums[i - 1] != 4) {
               int pos5 = i;
               for (int j = 0; j < nums.length; j++){
                   if (nums[j] == 4 && nums[j + 1] != 5) {
                        int temp = nums[j + 1];
                        nums[j + 1] = 5;
                        nums[pos5] = temp;
                        break;
                    }
                }
              }
            }
            return nums;
        }
     
    /**
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
     */
    public boolean canBalance(int[] nums) {
        for (int i=0; i < nums.length; ++i){
            int sum =0;
            for(int j=0; j<i ; ++j){
                sum+=nums[j];
            }
            for(int k=i; k < nums.length; ++k){
                sum-=nums[k];
            }
            if (sum==0)    return true;
        }
        return false;
    }
    
    /**
     * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer.
     * The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.
     */
    public boolean linearIn(int[] outer, int[] inner) {
        int indexInner = 0;
        int indexOuter = 0;
        while (indexInner < inner.length && indexOuter < outer.length) {
            if (outer[indexOuter] == inner[indexInner]) {
                indexOuter++;
                indexInner++;
            } else indexOuter++;
        }
        return (indexInner == inner.length);
    }
     
}