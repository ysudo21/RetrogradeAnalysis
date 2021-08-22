package Positions;

import java.util.ArrayList;
import java.util.List;

import Field.Field;

public class AllPositions2 {

    private ArrayList<Long> allPositions;
    private Field field;

    //コンストラクタ
    public AllPositions2(){
        this.allPositions = new ArrayList<>();
        this.field = Field.getInstance();
    }

    //メソッド
    public void listUpAllPositions(){
        long all = (long) Math.pow(3, 27);
        for(long i=0;i<all;i++){
            int[] oneField = field.radixConversionFromTen(i);
            if(field.isAble(oneField)){
                allPositions.add(i);
            }
        }
    }

    //getter
    public ArrayList<Long> getAllPositions(){
        return this.allPositions;
    }
    
}
