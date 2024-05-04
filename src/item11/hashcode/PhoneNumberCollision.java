package item11.hashcode;

// equals를 재정의하면 hashCode도 재정의해야 한다.
public class PhoneNumberCollision {

    private final int areaCode, prefix, lineNum;

    public PhoneNumberCollision(int areaCode, int prefix, int lineNum) {
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
        if (!(o instanceof PhoneNumberCollision)) {
            return false;
        }
        PhoneNumberCollision pn = (PhoneNumberCollision)o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        return 11;
    }
}
