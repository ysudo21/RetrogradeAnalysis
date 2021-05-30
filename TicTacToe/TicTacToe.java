package TicTacToe;

import TicTacToe.Field.Field;
import TicTacToe.Positions.AllPositions;
import TicTacToe.Positions.BatsuLosedPositions;
import TicTacToe.Positions.BatsuPreviousPositions;
import TicTacToe.Positions.MaruPreviousPositions;

public class TicTacToe {
    public static void main(String args[]){

        int count = 0;

        BatsuLosedPositions positions = new BatsuLosedPositions();
        MaruPreviousPositions prePositions = new MaruPreviousPositions(positions.getBatsuLosedPositions());
        prePositions.calcPreField();
        BatsuPreviousPositions bPositions = new BatsuPreviousPositions(prePositions.getPreField());
        bPositions.calcPreField();
        for(Field field:bPositions.getPreField()){
            System.out.println(field);
            count++;
        }
        System.out.println(count);
    }
}
