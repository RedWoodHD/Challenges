package MiniGames.Dont_Get_Angry.Factory;

import MiniGames.Dont_Get_Angry.Board.Field;
import MiniGames.Dont_Get_Angry.Definition.Type;

public class FieldFactory
{
    public static Field[] createAllFields()
    {
        Field[] allFields = new Field[72];
        // Spawn Felder
        allFields[0] = new Field(Type.SPAWN);     // SpawnRed 1
        allFields[1] = new Field(Type.SPAWN);     // SpawnRed 2
        allFields[6] = new Field(Type.SPAWN);     // SpawnRed 7
        allFields[7] = new Field(Type.SPAWN);     // SpawnRed 8

        allFields[4] = new Field(Type.SPAWN);    // SpawnBlue 5
        allFields[5] = new Field(Type.SPAWN);    // SpawnBlue 6
        allFields[11] = new Field(Type.SPAWN);   // SpawnBlue 12
        allFields[12] = new Field(Type.SPAWN);   // SpawnBlue 13

        allFields[57] = new Field(Type.SPAWN);  // SpawnGreen 58
        allFields[58] = new Field(Type.SPAWN);  // SpawnGreen 59
        allFields[64] = new Field(Type.SPAWN);  // SpawnGreen 65
        allFields[65] = new Field(Type.SPAWN);  // SpawnGreen 66

        allFields[62] = new Field(Type.SPAWN); // SpawnYellow 63
        allFields[63] = new Field(Type.SPAWN); // SpawnYellow 64
        allFields[69] = new Field(Type.SPAWN); // SpawnYellow 70
        allFields[70] = new Field(Type.SPAWN); // SpawnYellow 71

        // Protected Felder
        allFields[19] = new Field(Type.PROTECTET);     // ProtectedRed 20
        allFields[3] = new Field(Type.PROTECTET);    // ProtectedBlue 4
        allFields[50] = new Field(Type.PROTECTET); // ProtectedYellow 51
        allFields[66] = new Field(Type.PROTECTET);  // ProtectedGreen 67

        // Finish Felder
        allFields[31] = new Field(Type.FINISH);    // FinishRed 32
        allFields[32] = new Field(Type.FINISH);    // FinishRed 33
        allFields[33] = new Field(Type.FINISH);    // FinishRed 34
        allFields[34] = new Field(Type.FINISH);    // FinishRed 35

        allFields[9] = new Field(Type.FINISH);   // FinishBlue 10
        allFields[14] = new Field(Type.FINISH);  // FinishBlue 15
        allFields[17] = new Field(Type.FINISH);  // FinishBlue 18
        allFields[24] = new Field(Type.FINISH);  // FinishBlue 25

        allFields[35] = new Field(Type.FINISH); // FinishYellow 36
        allFields[36] = new Field(Type.FINISH); // FinishYellow 37
        allFields[37] = new Field(Type.FINISH); // FinishYellow 38
        allFields[38] = new Field(Type.FINISH); // FinishYellow 39

        allFields[45] = new Field(Type.FINISH);  // FinishGreen 46
        allFields[52] = new Field(Type.FINISH);  // FinishGreen 53
        allFields[55] = new Field(Type.FINISH);  // FinishGreen 56
        allFields[60] = new Field(Type.FINISH);  // FinishGreen 61

        // Der Rest sind Regular Felder
        for (int i = 0; i < 72; i++) {
            if (allFields[i] == null) {  // Wenn das Feld noch nicht zugewiesen wurde
                allFields[i] = new Field(Type.REGULAR);
            }
        }

        return allFields;
    }
}
