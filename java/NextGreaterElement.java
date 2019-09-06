package com.cip.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    //brute force approach
    public Map<Integer, Integer> nextGEBruteForce(int[] arr) {
        HashMap<Integer, Integer> res = new HashMap<>();
        if (arr.length == 0 || arr == null)
            return null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    res.put(arr[i], arr[j]);
                    break;
                }
            }
            if (!res.containsKey(arr[i]))
                res.put(arr[i], null);
        }
        return res;
    }

    //Optimized Approach

    public Map<Integer, Integer> nextGEOptimized(int[] arr) {
        Map<Integer, Integer> res = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty())
                st.push(arr[i]);
            else {
                //18,1,2,3,11,19

                //18,1,
                if ((st.peek() > arr[i])) {
                    st.push(arr[i]);
                } else {
                    while (!st.isEmpty() && arr[i] > st.peek()) {
                        res.put(st.pop(), arr[i]);
                    }
                    st.push(arr[i]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!res.containsKey(arr[i]))
                res.put(arr[i], null);
        }
        return res;
    }

    public static void main(String[] s) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        Map<Integer, Integer> res = nextGreaterElement.nextGEBruteForce(new int[]{18, 1, 3, 5, 4, 11, 19});
        System.out.println("Map Output: " + res);
        if (res == null) System.out.println("Null Input ");
        else {
            for (Integer it : res.keySet()) {
                System.out.println("Key = " + it + " Value = " + res.get(it));
            }
        }

        Map<Integer, Integer> resOp = nextGreaterElement.nextGEOptimized(new int[]{98, 23, 54, 12, 20, 7, 27});
        System.out.println("Map Output: " + resOp);
        if (resOp == null) System.out.println("Null Input ");
        else {
            for (Integer it : resOp.keySet()) {
                System.out.println("Key = " + it + " Value = " + resOp.get(it));
            }
        }
    }
}

