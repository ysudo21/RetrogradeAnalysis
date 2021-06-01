package TicTacToe.Positions.BatsuLosed;

import java.util.HashSet;

import TicTacToe.Field.Field;
import TicTacToe.Player.Piece;

public class BatsuInspection {
    
    private HashSet<Field> sucField;
    private HashSet<Field> preField;
    private HashSet<Field> field;

    //コンストラクタ
    public BatsuInspection(HashSet<Field> preField,HashSet<Field> sucField){
        this.preField = preField;
        this.sucField = sucField;
        this.field = new HashSet<>();
    }

    //メソッド
    public void batsuInspection(){
        HashSet<Field> inspectedBatsuPreviousPositions = new HashSet<>();
        for(Field field:this.preField){
            int count = 0;
            int counter = 0;
            for(int i=0;i<9;i++){
                Field clone = field.clone();
                if(clone.getField()[i] == Piece.None){
                    count++;
                    clone.setBatsu(i);
                    if(sucField.contains(clone)){
                        counter++;
                    }
                }
            }
            if(count == counter){
                inspectedBatsuPreviousPositions.add(field);
            }
        }
        this.field = inspectedBatsuPreviousPositions;
    }

    //getter
    public HashSet<Field> getField(){
        return this.field;
    }
}
