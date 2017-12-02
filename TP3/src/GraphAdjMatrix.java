import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class GraphAdjMatrix {
	
		 private final int N;
		 private int M;
		 private boolean[][] adj;
		 
		 public GraphAdjMatrix(String filePath) throws IOException {
				
			 List<String> lines = Files.readAllLines(Paths.get(filePath),
						StandardCharsets.UTF_8);

			 Set<String> set_1 = new HashSet<String>();// get order from txt
				for (String line : lines) {
					String[] nodesNumber = line.split(" ");
					for (String nodeNumber : nodesNumber) {
						set_1.add(nodeNumber);
					}
				}
				N=set_1.size();
				Set<String> set_2 = new HashSet<String>();// get size from txt
				for (String line : lines) {
					String[] ordersNumber = line.split("/n");
					for (String orderNumber : ordersNumber) {
						set_2.add(orderNumber);
					}
				}
				M=set_2.size();
				adj = new boolean[N][N];
				addEdgesToGraph(lines);

			}
		
			
			private void addEdgesToGraph(List<String> lines) {

				for (String line : lines) {
					String[] nodesNumber = line.split(" ");
					int node1Index = Integer.parseInt(nodesNumber[0]);// string to int
					int node2Index = Integer.parseInt(nodesNumber[1]);
					addEdge(node1Index, node2Index);

				}
			}

		 
			 public void addEdge(int i, int j) {
		            if (i >= 0 && i <= N && j > 0 && j <=N) {
		                  adj[i-1][j-1] = true;
		                  adj[j-1][i-1] = true;
		            }
		      }
			 
			 public void print() {
				 Integer[][] a;
				 a=new Integer[N][N];
				 for(int i=0;i<N;i++){
					 for(int j=0;j<N;j++){
						 if(adj[i][j]==true){
							 a[i][j]=1;
						 }else{
							 a[i][j]=0;
						 }
						 System.out.print(a[i][j]+" ");
					 }
					 System.out.print("\n");
				 }
			 }
			 
			 public static void main(String[] args) throws IOException {
					GraphAdjMatrix matrix = new GraphAdjMatrix("C:/Users/jxy01/Desktop/ÎÄ¼þpdf/Algo/graph.txt");
					matrix.print();
					
				}
		
}
