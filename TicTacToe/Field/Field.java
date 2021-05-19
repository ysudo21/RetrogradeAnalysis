package TicTacToe.Field;

import java.util.Arrays;

import TicTacToe.Player.Piece;

public class Field {
    
    private Piece[][] field = new Piece[3][3];

    //コンストラクタ
    public Field(){
        for(Piece[] value:this.field){
            Arrays.fill(value,Piece.None);
        }
    }

    public Field(Piece[][] field){
        this.field = field;
    }

    //メソッド
    public void resetField(){
        for(Piece[] value:this.field){
            Arrays.fill(value,Piece.None);
        }
    }

    public Piece[][] setMaru(int x,int y){
        this.field[x][y] = Piece.Maru;
        return this.field;
    }

    public Piece[][] setBatsu(int x,int y){
        this.field[x][y] = Piece.Batsu;
        return this.field;
    }

    public Piece search(int x, int y){
        return this.field[x][y];
    }

    //getter
    public Piece[][] getField(){
        return this.field;
    }

    //setter
    public void setField(Piece[][] piece){
        this.field = piece;
    }

    //toString()
    public String toString(){
        String picture = new String();
        for(Piece[] array1:field){
            picture += "\n";
            for(Piece value:array1){
                switch(value){
                    case None:
                    picture += "-";
                    break;

                    case Maru:
                    picture += "O";
                    break;

                    case Batsu:
                    picture += "X";
                    break;
                }
            }
        }
        return picture;
    }

}
