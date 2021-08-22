package Field;

import java.util.Arrays;

public class Field{

    //コンストラクタ(Singleton)
    private Field(){
    }

    public static Field getInstance(){
        return FieldInstanceHolder.INSTANCE;
    }

    public static class FieldInstanceHolder{
        private static final Field INSTANCE = new Field();
    }

    //メソッド

    public int[] create(){
        int[] field = new int[27];
        Arrays.fill(field,0);
        return field;
    }

    public int[] setWhite(int x,int[] field){
        field[x] = 1;
        if(this.isAble(x,field)){
            return field;
        }
        return null;
    }

    public int[] setBlack(int x,int[] field){
        field[x]= 2;
        if(this.isAble(x,field)){
            return field;
        }
        return null;
    }

    public boolean isAble(int x,int[] field){
        if(x>8){
            if(field[x-9] != 0){
                return false;
            }
            if(x>17){
                if(field[x-18] != 0){
                    return false;
                }
                int countWhite = 0;
                int countBlack = 0;
                for(int i=18;i<27;i++){
                    if(field[i] == 1){
                        countWhite++;
                    }else if(field[i] == 2){
                        countBlack++;
                    }
                }
                if(countWhite>2 || countBlack>2){
                    return false;
                }
            }else{
                int countWhite = 0;
                int countBlack = 0;
                for(int i=9;i<18;i++){
                    if(field[i] == 1){
                        countWhite++;
                    }else if(field[i] == 2){
                        countBlack++;
                    }
                }
                if(countWhite>2 || countBlack>2){
                    return false;
                }
            }
        }else{
            int countWhite = 0;
            int countBlack = 0;
            for(int i=0;i<9;i++){
                if(field[i] == 1){
                    countWhite++;
                }else if(field[i] == 2){
                    countBlack++;
                }
            }
            if(countWhite>2 || countBlack>2){
                return false;
            }
        }
        return true;
    }

    public boolean isAble(int[] field){
        int countWhite = 0;
        int countBlack = 0;
        for(int i=0;i<9;i++){
            if(field[i] == 1){
                countWhite++;
            }else if(field[i] == 2){
                countBlack++;
            }
        }
        if(countWhite>2 || countBlack>2){
            return false;
        }else{
            countWhite = 0;
            countBlack = 0;
        }
        for(int i=9;i<18;i++){
            if(field[i] == 1){
                countWhite++;
            }else if(field[i] == 2){
                countBlack++;
            }
        }
        if(countWhite>2 || countBlack>2){
            return false;
        }else{
            countWhite = 0;
            countBlack = 0;
        }
        for(int i=18;i<27;i++){
            if(field[i] == 1){
                countWhite++;
            }else if(field[i] == 2){
                countBlack++;
            }
        }
        if(countWhite>2 || countBlack>2){
            return false;
        }else{
            countWhite = 0;
            countBlack = 0;
        }
        return true;
    }

    public int search(int x,int[] field){
        return field[x];
    }

    public int[] toTicTacToe(int[] field){ 
        int[] tictactoe = new int[9];
        for(int i=0;i<9;i++){
            if(field[i] != 0){
                tictactoe[i] = field[i];
            }else if(field[i+9] != 0){
                tictactoe[i] = field[i+9];
            }else if(field[i+18] != 0){
                tictactoe[i] = field[i+18];
            }else{
                tictactoe[i] = 0;
            }
        }
        return tictactoe;
    }

    public boolean isWhiteWon(int[] field){
        int[] tictactoe = this.toTicTacToe(field);
        for(int i=0;i<3;i++){
            if(search(3*i,tictactoe) == search(3*i + 1,tictactoe) && search(3*i + 1,tictactoe) == search(3*i + 2,tictactoe) && search(3*i + 2,tictactoe) == 1){
                return true;
            }else if(search(i,tictactoe) == search(i + 3,tictactoe) && search(i + 3,tictactoe) == search(i + 6,tictactoe) && search(i + 6,tictactoe) == 1){
                return true;
            }
        }
        if(search(0,tictactoe) == search(4,tictactoe) && search(4,tictactoe) == search(8,tictactoe) && search(8,tictactoe) == 1){
                return true;
        }
        if(search(2,tictactoe) == search(4,tictactoe) && search(4,tictactoe) == search(6,tictactoe) && search(6,tictactoe) == 1){
            return true;
        }
        return false;
    }

    public boolean isBlackWon(int[] field){
        int[] tictactoe = this.toTicTacToe(field);
        for(int i=0;i<3;i++){
            if(search(3*i,tictactoe) == search(3*i + 1,tictactoe) && search(3*i + 1,tictactoe) == search(3*i + 2,tictactoe) && search(3*i + 2,tictactoe) == 2){
                return true;
            }else if(search(i,tictactoe) == search(i + 3,tictactoe) && search(i + 3,tictactoe) == search(i + 6,tictactoe) && search(i + 6,tictactoe) == 2){
                return true;
            }
        }
        if(search(0,tictactoe) == search(4,tictactoe) && search(4,tictactoe) == search(8,tictactoe) && search(8,tictactoe) == 2){
                return true;
        }
        if(search(2,tictactoe) == search(4,tictactoe) && search(4,tictactoe) == search(6,tictactoe) && search(6,tictactoe) == 2){
            return true;
        }
        return false;
    }

    public int[] radixConversionFromTen(long x){

        String word = Long.toString(x,3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);
        while(stringBuilder.length() != 27){
            stringBuilder.insert(0,"0");
        }
        int[] intArray = new int[stringBuilder.length()];
        
        for (int i = 0; i < stringBuilder.length(); i++) {

            String str = String.valueOf(stringBuilder.charAt(i));

            intArray[i] = Integer.parseInt(str);
        }

        return intArray;
    }

    public long radixConversionToTen(int[] x){
        String from = "";
        for(int a:x){
            from += Long.toString(a);
        }
        return Long.parseLong(from,3);
    }

    //toString()
    public String toString(int[] field){
        String picture = new String();
        for(int k=0;k<3;k++){
            for(int i=0;i<3;i++){
                int[] separated = new int[3];
                for(int j=0;j<3;j++){
                    separated[j] = field[9*k+3*i+j];
                }
                for(int value:separated){
                    switch(value){
                        case 0:
                        picture += "-";
                        break;

                        case 1:
                        picture += "O";
                        break;

                        case 2:
                        picture += "X";
                        break;
                    }
                }
            picture += "\n";
            }
            picture += "\n";
        }
        picture += "―――――――――";
        return picture;
    }
}


