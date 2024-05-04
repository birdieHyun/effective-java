package item11.hashcode;

import java.util.Objects;

// equals를 재정의하면 hashCode도 재정의해야 한다.
public class PhoneNumber {

    private final int areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }


    private volatile int hashCode;
    // 왜 31인가?
    // -> 홀수를 사용해야 하고, 사전에 있는 모든 단어를 해싱해보았는데, 31이란 수를 사용했을 때 해시 충돌이 적었음
    @Override
    public int hashCode() {
        if (this.hashCode != 0) {
            return hashCode;
        }
        synchronized (this) {
            int result = hashCode;
            if (result == 0) {
                result = Integer.hashCode(areaCode);
                result = 31 * result + Integer.hashCode(prefix);
                result = 31 * result + Integer.hashCode(lineNum);
                hashCode = result;
            }
            return result;
        }
    }

//    @Override
//    public int hashCode() {
//        if (hashCode != 0) {
//            return hashCode;
//        }
//        return Objects.hash(areaCode, prefix, lineNum);
//    }
}
