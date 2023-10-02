import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CSVEditor {

    public static boolean fixCSV(File file) throws IOException {

        ArrayList<String[]> output = new ArrayList<>();
        ArrayList<String[]> input = new ArrayList<>();

        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            if(line.length != 16) {
                throw new RuntimeException("Improperly formatted file");
            }
            input.add(line);
        }

        input.get(0)[0] = input.get(0)[0].substring(1);

        // First line

        Scanner expectationReader = new Scanner(new File("src/expected-format"));
        String[] expectation = expectationReader.next().split(",");

        String[] firstLine = input.get(0);
        if(Arrays.equals(firstLine, expectation)) {
            output.add(firstLine);
        } else {
            throw new RuntimeException("Improperly formatted file");
        }


/*
        getLocation(file);

        boolean firstCounted = false;
        for (String line : input) {
            if(!firstCounted) {
                firstCounted = true;
            } else {

                int commaCount = 0;

                int toRead = 0;
                StringBuilder readBuffer = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                for (char c : line.toCharArray()) {


                    if(toRead > 0) {
                        readBuffer.append(c);
                        toRead--;
                    } else {

                        if(c == ',') {
                            commaCount++;

                            if(commaCount == 2) {
                                toRead = 11;

                            } else {
                                sb.append(',');
                            }

                            if(toRead == 0) {
                                String time = readBuffer.toString();
                                if(!time.equals("")) {

                                    sb.append(time);
                                    sb.append(',');
                                    sb.append(time, 0, 5);
                                    sb.append(',');
                                    sb.append(time, 6, 11);
                                    sb.append(',');

                                    readBuffer = new StringBuilder();


                                }
                            }

                        } else {
                            sb.append(c);
                        }

                    }

                }

                String newLine = sb.toString();
                output.add(newLine);

            }
        }


        String outputWithoutFileExtension = file.toString().substring(25, file.toString().length()-4);
*/
        /*File outputFile = new File("C:\\Users\\ellio\\Documents\\Custom Office Templates\\Ruttningar\\ScriptOutput\\" + outputWithoutFileExtension + " FIXED.csv");

        FileWriter fw = new FileWriter(outputFile);

        for (String outputLine : output) {
            fw.write(outputLine);
        }

        fw.close();*/

        // TODO: Return something sensible.
        return true;
    }

    public static String getLocation(File file, HashMap<String, String> knownLocations) throws FileNotFoundException {

        return "false";

    }


    public static HashMap<String, String> makeKnownLocations(File knownLocations) throws FileNotFoundException {

        HashMap<String, String> locations = new HashMap<>();
        Scanner locationReader = new Scanner(knownLocations);

        while(locationReader.hasNextLine()) {
            String[] words = locationReader.next().split(",");
            locations.put(words[0], words[1]);
        }

        return locations;

    }

}
