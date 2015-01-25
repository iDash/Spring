package yury.coursera.a1;

import yury.coursera.a1.w1.unionfind.QuickFindUnion;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        QuickFindUnion quickFindUnion = new QuickFindUnion();
        int[] array = quickFindUnion.initArray(10);
        quickFindUnion.union(6, 3, array);
        quickFindUnion.union(3, 7, array);
        quickFindUnion.union(4, 0, array);
        System.out.println(Arrays.toString(array));
        quickFindUnion.union(3, 8, array);
        quickFindUnion.union(9, 6, array);
        quickFindUnion.union(5, 0, array);
        System.out.println(Arrays.toString(array));


    }
}
