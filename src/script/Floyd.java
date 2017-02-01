package script;

public class Floyd {

	public static void floyd(int n, double[][] c, double[][] d, int[][] p) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				d[i][j] = c[i][j];
				p[i][j] = i;
			}
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
						p[i][j] = p[k][j];
					}
				}
			}
		}
	}
	
	private static void printPath(int[][] path, int i, int j) {
		if(i == j) {
			System.out.print(i);
		} else {
			printPath(path, i, path[i][j]);
			System.out.print(" - " + j);
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
