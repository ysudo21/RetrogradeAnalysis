package Positions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import Field.Field;

public class AllPositions {
    
    private HashMap<Integer,HashSet<Long>> allPositions;
    private Field field;

    //コンストラクタ
    public AllPositions(){
        this.allPositions = new HashMap<>();
        this.field = Field.getInstance();
    }

    //メソッド
    public void listUpAllPositions(){

        ArrayList<HashSet<Long>> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            list.add(new HashSet<>());
        }

        //白が１個の場合
        for(int i=0;i<27;i++){
            int[] blankField = new int[27];
            if(field.setWhite(i,blankField) != null){
                int[] newField = field.setWhite(i,blankField);
                list.get(0).add(field.radixConversionToTen(newField));
                allPositions.put(0, list.get(0));
            }
        }

        for(int k=0;k<3;k++){
            for(long order:allPositions.get(k)){
                int[] preField = field.radixConversionFromTen(order);
                for(int j=0;j<27;j++){
                    if(field.search(j,preField) == 0){
                        int[] sucField = preField.clone();
                        if(k%2 == 1){
                            if(field.setWhite(j,sucField) != null){
                                sucField = field.setWhite(j,sucField);
                            };
                        }else{
                            if(field.setBlack(j,sucField) != null){
                                sucField = field.setBlack(j, sucField);
                            }
                        }
                        list.get(k+1).add(field.radixConversionToTen(sucField));
                        allPositions.put(k+1,list.get(k+1));
                    }
                }
            }
            System.gc();
        }
    }

    //getter
    public HashMap<Integer,HashSet<Long>> getAllPositions(){
        return this.allPositions;
    }
}