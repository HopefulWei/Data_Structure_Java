class getNodeParent {
    TreeNode getParent(TreeNode root,TreeNode target){
        if(root==null||target==null||target==root)return null;
        if(root.right==target||root.left==target) {
            return root;
        }
        TreeNode parents=getParent(root.left,target);
        if(parents==null){
            parents=getParent(root.right,target);
        }
        return parents;
    }
}