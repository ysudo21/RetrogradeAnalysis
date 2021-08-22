package Positions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Field.Field;

public class AllPositions3 {

    private ArrayList<Long> allPositions;
    private Field field;

    //コンストラクタ
    public AllPositions3(){
        this.allPositions = new ArrayList<>();
        this.field = Field.getInstance();
    }

    //メソッド
    public void listUpAllPositions(){

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Collection<Callable<Void>> processes = new LinkedList<>();

        long all = (long) Math.pow(3, 27);
        for(long i=0;i<all;i++){

            final long k = i;

            processes.add(new Callable<Void>(){
                @Override
                public Void call(){
                    int[] oneField = field.radixConversionFromTen(k);
                    if(field.isAble(oneField)){
                        allPositions.add(k);
                    }
                    return null;
                }
            });
        }

        try{
            threadPool.invokeAll(processes);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }finally{
            threadPool.shutdown();
        }
    }

    //getter
    public ArrayList<Long> getAllPositions(){
        return this.allPositions;
    }
    
}

