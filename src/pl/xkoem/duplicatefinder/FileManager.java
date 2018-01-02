package pl.xkoem.duplicatefinder;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class FileManager {

    private Stream<String> lines;

    FileManager(String fileName, String outputFile) {

        openFile(fileName);
        LinkedHashSet<String> noDuplicates = removeDuplicates();
        StringBuilder content = new StringBuilder();

        for (String s :noDuplicates) {
            content.append(s).append("\n");
        }

        saveToFile(outputFile, content.toString());
        System.out.println("Duplicates removed. Saved into: " + outputFile);
    }

    private void openFile(String fileDir) {
        try {
            lines = Files.lines(Paths.get(fileDir));
        } catch (IOException e) {
            System.out.println("File '" + fileDir + "' does not exist");
            System.exit(2);
        }
    }

    private void saveToFile(String fileName, String content) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error while creating an output file");
            System.exit(3);
        }
    }

    public void printData() {
        lines.forEach(System.out::println);
    }

    private LinkedHashSet<String> removeDuplicates() {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        lines.forEach(hashSet::add);
        return hashSet;
    }


}
