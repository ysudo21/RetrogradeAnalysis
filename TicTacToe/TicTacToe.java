package TicTacToe;

import TicTacToe.Field.Field;
import TicTacToe.Positions.AllPositions;

public class TicTacToe {
    public static void main(String args[]){

        AllPositions positions = new AllPositions();
        positions.listUpAllPositions();
        for(Field test:positions.getAllPositions()){
            System.out.println(test);
        }

    }
}
