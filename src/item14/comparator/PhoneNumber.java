package item14.comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override // generic 덕분에 컴파일 시점부터 Object가 아닌 PhoneNumber라는 구체적인 타입을 알 수 있다.
    // equals같은 경우는 Object 임
    public int compareTo(PhoneNumber pn) {

        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);

            if (result == 0) {
                result = Short.compare(lineNum, pn.lineNum);
            }
        }
        return result;
    }
}
