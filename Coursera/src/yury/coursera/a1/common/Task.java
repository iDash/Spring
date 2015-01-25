package yury.coursera.a1.common;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by Yury on 25.01.2015.
 */
public class Task {
    List<String> array;
    List<String> parameters;

    public String[] getArray() {
        if (CollectionUtils.isEmpty(array)) {
            throw new RuntimeException("Array is not initialized");
        }

        return array.toArray(new String[array.size()]);
    }

    public void setArray(List<String> array) {
        this.array = array;
    }


}
