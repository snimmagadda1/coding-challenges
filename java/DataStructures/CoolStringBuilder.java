package DataStructures;

import java.util.Arrays;

public class CoolStringBuilder {

    private char[] charBuffer;
    private int MIN_LENGTH = 10;
    private int size = 0;

    public CoolStringBuilder() {
        charBuffer = new char[10];
    }

    public CoolStringBuilder append(String s) {
        // Convert input to char array
        char[] inChars = s.toCharArray();

        // Check size, if more needed, double
        boolean overFlow = size + inChars.length > charBuffer.length;
        if (overFlow) {
            char[] temp = charBuffer;
            charBuffer = Arrays.copyOf(charBuffer, inChars.length + 2 * charBuffer.length);
        }
        // Iterate and insert
        for (int i = 0; i < inChars.length; i++) {
            charBuffer[size++] = inChars[i];
        }
        return this;
    }

    public String toString() {
        // Todo: make sure entire string ok.. do we need to track size?
        return new String(charBuffer, 0, size);
    }

    public static void main(String[] args) {
        CoolStringBuilder test = new CoolStringBuilder();
        test.append("hi");
        test.append(" sai");
        test.append("asdfasj;dlfaksjdfas;dlfkjas;df");
        System.out.println(test.toString());

    }

}
