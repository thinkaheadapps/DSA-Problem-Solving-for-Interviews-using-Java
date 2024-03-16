package Stack;


import java.util.*;

public class MergeOverlappingIntervalsProgram {

   /*
   Brute force approach:
   Eg {{1,4}, {8,12}, {3,7},{2,6},{9,11}}
   In BF approach we fix one interval and for that interval we consider all other intervals
   Here {1,4} is Fixed interval and we are going to check other intervals one by one-
    {1, 4} and {8,12} - No Overlap
    {1, 4} and {3, 7} - Overlapping - Merge them - {1,7} and remove {3, 7}
    {1,7} and {2,6} - Overlapping - merge them - {1,7} and remove {2,6}

     TC - O(N^2)
    */

    /*
    Step 1:- Optimisation- Sort the array and then try to merge interval optimally
    Eg- {{1, 4},{8, 12},{3,7},{2,6},{9,11},{17,25},{15,21}}
    Sorted Interval- {{1,4},{2,6},{3,7},{9,11}{15,21},{17,25}}

    Step 2:- Merge Intervals using Stack:

     Bottom: {1, 4}, Top: {2, 6}
     If the starting point of the top interval is less than or equal to the ending time of the bottom interval,
     then merge the intervals.

     Bottom - {1,6} TOP - {3,7} - Again merge interval and new interval - {1,7}

     Bottom - {1,7} TOP - {9,11} - Not overlapping interval - Add this interval in Stack

     Bottom -{9,11} and Top {15,21} - Not overlapping  interval - Add this interval to stack

     Bottom - {15,21} Top - {17,25} - Overlapping - merged Interval - {15,25}

     Final Array -

     TC - For sorting Array nlogn + n
     O(nlogn)
     SC - O(n) - because of using stack
     */


     /*
     Program
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 4},{8, 12},{3,7},{2,6},{9,11},{17,25},{15,21}};
        int[][] ans = mergeIntervals(intervals);
        for(int[] arr :ans) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>();

        st.push(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            if(st.peek()[1] >= intervals[i][0]) {
                st.peek()[1] = Math.max(st.peek()[1], intervals[i][1]);
            }else {
                st.push(intervals[i]);
            }

        }
        int[][] ans = new int[st.size()][2];
        for(int i = ans.length - 1; i>= 0; i--) {
        ans[i][0] = st.peek()[0];
        ans[i][1] = st.peek()[1];
        st.pop();
        }
        return ans;
    }

}

/*
Given an array of intervals in any order, merge all overlaping intervals into one and return an array of non-overlapping intervals into one and return an array of non-overlapping intervals.

Sample input
intervals = {{1,4},{2,5},{7,14,{6,11}}

Sample Output
Non - Overlapping intervals: {{1,15},{6,14}}
 */