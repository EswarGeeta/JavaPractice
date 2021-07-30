import java.util.ArrayList;
import java.util.Arrays;

public class WordBoggle {

    static int[][] traversedBoard;
    public static String[] wordBoggle(char[][] board, String[] dictionary) {
        traversedBoard = new int[board.length][board[0].length];
        ArrayList<String> result = new ArrayList<>();
        for(String word: dictionary) {
            System.out.println("going to check for word "+ word);
            if(findWord(word, board)) {
                System.out.println(word);
                result.add(word);
            }


        }
        return result.toArray(new String[result.size()]);
    }

    private static boolean findWord(String word, char[][] board) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(findWordFromThisPos(word, board, i, j))
                    return true;
            }
        }
        return false;
    }

    private static boolean findWordFromThisPos(String word, char[][] board, int i, int j) {
        for(int[] row: traversedBoard)
            Arrays.fill(row, 0);
        return findWithDFS(word, board, i, j);
    }

    private static boolean findWithDFS(String word, char[][] board, int i, int j) {
        if(word.charAt(0) != board[i][j])
            return false;
        if(word.length() == 1) {
            return true;
        } else {
            traversedBoard[i][j] = 1;
            System.out.println(i + " " + j);
            for(int k=i-1; k<=i+1; k++) {
                for(int l=j-1; l<=j+1; l++) {
                    if( k >= 0 && l >= 0 && k < traversedBoard.length && l < traversedBoard[0].length && traversedBoard[k][l] == 0) {
                        boolean result = findWithDFS(word.substring(1), board, k, l);
                        if(result)
                            return result;
                    }
                }
            }
            traversedBoard[i][j] = 0;
            return false;
        }


    }

    public static void main(String[] args) {
//        char board[][] = {{'g','i','z'},{'u','e','k'},{'q','s','e'}};
//        char board[][] = {{'b', 'v', 'h', 'i', 'o', 'f', 'q', 'j', 'y', 'y'},
//                            {'t', 'y', 'v', 'd', 'x', 'j', 'z', 'd' ,'y', 'l'},
//            {       'v', 'e', 'k', 'n', 'w', 'l', 'i', 'w', 'y', 's'},
//                {   'i', 'f', 's' ,'c', 'p' ,'m', 'r', 'j', 'l' ,'x'},
//                    {'l', 'd' ,'h', 'n' ,'u', 'j', 'v' ,'m', 'w', 'y'},
//                        {'n', 'c', 'd' ,'t' ,'t', 'w' ,'k' ,'f' ,'b', 'p'},
//                            {'c', 'l', 'f', 'g' ,'s', 'i', 'f' ,'o' ,'u', 'f'}};
        char[][] board = {{'x'},
                {'a'},
                {'n'},
                {'h'},
                {'t'},
                {'e'},
                {'c'}};
        String[] dictionary = "ceth th h nhtecy nhtecc xan anhtec".split(" ");
        String[] result = wordBoggle(board, dictionary);
        for(String word: result)
            System.out.println(word);
    }
}
