import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    static int totalTrees = 0;

    int number;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(){
        totalTrees ++;
        number = totalTrees;
    }
}
