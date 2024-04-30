package item10.equals.consistency;

import java.net.MalformedURLException;
import java.net.URL;

public class Consistency {

    public static void main(String[] args) throws MalformedURLException {
        // 같은 도메인이지만 도메인이 가리키는 IP 값은 달라질 수 있음 -> 일관성 위배 가능성이 이씅ㅁ
        // host를 기준으로 비교하는게 아닌, 실제 IP를 가져와서 값을 비교함
        // -> 로드밸런서가 다른 ip로 보내준다면?
        URL google1 = new URL("https", "about.google", "/products");
        URL google2 = new URL("https", "about.google", "/products");
        System.out.println(google1.equals(google2));
    }
}
