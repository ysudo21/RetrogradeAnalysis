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
    public void resetField(){
        Arrays.fill(this.field,Piece.None);
    }

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
