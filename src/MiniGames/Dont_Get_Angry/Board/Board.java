package MiniGames.Dont_Get_Angry.Board;

import java.util.Map;

public class Board
{
    private Field[] fieldMap = new Field[70];

//    public MapBoard(Map<Integer, Field> board)
//    {
//        this.board = board;
//    }


    public Field[] getFieldMap()
    {
        return fieldMap;
    }

    public Board setFieldMap(Field[] fieldMap)
    {
        this.fieldMap = fieldMap;
        return this;
    }
}
