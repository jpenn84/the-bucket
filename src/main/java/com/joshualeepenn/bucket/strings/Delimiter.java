package com.joshualeepenn.bucket.strings;

/**
 * Common set of delimiters used for console logs and other text. The use of static strings helps to reduce individual
 * static strings, can help with readability, and can help with find & replace by using an IDE's "Find Usages" function.
 */
public class Delimiter {

    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String TAB = "\t";
    public static final String NEWLINE = "\n";

    public static final String COMMA_SPACE = COMMA + SPACE;
    public static final String COLON_SPACE = COLON + SPACE;
    public static final String SEMICOLON_SPACE = SEMICOLON + SPACE;
    public static final String NEWLINE_TAB = NEWLINE + TAB;

}
