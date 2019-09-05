package com.cip.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectArrays {
    public int[] intersectBySorting(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums2[j] < nums1[i]) j++;
            else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr = new int[res.size()];
        for (i = 0; i < arr.length; i++)
            arr[i] = res.get(i);
        return arr;
    }

    public int[] intersectOptimizedApproach(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashMap<Integer, Integer> hm = new HashMap<>();
        //create count for nums1 array and persist in to HashMap
        for (int i = 0; i < nums1.length; i++) {
            if (!hm.containsKey(nums1[i]))
                hm.put(nums1[i], 1);
            else {
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
       /* Iterate nums2 array and check if the element is already present in the hashmap with count>0,
        add that element to resultant list and decrement the count*/
        for (int i = 0; i < nums2.length; i++) {
            if (hm.containsKey(nums2[i]) && hm.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] s) {
        IntersectArrays intersectArrays = new IntersectArrays();
        System.out.println("=====Sorting Approach==========");
        int[] res = intersectArrays.intersectBySorting(new int[]{3, 2, 2, 1}, new int[]{2, 2, 3});
        for (int i : res)
            System.out.print(i + " ");
        System.out.println("=====Optimized Approach========");
        int[] hm = intersectArrays.intersectOptimizedApproach(new int[]{1, 2, 3, 4}, new int[]{2, 2, 3});
        for (int i : hm)
            System.out.print(i + " ");

    }


}

