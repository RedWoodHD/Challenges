package MiniGames.Dont_Get_Angry.Factory;

import MiniGames.Dont_Get_Angry.Board.Field;

/**
 * Diese Klasse ist dafür da eine Methode zu bieten die alle {@link Field Spielfelder} erstellt.
 * @author EGA
 */
public class FieldFactory
{
    /**
     * Diese Methode erstellt alle nötigen {@link Field Spielfelder} (0-71).
     * @return Ein {@link Field Spielfelder[]} array.
     * @author EGA
     */
    public static Field[] createAllFields()
    {
        Field[] allFields = new Field[72];
        // Spawn Felder
        allFields[0] = new Field();     // SpawnRed 1
        allFields[1] = new Field();     // SpawnRed 2
        allFields[6] = new Field();     // SpawnRed 7
        allFields[7] = new Field();     // SpawnRed 8

        allFields[4] = new Field();    // SpawnBlue 5
        allFields[5] = new Field();    // SpawnBlue 6
        allFields[11] = new Field();   // SpawnBlue 12
        allFields[12] = new Field();   // SpawnBlue 13

        allFields[57] = new Field();  // SpawnGreen 58
        allFields[58] = new Field();  // SpawnGreen 59
        allFields[64] = new Field();  // SpawnGreen 65
        allFields[65] = new Field();  // SpawnGreen 66

        allFields[62] = new Field(); // SpawnYellow 63
        allFields[63] = new Field(); // SpawnYellow 64
        allFields[69] = new Field(); // SpawnYellow 70
        allFields[70] = new Field(); // SpawnYellow 71

        // Finish Felder
        allFields[31] = new Field();    // FinishRed 32
        allFields[32] = new Field();    // FinishRed 33
        allFields[33] = new Field();    // FinishRed 34
        allFields[34] = new Field();    // FinishRed 35

        allFields[9] = new Field();   // FinishBlue 10
        allFields[14] = new Field();  // FinishBlue 15
        allFields[17] = new Field();  // FinishBlue 18
        allFields[24] = new Field();  // FinishBlue 25

        allFields[35] = new Field(); // FinishYellow 36
        allFields[36] = new Field(); // FinishYellow 37
        allFields[37] = new Field(); // FinishYellow 38
        allFields[38] = new Field(); // FinishYellow 39

        allFields[45] = new Field();  // FinishGreen 46
        allFields[52] = new Field();  // FinishGreen 53
        allFields[55] = new Field();  // FinishGreen 56
        allFields[60] = new Field();  // FinishGreen 61

        // Der Rest sind normale Felder
        for (int i = 0; i < 72; i++) {
            if (allFields[i] == null) {  // Wenn das Feld noch nicht zugewiesen wurde
                allFields[i] = new Field();
            }
        }
        return allFields;
    }
}
