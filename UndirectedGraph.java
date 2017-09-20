//Chang Kim
import java.util.Queue;

public class UndirectedGraph<T> implements BasicGraphInterface <T> {
	
	private DirectedGraph digraph;
	
	public UndirectedGraph() {
		digraph = new DirectedGraph<T>();
	}

	public boolean addVertex(T vertexLabel) {
		return digraph.addVertex(vertexLabel);
	}

	public boolean addEdge(T begin, T end, double edgeWeight) {
		return digraph.addEdge(begin,end,edgeWeight) && digraph.addEdge(end,begin,edgeWeight);
	}

	
	public boolean addEdge(T begin, T end) {
		return addEdge(begin,end,0);
	}

	
	public boolean hasEdge(T begin, T end) {
		return digraph.hasEdge(begin,end) && digraph.hasEdge(end,begin);
	}

	
	public boolean isEmpty() {
		return digraph.isEmpty();
	}

	
	public int getNumberOfVertices() {
		return digraph.getNumberOfVertices();
	}

	
	public int getNumberOfEdges() {
		return digraph.getNumberOfEdges()/2;
	}

	
	public void clear() {
		digraph.clear();
	}
	
	public Queue<T> getBreadthFirstTraversal(T origin) {
		return digraph.getBreadthFirstTraversal(origin);
	}
	
	public Queue<T> getDepthFirstTraversal(T origin) {
		return digraph.getDepthFirstTraversal(origin);
	}
	
	
	public boolean isConnected(T origin) {
		Queue<T> queue = getDepthFirstTraversal(origin);
		int count = 0;
		while(queue.isEmpty() != true){
			count++;
			queue.remove();
		}
		if(count == getNumberOfVertices())
			return true;
		else
			return false;
	}
}
