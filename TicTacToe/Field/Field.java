package TicTacToe.Field;

import java.util.Arrays;

import TicTacToe.Player.Piece;

public class Field implements Cloneable{
    
    private Piece[] field = new Piece[9];

    //コンストラクタ
    public Field(){
        Arrays.fill(this.field,Piece.None);
    }

    public Field(Piece[] field){
        this.field = field;
    }

    //メソッド
    public Piece[] setMaru(int x){
        this.field[x] = Piece.Maru;
        return this.field;
    }

    public Piece[] setBatsu(int x){
        this.field[x]= Piece.Batsu;
        return this.field;
    }

    public Piece search(int x){
        return this.field[x];
    }

    public boolean isMaruWon(){
        for(int i=0;i<3;i++){
            if(this.search(3*i) == this.search(3*i + 1) && this.search(3*i + 1) == this.search(3*i + 2) && this.search(3*i + 2) == Piece.Maru){
                return true;
            }else if(this.search(i) == this.search(i + 3) && this.search(i + 3) == this.search(i + 6) && this.search(i + 6) == Piece.Maru){
                return true;
            }
        }
        if(this.search(0) == this.search(4) && this.search(4) == this.search(8) && this.search(8) == Piece.Maru){
                return true;
        }
        if(this.search(2) == this.search(4) && this.search(4) == this.search(6) && this.search(6) == Piece.Maru){
            return true;
        }
        return false;
    }

    public boolean isBatsuWon(){
        for(int i=0;i<3;i++){
            if(this.search(3*i) == this.search(3*i + 1) && this.search(3*i + 1) == this.search(3*i + 2) && this.search(3*i + 2) == Piece.Batsu){
                return true;
            }else if(this.search(i) == this.search(i + 3) && this.search(i + 3) == this.search(i + 6) && this.search(i + 6) == Piece.Batsu){
                return true;
            }
        }
        if(this.search(0) == this.search(4) && this.search(4) == this.search(8) && this.search(8) == Piece.Batsu){
                return true;
        }
        if(this.search(2) == this.search(4) && this.search(4) == this.search(6) && this.search(6) == Piece.Batsu){
            return true;
        }
        return false;
    }

    public int countMaru(){
        int count = 0;
        for(int i=0;i<9;i++){
            if(this.field[i] == Piece.Maru){
                count++;
            }
        }
        return count;
    }

    public int countBatsu(){
        int count = 0;
        for(int i=0;i<9;i++){
            if(this.field[i] == Piece.Batsu){
                count++;
            }
        }
        return count;
    }

    public boolean isMaruTurn(){
        return (this.countMaru() == this.countBatsu());
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
        for(int i=0;i<3;i++){
            Piece[] separated = new Piece[3];
            for(int j=0;j<3;j++){
                separated[j] = this.field[3*i+j];
            }
            for(Piece value:separated){
                switch(value){
                    case None:
                    picture += "-";
                    break;

                    case Maru:
                    picture += "O";
                    break;

                    case Batsu:
                    picture += "X";
                    break;
                }
            }
        picture += "\n";
        }
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
