import java.util.*;

public class Main {

	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>();
		// root level
		treeNode<String> lv1 = new treeNode<String>("President");
		
		// third level of data
		treeNode<String> lv3_1 = new treeNode<String>("Dean of Arts and Sciences");
		treeNode<String> lv3_2 = new treeNode<String>("Dean of Business");
		treeNode<String> lv3_3 = new treeNode<String>("Dean of Engineering");
		
		ArrayList<treeNode<String>> list = new ArrayList<treeNode<String>>();
		// second level data
		String[] administration = {"VP Academic Affairs", "VP Business Affairs"};		
		
		lv1.addChildren(new treeNode<String>(administration[0]));
		lv1.addChildren(new treeNode<String>(administration[1]));

		// creates a list of children
		list.add(lv3_1);
		list.add(lv3_2);
		list.add(lv3_3);
		
		// third level containing a list of children
		lv1.addChildren(new treeNode<String>("VP Student Affairs", list));
		
		// fourth level of data
		lv3_1.addChildren(new treeNode<String>("Chair of CS"));
		lv3_2.addChildren(new treeNode<String>("Chair Accounting"));
		lv3_3.addChildren(new treeNode<String>("Chair of CE"));
		
		tree.setRoot(lv1);
		
		if(tree.isEmpty()){
			System.out.println("\nGeneral is not yet populated. General tree is empty");
		}else{
			System.out.println("\nStrings added to gerneral tree. General tree is not empty");
		}
		
		tree.levelOrderTraversal();
		
		System.out.println("\n\nPreoder: ");
		tree.preOrderTraversal();
		
		tree.clear();
		
		if(tree.isEmpty()){
			System.out.println("\n\nThe tree has been cleared and is Empty");
		}else{
			System.out.println("\n\nThe tree is not empty");
		}

	}

}
