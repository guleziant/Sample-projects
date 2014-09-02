import java.util.*;

public class treeNode<E> {

	E data;
	ArrayList<treeNode<E>> children;
	
	treeNode(){
		children = null;
	}
	
	treeNode(E newData){
		this();
		setData(newData);		
	}
	
	treeNode(E newdata, ArrayList<treeNode<E>> child){
		setData(newdata);
		children = child;		
	}
	
	public void addChildren(treeNode<E> child){
		if(children == null){
			children = new ArrayList<treeNode<E>>();
		}
		children.add(child);
	}
	
	public void setChildren(ArrayList<treeNode<E>> newChildren){
		children = newChildren;
	}
	
	 public void setData(E data) {
	        this.data = data;
	    }
	
	public E getData(){
		return data;
	}
	
	public ArrayList<treeNode<E>> getChildren(){
		return children;
	}
	
	public boolean hasChildren(){
		if(children == null){
			return false;
		}else{
			return true;
		}
	}

}
