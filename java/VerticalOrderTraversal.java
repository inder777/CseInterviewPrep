package com.cip.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;

 public TreeNode(int data) {
 this.data = data;
 }
}

public class VerticalOrderTraversal {
 public static Map<Integer, List<Integer>> res = new HashMap<>();

 public void verticalOrder(TreeNode root) {
 if (root == null)
 return;
 verticalOrderHelper(root, 0);
 }

 public void verticalOrderHelper(TreeNode root, int hd) {
 if (root == null)
 return;

 if (!res.containsKey(hd)) {
 List resList = new ArrayList<>();
 resList.add(root.data);
 res.put(hd, new ArrayList<>(resList));
 } else
 res.get(hd).add(root.data);

 verticalOrderHelper(root.left, hd - 1);
 verticalOrderHelper(root.right, hd + 1);
 }

 /* Sample tree is like : 1
 / \
 2 3
 \ /
 4 5

 */
 public static void main(String[] s) {
 VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
 TreeNode root = new TreeNode(1);
 root.left = new TreeNode(2);
 root.right = new TreeNode(3);
 root.left.right = new TreeNode(4);
 root.right.left = new TreeNode(5);
 /*root.right = new TreeNode(2);
 root.right.right = new TreeNode(3);
 root.right.right.right = new TreeNode(4);*/
 verticalOrderTraversal.verticalOrder(root);
 for (Integer val : res.keySet()) {
 System.out.println("Key: " + val + " value: " + res.get(val));
 }

 }

}
