//This is sample program to find the inverse of a matrix
 
import java.util.Scanner;
 
public class InverseMatrix
{
    public static void main(String argv[]) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the dimension of square matrix: ");
        int n = input.nextInt();
        double a[][]= new double[n][n];
        System.out.println("Enter the elements of matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        double[][] originalMatrix = new double[n][n];
        originalMatrix = copyArray(a);
        //need to copy a because Gaussian Elimination will effect the original value of array
                
        double d[][] = invert(a);
        
        System.out.println("The inverse is: ");
        
        printMatrix(d);

        System.out.println("The original matrix is: ");


        // Check if d * a equals the identity matrix
        double[][] product = multiplyMatrices(d, originalMatrix);
        
        System.out.println("Is the product of inverse and matrix equal to the identity matrix? " + isIdentityMatrix(product));

        printMatrix(product);


        input.close();

    }	
 
    public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
 // Transform the matrix into an upper triangle
        gaussian(a, index);
 
 // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= a[index[j]][i]*b[index[i]][k];
 
 // Perform backward substitutions
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
 
// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
 
 // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
 // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
 // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
   // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) 	
            {
                double pj = a[index[i]][j]/a[index[j]][j];
 
 // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
 // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public static double[][] multiplyMatrices(double[][] m1, double[][] m2) {
        int rows1 = m1.length;
        int cols1 = m1[0].length;
        int cols2 = m2[0].length;

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return result;
    }

    //  public static boolean isIdentityMatrix(double[][] matrix) {
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;

    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             if (i == j) {
    //                 if (Math.abs(matrix[i][j] - 1.0) > 1e-9) {
    //                     return false;
    //                 }
    //             } else {
    //                 if (Math.abs(matrix[i][j]) > 1e-9) {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
        
    //     return true; // You were missing this line
    // }

    public static boolean isIdentityMatrix(double[][] matrix){
        for(int i=0; i<matrix.length;i++)
            for(int j=0; j<matrix[i].length;j++){
                if((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) return false;
            }
        return true;
    }

    public static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.4f\t", matrix[i][j]);
            }
            System.out.println();
        }
            System.out.println();
    }

    public static double[][] copyArray(double[][] source) {
        int numRows = source.length;
        int numCols = source[0].length;
        double[][] copy = new double[numRows][numCols];
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                copy[i][j] = source[i][j];
            }
        }
        
        return copy;
    }


}


