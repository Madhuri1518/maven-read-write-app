package com.mycompany.app;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String input = readInput();

        List<String> records = new ArrayList<>(Arrays.asList(input.split("\n")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String row : records) {
            // Parse the tab-separated record.
            List<String> cellList = new ArrayList<>(Arrays.asList(row.split("\t")));
            String output = "";
            for (String cell : cellList) {
                // Convert the tweet JSON blob from double-escaped to single-escaped, so we
                // can parse it.
//				String formattedCell = cell.replace("\\\\", "\\");
//				JSONObject jsonCell= new JSONObject(formattedCell);
                output += cell + "\t" + "cell-" + cell + "-12";
//				System.out.println("input: " + input);
            }
            output += "\n";
//            byte[] outputBytes = output.getBytes(charset);
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new BufferedOutputStream(System.out));
//            bufferedOutputStream.write(outputBytes);

            bufferedWriter.write(output);
        }
        bufferedWriter.flush();
    }

//    private static String readStreamInput() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        Charset charset = Charset.forName("ASCII");
//        String input = bufferedReader.lines().collect(Collectors.joining("\n"));
//        return input;
//    }

    public static String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
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
