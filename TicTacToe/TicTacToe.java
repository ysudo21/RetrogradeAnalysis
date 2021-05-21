package TicTacToe;

import TicTacToe.Field.Field;
import TicTacToe.Positions.AllPositions;

public class TicTacToe {
    public static void main(String args[]){

        int count = 0;

        AllPositions positions = new AllPositions();
        positions.listUpAllPositions();
        for(Integer key:positions.getAllPositions().keySet()){
            for(Field test:positions.getAllPositions().get(key)){
                System.out.println(test);
                count++;
            }
        }
        System.out.println(count);
    }
}
