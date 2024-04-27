package item9.trywithresource;

import item9.tryfinally.BadBufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopLine {

    static String firstLineOfFile() throws IOException {

        try (BadBufferedReader br = new BadBufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        firstLineOfFile();
    }
}
