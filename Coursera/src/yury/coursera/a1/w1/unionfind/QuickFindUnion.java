package yury.coursera.a1.w1.unionfind;

/**
 * Created by Yury on 25.01.2015.
 */
public class QuickFindUnion {
    public int[] initArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    public int[] union(int source, int destination, int[] array) {
        int _source = array[source];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == _source) {
                array[i] = array[destination];
            }
        }
        return array;
    }

    public boolean isConnected(int source, int destination, int[] array) {
        return array[source] == array[destination];
    }
}
