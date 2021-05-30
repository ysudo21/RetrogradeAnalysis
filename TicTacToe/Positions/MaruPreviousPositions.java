package TicTacToe.Positions;

import java.util.HashSet;

import TicTacToe.Field.Field;
import TicTacToe.Player.Piece;

public class MaruPreviousPositions {
    
    private HashSet<Field> sucField;
    private HashSet<Field> preField;

    //コンストラクタ
    public MaruPreviousPositions(HashSet<Field> sucField){
        this.sucField = sucField;
        this.preField = new HashSet<>();
    }

    //メソッド
    public void calcPreField(){
        for(Field suc:this.sucField){
            for(int i=0;i<9;i++){
                Field clone = suc.clone();
                Piece[] piece = clone.getField();
                if(piece[i] == Piece.Maru){
                    piece[i] = Piece.None;
                    Field field = new Field(piece);
                    if(!(field.isMaruWon()) && field.isMaruTurn()){
                        preField.add(field);
                    }
                }
            }
        }
    }

    //getter
    public HashSet<Field> getPreField(){
        return this.preField;
    }

}
