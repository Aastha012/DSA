class Solution {
    public boolean isSafe(char[][]board,int row,int col,int number){
        //for row and col
        for(int i=0;i<board.length;i++){//i is both foe row and col
            if(board[i][col]==(char)(number+'0')){
            return false;
        }
        if(board[row][i]==(char)(number+'0')){
            return false;
        }}
        //for grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(number+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][]board,int row,int col){
        if(row==board.length){//base case
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col!=board.length-1){
            nrow=row;
            ncol=col+1;
        }
        else{
            nrow=row+1;
            ncol=0;//means we come in next row
        }
        if(board[row][col]!='.'){//means no is already placed there
        if(helper(board,nrow,ncol)){//here we call the function so we dont use brackets
            return true;
        }

        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=(char)(i+'0');
                if(helper(board,nrow,ncol)){
                    return true;//here we call helper function for new row and col and check that 1 we put is in  correct postion if yes then we return true;
                }
                else{
                    board[row][col]='.';//otherwise we backtrack and remove 1 with blank position 

                }

            }
         }
        return false;
     }
     return false;
    }

     public void solveSudoku(char[][] board) {
        helper(board,0,0);
        
    }
}