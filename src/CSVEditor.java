import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVEditor {

    public static boolean fixCSV(File file) throws IOException {

        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();

        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            input.add(sc.nextLine());
        }

        // First line
        if(!input.get(0).equals("\uFEFFRutt,Ordernr,Leveranstid,Typ,Kund,Gata,Postnr,Ort,Leverans,Lasttid,Meddelande,Portkod,Telefonnummer,Total,Enhet,Bruttovikt")) {
            throw new RuntimeException("Improperly formatted file");
        } else {
            output.add("\uFEFFRutt,Ordernr,T-Fön,Från,Till,Typ,Kund,Gata,Postnr,Ort,Leverans,Lasttid,Meddelande,Portkod,Telefonnummer,Total,Enhet,Bruttovikt, Egenskaper");
        }

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

        File outputFile = new File("C:\\Users\\ellio\\Documents\\Custom Office Templates\\Ruttningar\\ScriptOutput\\" + outputWithoutFileExtension + "FIXED.csv");

        FileWriter fw = new FileWriter(outputFile);

        for (String outp : output) {
            fw.write(outp);
        }

        fw.close();


        System.out.println(file.getParent());
        return true;
    }

}
