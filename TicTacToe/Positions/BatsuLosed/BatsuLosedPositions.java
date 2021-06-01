package TicTacToe.Positions.BatsuLosed;

import java.util.HashSet;

import TicTacToe.Field.Field;
import TicTacToe.Positions.AllPositions;

public class BatsuLosedPositions {
    
    private HashSet<Field> batsuLosedPositions;

    //コンストラクタ
    public BatsuLosedPositions(){

        batsuLosedPositions = new HashSet<>();

        AllPositions allPositions = new AllPositions();
        allPositions.listUpAllPositions();
        for(Integer key:allPositions.getAllPositions().keySet()){
            for(Field field:allPositions.getAllPositions().get(key)){
                if(field.isMaruWon() && !(field.isBatsuWon()) && !(field.isMaruTurn())){
                    batsuLosedPositions.add(field);
                }
            }
        }
    }

    //getter
    public HashSet<Field> getBatsuLosedPositions(){
        return this.batsuLosedPositions;
    }
}
