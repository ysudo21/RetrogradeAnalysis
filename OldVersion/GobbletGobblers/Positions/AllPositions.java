package GobbletGobblers.Positions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import GobbletGobblers.Field.Field;
import GobbletGobblers.Player.Piece;

public class AllPositions {
    
    private HashMap<Integer,HashSet<Field>> allPositions;

    //コンストラクタ
    public AllPositions(){
        allPositions = new HashMap<>();
    }

    //メソッド
    public void listUpAllPositions(){

        ArrayList<HashSet<Field>> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            list.add(new HashSet<>());
        }

        //白が１個の場合
        for(int i=0;i<27;i++){
            Field field = new Field();
            if(field.setWhite(i) != null){
                field.setWhite(i);
                list.get(0).add(field);
                allPositions.put(1, list.get(0));
            }
            field = null;
        }

        for(int k=0;k<3;k++){
            for(Field order:allPositions.get(k+1)){
                Field preField = new Field(order.getField());
                for(int j=0;j<27;j++){
                    if(preField.search(j) == Piece.None){
                        Field sucField = preField.clone();
                        if(k%2 == 1){
                            if(sucField.setWhite(j) != null){
                                sucField.setWhite(j);
                            };
                        }else{
                            if(sucField.setBlack(j) != null){
                                sucField.setBlack(j);
                            }
                        }
                        list.get(k+1).add(sucField);
                        allPositions.put(k+2,list.get(k+1));
                        sucField = null;
                    }
                }
            }
            System.gc();
        }
    }

    //getter
    public HashMap<Integer,HashSet<Field>> getAllPositions(){
        return this.allPositions;
    }
}
