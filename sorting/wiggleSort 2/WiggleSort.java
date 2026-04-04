import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class WiggleSort {
    private static void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        // 1st approch by comparing
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }

        // 2nd approch by fill odd and even indivisually

        // fill odd
        /*
         * for(int i =1 ; i<n ;i+=2 ){
         * nums[i] = sorted[right--];
         * }
         * 
         * //fill even
         * 
         * for(int i =0 ; i<n ; i += 2){
         * nums[i] = sorted[left--];
         * }
         */
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 1, 4, 7, 1, 9, 3, 1, 7 };

        wiggleSort(nums);

        try {
            FileWriter write = new FileWriter("output.txt");
            for (int x : nums)
                write.write(x + " ");

            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}