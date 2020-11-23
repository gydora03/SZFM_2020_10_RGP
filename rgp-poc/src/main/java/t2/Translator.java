package t2;

import java.util.HashMap;

public class Translator {

    public static HashMap<String,String> morseTable;

    static {
        morseTable = new HashMap<>();
        morseTable.put("A","._");
        morseTable.put("B","_...");
        morseTable.put("O", "___");
        morseTable.put("C","_._.");
        morseTable.put("P",".__.");
        morseTable.put("D","_..");
        morseTable.put("Q","__._");
        morseTable.put("E",".");
        morseTable.put("R","._.");
        morseTable.put("F",".._.");
        morseTable.put("S","...");
        morseTable.put("G","__.");
        morseTable.put("T","_");
        morseTable.put("H","....");
        morseTable.put("U" ,".._");
        morseTable.put("I","..");
        morseTable.put("V", "..._");
        morseTable.put("J", ".___");
        morseTable.put("W", ".__");
        morseTable.put("K","_._");
        morseTable.put("X", "_.._");
        morseTable.put("L", "._..");
        morseTable.put("Y", "_.__");
        morseTable.put("M","__");
        morseTable.put("Z", "__..");
        morseTable.put("1",".____");
        morseTable.put("6", "_....");
        morseTable.put("2", "..___");
        morseTable.put("7", "__...");
        morseTable.put("3" ,"...__");
        morseTable.put("8", "___..");
        morseTable.put("4", "...._");
        morseTable.put("9", "____.");
        morseTable.put("5", ".....");
        morseTable.put("0", "_____");
        morseTable.put(",", "__..__");
        morseTable.put(".", "._._._");
        morseTable.put("?", "..__..");
        morseTable.put(";", "_._._.");
        morseTable.put(":", "___...");
        morseTable.put("/", "_.._.");
        morseTable.put("-", "_...._");
        morseTable.put("'", ".____.");
        morseTable.put("\"", "._.._.");
        morseTable.put("_", "..__._");
        morseTable.put("(", "_.__.");
        morseTable.put(")", "_.__._");
        morseTable.put("=", "_..._");
        morseTable.put("+", "._._.");
        morseTable.put("X", "_.._");
        morseTable.put("@", ".__._.");
    }

    public static String translateTextToMorse(String text) {

    }
}
