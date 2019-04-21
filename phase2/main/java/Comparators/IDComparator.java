package Comparators;

import java.io.Serializable;
import java.util.Comparator;

public class IDComparator implements Comparator<String>, Serializable {
    private static final long serialVersionUID = 234567L;

    public int compare(String s1, String s2) {
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);
        return Integer.compare(num1, num2);
    }
}
