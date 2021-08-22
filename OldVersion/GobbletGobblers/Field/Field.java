package GobbletGobblers.Field;

import java.util.Arrays;

import GobbletGobblers.Player.*;

public class Field implements Cloneable{
    
    private Piece[] field;

    //コンストラクタ
    public Field(){
        field = new Piece[27];
        Arrays.fill(this.field,Piece.None);
    }

    public Field(Piece[] field){
        this.field = field;
    }

    //メソッド
    public Piece[] setWhite(int x){
        this.field[x] = Piece.White;
        if(this.isAble(x)){
            return this.field;
        }
        return null;
    }

    public Piece[] setBlack(int x){
        this.field[x]= Piece.Black;
        if(this.isAble(x)){
            return this.field;
        }
        return null;
    }

    public boolean isAble(int x){
        if(x>8){
            if(this.field[x-9] != Piece.None){
                return false;
            }
            if(x>17){
                int countWhite = 0;
                int countBlack = 0;
                for(int i=18;i<27;i++){
                    if(this.field[i] == Piece.White){
                        countWhite++;
                    }else if(this.field[i] == Piece.Black){
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
                    if(this.field[i] == Piece.White){
                        countWhite++;
                    }else if(this.field[i] == Piece.Black){
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
                if(this.field[i] == Piece.White){
                    countWhite++;
                }else if(this.field[i] == Piece.Black){
                    countBlack++;
                }
            }
            if(countWhite>2 || countBlack>2){
                return false;
            }
        }
        return true;
    }

    public Piece search(int x){
        return this.field[x];
    }

    public Piece[] toTicTacToe(){
        Piece[] piece = this.getField(); 
        Piece[] tictactoe = new Piece[9];
        for(int i=0;i<9;i++){
            if(piece[i] != Piece.None){
                tictactoe[i] = piece[i];
            }else if(piece[i+9] != Piece.None){
                tictactoe[i] = piece[i+9];
            }else if(piece[i+18] != Piece.None){
                tictactoe[i] = piece[i+18];
            }else{
                tictactoe[i] = Piece.None;
            }
        }
        return tictactoe;
    }

    public boolean isWhiteWon(){
        Field tField = new Field(this.toTicTacToe());
        for(int i=0;i<3;i++){
            if(tField.search(3*i) == tField.search(3*i + 1) && tField.search(3*i + 1) == tField.search(3*i + 2) && tField.search(3*i + 2) == Piece.White){
                return true;
            }else if(tField.search(i) == tField.search(i + 3) && tField.search(i + 3) == tField.search(i + 6) && tField.search(i + 6) == Piece.White){
                return true;
            }
        }
        if(tField.search(0) == tField.search(4) && tField.search(4) == tField.search(8) && tField.search(8) == Piece.White){
                return true;
        }
        if(tField.search(2) == tField.search(4) && tField.search(4) == tField.search(6) && tField.search(6) == Piece.White){
            return true;
        }
        return false;
    }

    public boolean isBlackWon(){
        Field tField = new Field(this.toTicTacToe());
        for(int i=0;i<3;i++){
            if(tField.search(3*i) == tField.search(3*i + 1) && tField.search(3*i + 1) == tField.search(3*i + 2) && tField.search(3*i + 2) == Piece.Black){
                return true;
            }else if(tField.search(i) == tField.search(i + 3) && tField.search(i + 3) == tField.search(i + 6) && tField.search(i + 6) == Piece.Black){
                return true;
            }
        }
        if(tField.search(0) == tField.search(4) && tField.search(4) == tField.search(8) && tField.search(8) == Piece.Black){
                return true;
        }
        if(tField.search(2) == tField.search(4) && tField.search(4) == tField.search(6) && tField.search(6) == Piece.Black){
            return true;
        }
        return false;
    }

    //getter
    public Piece[] getField(){
        return this.field;
    }

    //setter
    public void setField(Piece[] piece){
        this.field = piece;
    }

    //toString()
    public String toString(){
        String picture = new String();
        for(int k=0;k<3;k++){
            for(int i=0;i<3;i++){
                Piece[] separated = new Piece[3];
                for(int j=0;j<3;j++){
                    separated[j] = this.field[9*k+3*i+j];
                }
                for(Piece value:separated){
                    switch(value){
                        case None:
                        picture += "-";
                        break;

                        case White:
                        picture += "O";
                        break;

                        case Black:
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

    //clone()
    @Override
    public Field clone(){
        Field newField = null;
        try{
            newField = (Field)super.clone();
            newField.field=this.field.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return newField;
    }

    //equals()
    public boolean equals(Object opponent){
        Field opField = (Field)opponent;
        return (Arrays.equals(this.field, opField.getField()));
    }

    //hashCode()
    public int hashCode(){
        int result = 17;

        for(int i=0;i<9;i++){
            result *= 31;
            result += this.field[i].hashCode();
        }

        return result;
    }
}

