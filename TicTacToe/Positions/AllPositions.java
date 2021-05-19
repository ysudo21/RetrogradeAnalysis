package TicTacToe.Positions;

import java.util.*;

import TicTacToe.Field.Field;
import TicTacToe.Player.Piece;

public class AllPositions{

    private ArrayList<Field> allPositions;

    //コンストラクタ
    public AllPositions(){
        allPositions = new ArrayList<>();
    }

    //メソッド
    public void listUpAllPositions(){

        /*
        ・○をMaru,×をBatsuに置き換えて考える。
        ・先攻を○と固定すれば、交互に手番を行うため9つの場所うち最大でも５個が○、４個が×となる。
        ・○と×の個数に応じて場合分けを行い全局面を算出する。
        */

        //○が１個の場合(9通り)
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Field field = new Field();
                field.setMaru(i, j);
                allPositions.add(field);
            }
        }

        //○が１個、×が１個の場合(上記9通りそれぞれについて8通り)
        for(int i=0;i<allPositions.size();i++){
            Field preField = new Field(allPositions.get(i).getField());
            allPositions.add(preField);
        }
    }

    //getter
    public ArrayList<Field> getAllPositions(){
        return this.allPositions;
    }


}

