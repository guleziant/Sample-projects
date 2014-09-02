import java.util.*;

public class Tree<E> {
	
	treeNode<E> root;
		
	public Tree(){
		super();
		root = null;
	}
	
	public Tree(treeNode<E> newTree){
		root = newTree;
	}
	
	public void setRoot(treeNode<E> node){
		this.root = node;
	}
	
	public treeNode<E> getRoot(){
		return root;
	}
	
	public int numChildren(){		
		return root.getChildren().size();
	}
	
	private void levelOrderTraversal(treeNode<E> node){
		if(node == null){
			return;
		}

		Queue<treeNode<E>> listQueue = new LinkedList<treeNode<E>>();
		listQueue.add(node);
		System.out.println("\nLevel Order Traversal: ");
		
		while(!listQueue.isEmpty()){
			node = listQueue.remove();					
	
			if(node != null){
				System.out.print(node.getData() + ", ");
				if(node.hasChildren()){
					for(treeNode<E> child: node.getChildren()){
						listQueue.add(child);
					}
				}
			}
		}
	}
	
	public void levelOrderTraversal(){
		levelOrderTraversal(root);
	}
	
	private void preOrderTraversal(treeNode<E> node){
		if(node == null)
			return;
		
		System.out.print(node.getData() + ", ");
		
		if(node != null){
			if(node.hasChildren()){
				for(treeNode<E> child: node.getChildren()){
					preOrderTraversal(child);
				}
			}
		}
	}
	
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}
	 
	public boolean isEmpty(){
		if(root == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void clear(){
		root = null;
	}

}
