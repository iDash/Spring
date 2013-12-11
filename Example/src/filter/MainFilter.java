package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFilter {
    public static void main(String[] args) {
        Filter filter = new Filter();
        filter.testFilter();
    }
}

class Filter {
    private List<Integer> list;

    public Filter() {
        list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer s) {
                if (s % 2 == 0) {
                    return super.add(s);
                } else {
                    System.out.println("odd!");
                    return false;
                }
            }
        };
    }

    public void testFilter() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        for (int i : integers) {
            list.add(i);
        }

        System.out.println(list);
    }
}
