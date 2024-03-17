package Stack;

import java.util.Stack;

public class NextGreaterElement1 {

    /*
    Given an integer of Size N. Find the next greater number for every element in the array.
    The next greater number of x is first greater number present to its right.If does not exist, return -1 for that number.

    Sample input
    arr = {7,6,3,8,2,11,30,5,25}

    Sample output:
    ans = {8,8,8,11,11,30,-1,25,-1}
     */

    /*
    Brute force approach
    For every element x, traverse on the right elements and find the first larger number than x.

     */

    public static void main(String[] args) {

        //int[] inputArray =  {7,6,3,8,2,11,30,5,25};
        int[] inputArray =  {5,9,6,4,17,75,50,60,70,80 };
        //int[] result = nextGreaterElement(inputArray);
        int[] result = nextGreaterElementOptimised(inputArray);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] nextGreaterElementOptimised(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        // Start iterating from rightmost element
        for(int i = arr.length - 1; i >= 0; i--) {
            // Pop all smaller elements
            while(st.size() > 0 && st.peek() <= arr[i]) {
                st.pop();
            }
            //Update ans
            if(st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            // Add current element in the stack
            st.push(arr[i]);
        }
        return ans;
    }
}
