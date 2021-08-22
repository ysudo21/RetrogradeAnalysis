package Positions.MaruLosed;

import java.util.HashSet;

import Field.Field;
import Player.Piece;

public class MaruInspection {
    
    private HashSet<Field> sucField;
    private HashSet<Field> preField;
    private HashSet<Field> field;

    //コンストラクタ
    public MaruInspection(HashSet<Field> preField,HashSet<Field> sucField){
        this.preField = preField;
        this.sucField = sucField;
        this.field = new HashSet<>();
    }

    //メソッド
    public void maruInspection(){
        HashSet<Field> inspectedMaruPreviousPositions = new HashSet<>();
        for(Field field:this.preField){
            int count = 0;
            int counter = 0;
            for(int i=0;i<9;i++){
                Field clone = field.clone();
                if(clone.getField()[i] == Piece.None){
                    count++;
                    clone.setMaru(i);
                    if(sucField.contains(clone)){
                        counter++;
                    }
                }
            }
            if(count == counter){
                inspectedMaruPreviousPositions.add(field);
            }
        }
        this.field = inspectedMaruPreviousPositions;
    }

    //getter
    public HashSet<Field> getField(){
        return this.field;
    }
}
