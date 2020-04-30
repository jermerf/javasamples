import java.util.List;

public class TreeProgram {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        TreeNode favouriteChild = new TreeNode();
        root.children.add(favouriteChild);
        root.children.add(new TreeNode());
        root.children.add(new TreeNode());

        favouriteChild.children.add(new TreeNode());
        favouriteChild.children.add(new TreeNode());
    }
}
