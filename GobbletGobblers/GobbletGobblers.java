

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import Field.Field;
import Positions.AllPositions;
import Positions.AllPositions2;
import Positions.AllPositions3;

public class GobbletGobblers {
    public static void main(String args[]){

        
        //Pieceに関して、0→None, 1→White, 2→Blackとする。
        //FieldオブジェクトをSingletonで作成し、定期的にガベージコレクションを実施。
        Field field = Field.getInstance();



        AllPositions3 allPositions = new AllPositions3();
        allPositions.listUpAllPositions();
        int count = 0;
        for(long set:allPositions.getAllPositions()){
            // for(long e:set){
            //     // System.out.println(e);
            //     // System.out.println(Arrays.toString(field.radixConversionFromTen(e)));
            //     count++;
            // }
            count++;
        }
        System.out.println(count);
        
        
    }
}
