package Positions.MaruLosed;

import java.util.HashSet;

import Field.Field;
import Positions.AllPositions;

public class MaruLosedPositions {
    
    private HashSet<Field> maruLosedPositions;

    //コンストラクタ
    public MaruLosedPositions(){

        maruLosedPositions = new HashSet<>();

        AllPositions allPositions = new AllPositions();
        allPositions.listUpAllPositions();
        for(Integer key:allPositions.getAllPositions().keySet()){
            for(Field field:allPositions.getAllPositions().get(key)){
                if(field.isBatsuWon() && !(field.isMaruWon()) && (field.isMaruTurn())){
                    maruLosedPositions.add(field);
                }
            }
        }
    }

    //getter
    public HashSet<Field> getMaruLosedPositions(){
        return this.maruLosedPositions;
    }
}
