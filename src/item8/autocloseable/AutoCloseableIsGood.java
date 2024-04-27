package item8.autocloseable;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

// auto closeable 을 Josh Bloch 가 만듦
// 우테코 미션같은 곳에서 사용할 수 있을 듯 (입력받는 곳에서 scanner, bufferedreader 등) finally 블록을 사용하지 않아도 됨
public class AutoCloseableIsGood implements AutoCloseable {

    private BufferedInputStream inputStream;
    private Scanner br;

    public AutoCloseableIsGood() {
        this.inputStream = new BufferedInputStream(System.in);
        this.br = new Scanner(System.in);
    }

    // close를 구현하고, try with resource를 사용하면 자동으로 close가 된다.
    @Override
    public void close() {
        try {
            inputStream.close();
        } catch (IOException e) {
//            throw new RuntimeException("fail to close " + e);
        }
    }

    public BufferedInputStream getInputStream() {
        return inputStream;
    }

    public Scanner getBr() {
        return br;
    }
}
