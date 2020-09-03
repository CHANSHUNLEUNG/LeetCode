package Questions.TwoPointers.question88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mEnd = m - 1, nEnd = n - 1, reverseEnd = m + n - 1;
        while (mEnd >= 0 || nEnd >= 0) {
            if(mEnd<0){
                nums1[reverseEnd--] = nums2[nEnd--];
            }else if(nEnd<0){
                nums1[reverseEnd--] = nums1[mEnd--];
            }
            else if(nums1[mEnd] > nums2[nEnd]) {
                nums1[reverseEnd--] = nums1[mEnd--];
            } else {
                nums1[reverseEnd--] = nums2[nEnd--];
            }
        }
    }
    public static void main(String[] argv){
    }
}
