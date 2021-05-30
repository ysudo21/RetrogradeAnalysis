package TicTacToe.Positions;

import java.util.HashSet;

import TicTacToe.Field.Field;
import TicTacToe.Player.Piece;

public class BatsuPreviousPositions {
    
    private HashSet<Field> sucField;
    private HashSet<Field> preField;

    //コンストラクタ
    public BatsuPreviousPositions(HashSet<Field> sucField){
        this.sucField = sucField;
        this.preField = new HashSet<>();
    }

    //メソッド
    public void calcPreField(){
        for(Field suc:this.sucField){
            for(int i=0;i<9;i++){
                Field clone = suc.clone();
                Piece[] piece = clone.getField();
                if(piece[i] == Piece.Batsu){
                    piece[i] = Piece.None;
                    Field field = new Field(piece);
                    preField.add(field);
                }
            }
        }
    }

    //getter
    public HashSet<Field> getPreField(){
        return this.preField;
    }
}
