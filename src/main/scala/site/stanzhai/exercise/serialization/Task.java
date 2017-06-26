package site.stanzhai.exercise.serialization;

import java.io.Serializable;

/**
 * Created by stan on 2017/1/8.
 */
public abstract class Task implements Serializable {

    public void run() {
        throw new RuntimeException("not implement!");
    }
}
