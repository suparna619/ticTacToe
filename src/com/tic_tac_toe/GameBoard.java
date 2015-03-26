package com.tic_tac_toe;

public class GameBoard {
    private int numOfRow = 3;
    private int numOfColumn = 3;
    private String[][] board = new String[numOfColumn][numOfRow];



    public void printBoard(int x, int y, String playerSymbol, String playerName){

        ifWrongPosition(x, y);

        ifPositionRepeated(x, y);
        board[x][y] = playerSymbol;

        ifPlayerIsAWinner(playerSymbol, playerName);

        for (int i = 0; i < numOfColumn; i++){
            for (int j = 0; j < numOfRow; j++){
                if(board[i][j] != null)
                    System.out.print("  "+board[i][j]+"  ");
                else System.out.print("  -  ");
            }
            System.out.println(System.lineSeparator());
        }

    }


    private void ifPlayerIsAWinner(String playerSymbol, String playerName) {
        if(checkConditionToWin(playerSymbol)){
            System.out.println("***Congratulation "+playerName+" wines***");
            System.out.println("  ---Run the app to play again---");
            System.exit(1);
        }
    }


    private void ifPositionRepeated(int x, int y) {
        if (board[x][y] != null){
            System.out.println("Position Repeated - Run the app to play again");
            System.exit(1);
        }
    }


    private void ifWrongPosition(int x, int y) {
        if (x>numOfRow-1 || y>numOfColumn-1) {
            System.out.println("Wrong position - Run the app to play again");
            System.exit(1);
        }
    }

    private boolean checkConditionToWin(String playerSymbol) {
        if(checkForRow(playerSymbol)
                || checkForColumn(playerSymbol) || checkForDiagonal(playerSymbol))
            return true;
        return false;
    }

    private boolean checkForDiagonal(String playerSymbol) {
        if ((board[0][0]==playerSymbol && board[1][1]==playerSymbol && board[2][2]==playerSymbol) ||
                (board[0][2]==playerSymbol && board[1][1]==playerSymbol && board[2][0]==playerSymbol))
            return true;
        return false;
    }

    private boolean checkForColumn(String playerSymbol) {
        if ((board[0][0]==playerSymbol && board[1][0]==playerSymbol && board[2][0]==playerSymbol) ||
                (board[0][1]==playerSymbol && board[1][1]==playerSymbol && board[2][1]==playerSymbol) ||
                (board[0][2]==playerSymbol && board[1][2]==playerSymbol && board[2][2]==playerSymbol))
            return true;
        return false;
    }

    private boolean checkForRow(String playerSymbol) {
        if ((board[0][0]==playerSymbol && board[0][1]==playerSymbol && board[0][2]==playerSymbol) ||
                (board[1][0]==playerSymbol && board[1][1]==playerSymbol && board[1][2]==playerSymbol) ||
                (board[2][0]==playerSymbol && board[2][1]==playerSymbol && board[2][2]==playerSymbol))
            return true;
        return false;
    }

}
