import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVEditor {

    public static boolean fixCSV(File file) throws FileNotFoundException {

        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();

        Scanner sc = new Scanner(file);

        // First line
        input.add(sc.nextLine());
        if(useRecursion(input.get(0), ',', 0) != 15) {
            throw new RuntimeException("Improperly formatted file");
        } else {

        }
        System.out.println(useRecursion(input.get(0), ',', 0));

        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        System.out.println(file.getParent());
        return true;
    }

    private static int useRecursion(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + useRecursion(
                someString, searchedChar, index + 1);
    }


}
