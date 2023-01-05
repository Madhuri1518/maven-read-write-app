package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = readInput();
        List<String> records = new ArrayList<>(Arrays.asList(input.split("\n")));
        for (String row : records) {
            List<String> cellList = new ArrayList<>(Arrays.asList(row.split(",")));
            String output = "";
            for (String cell : cellList) {
                output += cell + ",test-" + cell + "-123\n";
            }
            bufferedWriter.write(output);
        }
        bufferedWriter.flush();
    }

    public static String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            output.append(line);
            output.append("\n");
        }
        bufferedReader.close();
        return output.toString();
    }
}
