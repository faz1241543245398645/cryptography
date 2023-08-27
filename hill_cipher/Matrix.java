/**
 *
 * @author Takumi
 */
public class Matrix {
    private final int[][] A;
    
    public Matrix(int n){
        A = new int[n][n];
    }
    public Matrix(int r, int c){
        A = new int[r][c];
    }
    public Matrix(int[][] B){
        A = B.clone();
    }
    public Matrix(int[][] B, int n){
        A = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = B[i][j];
            }
        }
    }
    
    public int get(int r, int c){
        return A[r][c];
    }
    public void set(int r, int c, int val){
        A[r][c] = val;
    }
    
    public int getRowDim(){
        return A.length;
    }
    public int getColDim(){
        return A[0].length;
    }
    
    public Matrix times(Matrix B){
        int[][] C = new int[A.length][B.getColDim()];
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.getColDim(); j++){
                for(int k = 0; k < A[0].length; k++){
                    C[i][j] += A[i][k] * B.get(k, j);
                }
            }
        }
        return new Matrix(C);
    }
    
    public Matrix times(int b){
        int[][] C = new int[A.length][A[0].length];
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                C[i][j] = A[i][j] * b;
            }
        }
        return new Matrix(C);
    }

    private Matrix cofact(int p, int q, int n){
        Matrix C = new Matrix(n-1);
        int r = 0, c = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != p && j != q){
                    C.set(r, c++, A[i][j]);
                    if(c == n - 1){
                        c = 0;
                        r++;
                    }
                }
            }
        }
        return C;
    }
 
    public int det(){
        int n = A.length; 
        if(n == 1){
            return A[0][0];            
        } 
        int d = 0;

        for(int j = 0; j < n; j++){
            int sign = (j % 2 == 0)? 1 : -1;
            Matrix C = cofact(0, j, n);
            d += A[0][j] * sign * C.det();
        }
        return d;
    }
    
    public Matrix adj(){
        int n = A.length;
        Matrix Adj = new Matrix(n);
        
        if(n == 1){
            Adj.set(0, 0, 1);
            return Adj;
        }
 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sign = ((i+j) % 2 == 0)? 1 : -1;
                Matrix C = cofact(i, j, n);
                Adj.set(j, i, sign * C.det());
            }
        }
        return Adj;
    }    
}