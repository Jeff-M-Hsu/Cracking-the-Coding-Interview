/*
 * Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by
 * 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		layeredRotate(matrix);
		for(int[] x : matrix){
			for(int y : x){
				System.out.print(y + "\t");
			}
			System.out.println();
		}
	}
	
	//O(n^2) brute force solution, space complexity of O(n^2) as well which is annoying
	public static int[][] rotate(int[][] matrix){
		int[][] result = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				result[i][j] = matrix[matrix.length-1-j][j]; //copy array over starting from bottom left corner, traversing up each column
			}
		}
		return result;
	}
	
	//O(n^2) solution that does it without additional space, I don't quite understand it and thus had to look at the answers but I will be back to figure it out
	public static void layeredRotate(int[][] matrix){
		for(int layer=0; layer < matrix.length/2; layer++){
			int first = layer;
			int last = matrix.length-1-layer;
			for(int i = first; i <last; i++){
				int offset = i-first;
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
}
