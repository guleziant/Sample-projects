//OL
import java.util.*;
public class Graph<T> {

	private Map<T, Vertex<T>>  vertices;
	private int edgeCount;
	private Stack<T> stack;
	private Queue<T> queue;
	private ArrayList<T> endVertices;
	private Map<T, ArrayList<T>> graph;
	private ArrayList<T> visitedList;
	private ArrayList<T> visitedList2;
	
	public Graph()
	{
		vertices = new HashMap<T, Vertex<T>>();
		stack = new Stack<T>();
		queue = new LinkedList<T>();
		graph = new HashMap<T, ArrayList<T>>();
		visitedList = new ArrayList<T>();
		visitedList2 = new ArrayList<T>();
		edgeCount = 0;
		
	} // end default constructor
	
	public boolean isEmpty()
	{
	  return vertices.isEmpty();
	} // end isEmpty

	public void clear()
	{
	  vertices.clear();
	  edgeCount = 0;
	} // end clear
	
	public boolean addVertex(T label)
	{
	  boolean wasAdded =false;
		if (!vertices.containsKey(label)){
			vertices.put(label, new Vertex<T>(label));
			wasAdded = true;
		}
	  return wasAdded; // was add to dictionary successful?
	} // end addVertex

	public int getNumberOfVertices()
	{
	  return vertices.size();
	} // end getNumberOfVertices
	
	public boolean addEdge(T begin, T end, double edgeWeight)
	{
	  boolean result1=false, result2 = false;
	  
	  Vertex<T> beginVertex = vertices.get(begin);
	  Vertex<T> endVertex = vertices.get(end);
	  
	  if ( (beginVertex != null) && (endVertex != null) ){
	    result1 = beginVertex.connect(endVertex, edgeWeight);
	    if (result1)
	    	result2 = endVertex.connect(beginVertex, edgeWeight);
	  } 
	  else{
		  System.out.println("You should first add vertices with these labels");
	  }
	  if (result1 && result2)
	    edgeCount++;
	    
	  return (result1 || result2);
	} // end addEdge

	public int getNumberOfEdges()
	{
	  return edgeCount;
	} // end getNumberOfEdges

	public void display()
	{	
		for (Vertex<T> vertex: vertices.values())
			vertex.display();
			
	} // end display 
	
	public void setGraph(){
		for(Vertex<T> vertex: vertices.values()){
			T returnVertex = vertex.getLabel();			
			//System.out.print(returnVertex);
			endVertices = vertex.getEndVertexes();
			
			//System.out.print(endVertices);
			graph.put(returnVertex, endVertices);
			
			if(returnVertex.equals("A") || returnVertex.equals("Falmouth")){
				while(!stack.isEmpty())
					stack.pop();
				
				while(!queue.isEmpty())
					queue.poll();
				
				stack.push(returnVertex);
				visitedList.add(returnVertex);
				queue.add(returnVertex);
				visitedList2.add(returnVertex);
				//System.out.println(returnVertex);
			}
			
		}
		
	}
	
	public void DFSTraversal(){		
		System.out.print("DFS Traversal Order: " + stack.peek() + ", ");
				
		while(!stack.isEmpty()){
			T connectedVertex;
			T topVertex = stack.peek();
			ArrayList<T> connectedVertexes = graph.get(topVertex);
			
			if(!connectedVertexes.isEmpty()){
				connectedVertex = connectedVertexes.get(0);
				if(!visitedList.contains(connectedVertex)){
					visitedList.add(connectedVertex);
					stack.push(connectedVertex);
					System.out.print(connectedVertex + ", ");
				}else{
					if((connectedVertexes.size() > 1)){
						for(int i = 0; connectedVertexes.size() > 0;){
							if(visitedList.contains(connectedVertexes.get(i))){
								connectedVertexes.remove(i);
							}else{
								stack.push(connectedVertexes.get(i));
								System.out.print(connectedVertexes.get(i) + ", ");
								visitedList.add(connectedVertexes.get(i));
								break;
							}
						}					
					}else{
						stack.pop();
					}
				}
			}else{
				stack.pop();
			}
			
		}
		
	}
	
	public void BFSTraversal(){
		System.out.print("BFS Traversal Order: " + queue.peek() + ", ");
		
		while(!queue.isEmpty()){
			T firstVertex = queue.peek();
			ArrayList<T> adjacentVertexes = graph.get(firstVertex);
			
			if(!adjacentVertexes.isEmpty()){
				for(int i = 0; adjacentVertexes.size() > 0;){
					if(visitedList2.contains(adjacentVertexes.get(i))){
						adjacentVertexes.remove(i);
					}else{
						queue.add((adjacentVertexes.get(i)));
						System.out.print(adjacentVertexes.get(i) + ", ");
						visitedList2.add(adjacentVertexes.get(i));
					}
				}
			}else{
				queue.poll();
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Graph<String> roadMap = new Graph<String>();
		
		/*roadMap.addVertex("Provincetown");
		roadMap.addVertex("Truro");
		roadMap.addVertex("Orleans");
		roadMap.addVertex("Chatham");
		roadMap.addVertex("Barnstable");
		roadMap.addVertex("Hyannis");
		roadMap.addVertex("Sandwich");
		roadMap.addVertex("Falmouth");

		roadMap.addEdge("Provincetown", "Truro", 10);
		roadMap.addEdge("Truro", "Orleans", 17);
		roadMap.addEdge("Orleans", "Chatham", 9);
		roadMap.addEdge("Chatham", "Hyannis", 19);
		roadMap.addEdge("Hyannis", "Barnstable", 4);
		roadMap.addEdge("Barnstable", "Sandwich", 12);
		roadMap.addEdge("Barnstable", "Orleans", 19);
		roadMap.addEdge("Hyannis", "Falmouth", 20);*/
		
		roadMap.addVertex("A");
		roadMap.addVertex("B");
		roadMap.addVertex("C");
		roadMap.addVertex("D");
		roadMap.addVertex("E");
		roadMap.addVertex("F");
		roadMap.addVertex("G");
		roadMap.addVertex("H");
		
		roadMap.addEdge("A", "B", 1);
		roadMap.addEdge("A", "C", 1);
		roadMap.addEdge("B", "E", 1);
		roadMap.addEdge("C", "D", 1);
		roadMap.addEdge("D", "E", 1);
		roadMap.addEdge("D", "F", 1);
		roadMap.addEdge("E", "F", 1);
		roadMap.addEdge("E", "G", 1);
		roadMap.addEdge("F", "G", 1);
		roadMap.addEdge("E", "H", 1);
		roadMap.addEdge("G", "H", 1);
		
		System.out.println("My Implmented Graph: ");
		roadMap.setGraph();
		roadMap.DFSTraversal();
		System.out.println();
		roadMap.setGraph();
		roadMap.BFSTraversal();
		
		
		/*System.out.println("Graph has " + 
				roadMap.getNumberOfVertices() + " vertices and " 
				+roadMap.getNumberOfEdges() + " edges.");*/
		//roadMap.display();
	}
}