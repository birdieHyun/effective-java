package item10.equals.reflectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

        @Override
//    public boolean equals(Object o) {
//
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//        if (o instanceof String){
//            return s.equalsIgnoreCase((String) o);
//        }
//
//        return false;
//    }
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
            ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString s1 = new CaseInsensitiveString("s");
        System.out.println(s1.equals("s"));
        System.out.println("s".equals(s1));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(s1);

        System.out.println(list.contains("s"));
    }
}
