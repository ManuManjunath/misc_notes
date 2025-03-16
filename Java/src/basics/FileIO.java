package basics;

import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        // Writing
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("sample_text.txt"));
            bw.write("Line 1\n");
            bw.write("Line 2\n");
            bw.write("Line 3\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("sample_text.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            return;
        }

        // Copy file
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("sample_text_copy.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("sample_text.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            return;
        }
    }
}
