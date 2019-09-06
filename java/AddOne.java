package com.cip.main;

/*
Consider a given integer array as input e.g. [2,8,9] which is an array representation
of integer 289 where 0 index is the Most Significant Digit and last index is the
Least Significant Digit.Add 1 to the Least Significant Digit such that the resultant array will be [2,9,0].
 */
public class AddOne {

    //Efficient method
    private int[] addOne(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < 9) {
                a[i]++;
                return a;
            } else
                a[i] = 0;
        }
        int res[] = new int[n + 1];
        res[0] = 1;
        return res;
    }

    private int[] addOneBruteForce(int[] a){
        if (a == null || a.length == 0)
            return new int[0];
        int carry = 0;
        int n = a.length;
        a[n-1]+=1;
        for(int i=n-1;i>=0;i--){
            a[i]+=carry;
            carry = a[i]/10;
            a[i]%=10;
        }
        if(carry == 1){
            int res[] = new int[n+1];
            res[0] = 1;
            return res;
        }
        return a;
    }

    private void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static void main(String s[]) {
        AddOne a1 = new AddOne();
        int res[] = a1.addOne(new int[]{9,9});
        int resBf[] = a1.addOneBruteForce(new int[]{1,2,3});
        a1.print(resBf);
        System.out.println("=======from Brute Force method==========");
        a1.print(res);
    }
}

