public class q12 {
    char[][] board;
    boolean[][] isSearched;
    String word;

    public static void main(String[] args) {
        char[][] board= {
                {'A', 'B','C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word="ABCEFSADEESE";

        System.out.println(new q12().exist(board,word));  //由于main方法为静态方法，想调用非静态方法，必须构造一个对象，然后再调用
    }

    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 ) return false;
        this.board=board;
        this.isSearched=new boolean[board.length][board[0].length];
        this.word=word;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(search(i,j,0)==true){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(int i, int j,int charK){
        if(charK==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(isSearched[i][j]==true) return false;

        if(board[i][j]==word.charAt(charK)){
            isSearched[i][j]=true;
            if(search(i,j+1,charK+1)==false){
                if(search(i+1,j,charK+1)==false){
                    if(search(i,j-1,charK+1)==false){
                        if(search(i-1,j,charK+1)==false){
                            isSearched[i][j]=false;
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
