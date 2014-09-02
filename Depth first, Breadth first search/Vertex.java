//OL
import java.util.*;

public class Vertex<T> {
	private T label; 
	private List<Edge> edgeList; // edges to neighbors
	
	public Vertex(T label)
	{
	    this.label = label;
	    edgeList = new LinkedList<Edge>();
	} // end constructor
	
	public boolean equals(Vertex<T> other)
	{
	  boolean result;
	  
	  if ((other == null))
	    result = false;
	  else
	    result = label.equals(other.label);
	  
	  return result;
	} // end equals
	
		public T getLabel()
		{
			return label;
		} // end getLabel

	
		public boolean connect(Vertex<T> endVertex, double edgeWeight) 
		{
		  boolean result = false, connected=false;
		  
		  if (this.equals(endVertex)){
				  result = false;
		          connected=true;
		  }
		  
		  else { 
			 for(Edge edge: edgeList){
				if ((edge.endVertex).equals(endVertex)){
					result = false;
				    connected=true;
				}
			 }
		  }
		  if (!connected){	 
		      edgeList.add(new Edge(endVertex, edgeWeight));
		      result = true;
		  }	  
		return result;
		} // end connect
		
		
		public void display() 
		{
			System.out.print("From "+label + ": " );
			
			for (Edge edge: edgeList){
				edge.display();
				
			}
				
			System.out.println();
		} // end display
		
		public ArrayList<T> getEndVertexes(){
			ArrayList<T> endVertex = new ArrayList<T>();
			for(Edge edge: edgeList){
				endVertex.add(edge.getEndVertex().getLabel());
			}
			return endVertex;
		}
		
	protected class Edge
	 {
	  	
	  private Vertex<T> endVertex; // end vertex
	  private double weight;
	  
	  protected Edge(Vertex<T> endVertex, double edgeWeight)
	  {
	    this.endVertex=endVertex;
	    this.weight = edgeWeight;
	  } // end constructor
	  
	  protected Vertex<T> getEndVertex()
	  {
	    return endVertex; 
	  } // end getEndVertex
	  
	  protected double getWeight() 
	  {
	    return weight; 
	  } // end getWeight
	  protected void display(){
		  System.out.print("[To: "+endVertex.label + " " + weight +"] ");
	  }
	} // end Edge
}

