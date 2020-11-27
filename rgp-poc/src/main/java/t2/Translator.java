package t2;

import java.util.HashMap;
import java.util.Map;

public class Translator {

    public static HashMap<String,String> morseTable;
    private static HashMap<String,String> inverseMorseTable;

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
        morseTable.put(" ", "|");

        inverseMorseTable = new HashMap<>();
        for(Map.Entry<String,String> e : morseTable.entrySet())
            inverseMorseTable.put(e.getValue(),e.getKey());

    }

    public static String translateTextToMorse(String text) {
        StringBuilder sb = new StringBuilder();

        for(char c : text.toUpperCase().toCharArray()) {
            var representation = morseTable.getOrDefault(c+"","?");
            sb.append(representation + " ");
        }
        return sb.toString().strip();
    }

    public static String translateMorseToText(String morseText) {
        StringBuilder sb = new StringBuilder();

        for(String c : morseText.split(" ")) {
            var representation = inverseMorseTable.getOrDefault(c+"","?");
            sb.append(representation);
        }
        return sb.toString().strip();
    }

    public static String translateTextToBinary(String text) {
        StringBuilder sb = new StringBuilder();

        for(char c : text.toCharArray()) {
            if(c == ' ')
                sb.append("| ");
            else
                sb.append(Integer.toBinaryString(c) + " ");
        }
        return sb.toString().strip();
    }
    public static String translateBinaryToText(String binaryText) {
        StringBuilder sb = new StringBuilder();

        for(String c : binaryText.split(" ")) {
           if(c.equals("|"))
               sb.append(" ");
           else
            sb.append((char)Integer.parseInt(c,2));
        }
        return sb.toString().strip();
    }
}
