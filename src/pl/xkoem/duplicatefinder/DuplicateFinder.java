package pl.xkoem.duplicatefinder;


import java.util.Scanner;

public class DuplicateFinder {

    public static void main(String [] args) {
        if(args.length > 2) {
            System.out.println("Too many arguments!");
            System.exit(1);
        }

        if(2 == args.length) {
            FileManager fileManager = new FileManager(args[0], args[1]);
            System.exit(0);
        }

        if(1 == args.length) {
            FileManager fileManager = new FileManager(args[0], "out.txt");
            System.exit(0);
        }

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("File to remove duplicates: ");
        String fileName = reader.next();
        System.out.println("Output file (0 for default): ");
        String outputFile = reader.next();
        reader.close();

        if(outputFile.equals("0")) {
            outputFile = "out.txt";
        }

        FileManager fileManager = new FileManager(fileName, outputFile);

    }
}
