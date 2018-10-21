/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 */
public class ZeroMatrix {
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,0}};
		zero(matrix);
		for(int[] x : matrix){
			for(int y: x){
				System.out.print(y + "\t");
			}
			System.out.println();
		}
	}

	//O(n*m) solution that uses O(1) space
	public static void zero(int[][] matrix){
		for(int n = 0; n < matrix.length; n++){
			for(int m = 0; m < matrix[0].length; m++){
				if(matrix[n][m] == 0){  //if zero element is found assign 0 to
					matrix[0][m] = 0;	//the element at the beginning of the row and column
					matrix[n][0] = 0;
				}
			}
		}
		for(int n = 0; n < matrix.length; n++){ //look for zeros at the beginning of each row
			if(matrix[n][0] == 0){
				for(int m = 1; m < matrix[0].length;m++){
					matrix[n][m] = 0;
				}
			}
		}
		for(int m = 0; m < matrix.length; m++){ //look for zeros at the beginning of each column
			if(matrix[0][m] == 0){
				for(int n = 1; n < matrix.length; n++){
					matrix[n][m] = 0;
				}
			}
		}
	}
}
