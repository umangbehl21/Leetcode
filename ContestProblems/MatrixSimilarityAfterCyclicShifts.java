package ContestProblems;

public class MatrixSimilarityAfterCyclicShifts {
        public boolean areSimilar(int[][] mat, int k) {
            int noofcol = mat[0].length;
            for(int i = 0;i<mat.length;i++)
            {
                for(int j = 0;j<mat[0].length;j++)
                {
                    if(mat[i][j] != mat[i][(j+k) % noofcol])  //comparing current 1d array element with the element which will take the place of current index doing modulo with number of column  to keep index in bounds
                    {
                        return false;
                    }
                }
            }
            return true;
            
        }
    
}
