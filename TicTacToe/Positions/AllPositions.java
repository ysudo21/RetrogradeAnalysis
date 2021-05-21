package TicTacToe.Positions;

import java.util.*;

import TicTacToe.Field.Field;
import TicTacToe.Player.Piece;

public class AllPositions{

    private HashMap<Integer,HashSet<Field>> allPositions;

    //コンストラクタ
    public AllPositions(){
        allPositions = new HashMap<>();
    }

    //メソッド
    public void listUpAllPositions(){

        /*
        ・○をMaru,×をBatsuに置き換えて考える。
        ・先攻を○と固定すれば、交互に手番を行うため9つの場所うち最大でも５個が○、４個が×となる。
        ・○と×の個数に応じて場合分けを行い全局面を算出する。
        */

        ArrayList<HashSet<Field>> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(new HashSet<>());
        }

        //○が１個の場合(9通り)
        for(int i=0;i<9;i++){
            Field field = new Field();
            field.setMaru(i);
            list.get(0).add(field);
            allPositions.put(1, list.get(0));
        }

        for(int k=0;k<8;k++){
            for(Field order:allPositions.get(k+1)){
                Field preField = new Field(order.getField());
                for(int j=0;j<9;j++){
                    if(preField.search(j) == Piece.None){
                        Field sucField = preField.clone();
                        if(k%2 == 1){
                            sucField.setMaru(j);
                        }else{
                            sucField.setBatsu(j);
                        }
                        list.get(k+1).add(sucField);
                        allPositions.put(k+2,list.get(k+1));
                    }
                }
            }
        }

    }

    //getter
    public HashMap<Integer,HashSet<Field>> getAllPositions(){
        return this.allPositions;
    }


}

