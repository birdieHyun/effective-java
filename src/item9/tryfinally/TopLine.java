package item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopLine {
    // 9-1 더이상 자원을 회수하는 최선의 방책이 아니다! (47p)
    static String firstLineOfFile() throws IOException {
        BufferedReader br = new BadBufferedReader(new InputStreamReader(System.in));

        try {
            return br.readLine();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            br.close();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile());
    }
}
