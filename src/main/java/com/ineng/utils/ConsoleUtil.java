package com.ineng.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtil {
    public static String getInput() {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public static String getDefaultFormatLine(String input, int panddingLeft) {
        return getDefaultFormatLine(input, 70, panddingLeft);
    }

    public static String getDefaultFormatLine(String input, int length, int panddingLeft) {
        StringBuilder outLine = new StringBuilder(length + 2);
        outLine.append("*");

        if (!"=".equals(input) && !" ".equals(input)) {
            int panddingRight = length - panddingLeft - getInputLength(input);
            outLine.append(getFormatStr(" ", panddingLeft));
            outLine.append(input);
            outLine.append(getFormatStr(" ", panddingRight));
        } else {
            outLine.append(getFormatStr(input, length));
        }

        outLine.append("*");

        return outLine.toString();
    }

    private static int getInputLength(String input) {
        if (null == input) return 0;

        int length = 0;
        for (int i = 0; i < input.length(); i++) {
            length += ((input.charAt(i) & 0xFFFF00) == 0) ? 1 : 2;
        }
        return length;
    }

    private static String getFormatStr(String input, int length) {
        StringBuilder outStr = new StringBuilder(length + 2);
        for (int i = 0; i < length; i++) {
            outStr.append(input);
        }
        return outStr.toString();
    }
}
