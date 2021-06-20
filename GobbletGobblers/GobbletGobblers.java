package GobbletGobblers;

import java.util.HashSet;

import GobbletGobblers.Field.Field;
import GobbletGobblers.Positions.*;

public class GobbletGobblers {
    public static void main(String args[]){
        AllPositions allPositions = new AllPositions();
        allPositions.listUpAllPositions();
        int count = 0;
        for(HashSet<Field> set:allPositions.getAllPositions().values()){
            for(Field e:set){
                System.out.println(e);
                count++;
            }
        }
        System.out.println(count);
    }
}
