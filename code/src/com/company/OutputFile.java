package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {
    final String currentDirectory = System.getProperty("user.dir");
    private File file;
    public FileWriter myWriter;

    OutputFile(String content) throws IOException {
        file = new File(currentDirectory + "\\" + "outputFile.txt");
        myWriter = new FileWriter(file, true);
        if (!file.exists()) {
            file.createNewFile();
        }
        myWriter.write(content);
        myWriter.write(System.getProperty("line.separator"));
        myWriter.close();
    }
}
