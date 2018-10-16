/*
 * Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by
 * 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
	public static void main(String[] args){
		int[][] matrix = {{1,1,1,1},{0,0,0,0},{1,1,1,1},{0,0,0,0}};
		for(int[] x : matrix){
			for(int y : x){
				System.out.print(y + " ");
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
}
