import java.io.IOException;
import java.util.Scanner;


public class keyboard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		     int j , k;//source and destination
	         int N,M;//number of nodes and edges
	         int count = 1;
	         Scanner scan = new Scanner(System.in);
	       
	             
	             System.out.println("Enter the number of vertices ");
	             N = scan.nextInt();
	             System.out.println("Enter the number of edges ");
	             M = scan.nextInt();
	             Graph adjacencyList = new Graph(N,M);
	 
	             
	             System.out.println("Enter the edges in the graph  : <to> <from>");
	             while (count <= M)
	             {
	                 j = scan.nextInt();
	                 k = scan.nextInt();
	                 adjacencyList.addEdge(j, k);
	                 count++;
	             }
	             adjacencyList.print();
	            
	             scan.close();
	
	}
}
