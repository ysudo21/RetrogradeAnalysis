

import Field.Field;
import Positions.BatsuPreviousPositions;
import Positions.MaruPreviousPositions;
import Positions.BatsuLosed.BatsuInspection;
import Positions.BatsuLosed.BatsuLosedPositions;
import Positions.MaruLosed.MaruInspection;
import Positions.MaruLosed.MaruLosedPositions;

public class TicTacToe {
    public static void main(String args[]){

        int countBatsuLosed = 0;
        int countMaruLosed = 0;

        //○が勝利すると仮定した場合

        //1周目
        BatsuLosedPositions positions = new BatsuLosedPositions();
        MaruPreviousPositions prePositions = new MaruPreviousPositions(positions.getBatsuLosedPositions());
        prePositions.calcPreField();
        BatsuPreviousPositions bPositions = new BatsuPreviousPositions(prePositions.getPreField());
        bPositions.calcPreField();
        BatsuInspection inspection = new BatsuInspection(bPositions.getPreField(), prePositions.getPreField());
        inspection.batsuInspection();

        //2周目
        MaruPreviousPositions pre2Positions = new MaruPreviousPositions(inspection.getField());
        pre2Positions.calcPreField();
        BatsuPreviousPositions b2Positions = new BatsuPreviousPositions(pre2Positions.getPreField());
        b2Positions.calcPreField();
        BatsuInspection inspection2 = new BatsuInspection(b2Positions.getPreField(), pre2Positions.getPreField());
        inspection2.batsuInspection();

        //3周目
        MaruPreviousPositions pre3Positions = new MaruPreviousPositions(inspection2.getField());
        pre3Positions.calcPreField();

        // for(Field field:pre3Positions.getPreField()){
        //     System.out.println(field);
        //     countBatsuLosed++;
        // }
        // System.out.println(countBatsuLosed);

        /*以上の結果から、
         *先手が中央に打った場合、後手は角に打たなければ負け
         *先手が正方形の中点または角に打った場合、後手は中央または角に打たなければ負け
         *ということがわかる。
         *すなわち、後手は初手で中央＞角＞＞＞正方形の中点の順で打つのが良い*/

        BatsuPreviousPositions b3Positions = new BatsuPreviousPositions(pre3Positions.getPreField());
        b3Positions.calcPreField();
        BatsuInspection inspection3 = new BatsuInspection(b3Positions.getPreField(), pre3Positions.getPreField());
        inspection3.batsuInspection(); 

        for(Field field:inspection3.getField()){
            System.out.println(field);
            countBatsuLosed++;
        }
        System.out.println(countBatsuLosed);

        //この時点で局面の数が0になるため、×側は最善を尽くせば○の勝利を阻止可能と判明



        //×が勝利すると仮定した場合

        //1周目
        MaruLosedPositions mPositions = new MaruLosedPositions();
        BatsuPreviousPositions bPreviousPositions = new BatsuPreviousPositions(mPositions.getMaruLosedPositions());
        bPreviousPositions.calcPreField();
        MaruPreviousPositions mPreviousPositions = new MaruPreviousPositions(bPreviousPositions.getPreField());
        mPreviousPositions.calcPreField();
        MaruInspection mInspection = new MaruInspection(mPreviousPositions.getPreField(),bPreviousPositions.getPreField());
        mInspection.maruInspection();

        //2周目
        BatsuPreviousPositions bPreviousPositions2 = new BatsuPreviousPositions(mInspection.getField());
        bPreviousPositions2.calcPreField();
        MaruPreviousPositions mPreviousPositions2 = new MaruPreviousPositions(bPreviousPositions2.getPreField());
        mPreviousPositions2.calcPreField();
        MaruInspection mInspection2 = new MaruInspection(mPreviousPositions2.getPreField(), bPreviousPositions2.getPreField());
        mInspection2.maruInspection();

        //3周目
        BatsuPreviousPositions bPreviousPositions3 = new BatsuPreviousPositions(mInspection2.getField());
        bPreviousPositions3.calcPreField();

        // for(Field field:bPreviousPositions3.getPreField()){
        //     System.out.println(field);
        //     countMaruLosed++;
        // }
        // System.out.println(countMaruLosed);

        /*以上の結果から、
         *先手が正方形の辺の中点をはさむように打ってきた場合のみ、
         *後手は二手目で中央または先手の隣の辺の中点に打っていれば勝ちが確定するということがわかる。
         *しかしながら、後手は初手で正方形の中点に打つと負けが確定するため、中央をとるしかない。
         *中央がとれなかった場合、角をとって引き分けに持ち込むしかない。*/

        MaruPreviousPositions mPreviousPositions3 = new MaruPreviousPositions(bPreviousPositions3.getPreField());
        mPreviousPositions3.calcPreField();
        MaruInspection mInspection3 = new MaruInspection(mPreviousPositions3.getPreField(), bPreviousPositions3.getPreField());
        mInspection3.maruInspection();

        for(Field field:mInspection3.getField()){
            System.out.println(field);
            countMaruLosed++;
        }
        System.out.println(countMaruLosed);

        //この時点で局面の数が0になるため、○側は最善を尽くせば×の勝利を阻止可能と判明



        /*以上の結果から、
        　双方が最善手を取り続けた場合、お互いに勝ちを確定させることはできない。
        　ゆえに、○×ゲームの完全解析の結果は「引き分け」であるとわかる。*/


    }
}
