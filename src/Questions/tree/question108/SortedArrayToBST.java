package Questions.tree.question108;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        TreeNode left =  buildBST(nums, start, middle - 1);
        TreeNode right =  buildBST(nums, middle + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
