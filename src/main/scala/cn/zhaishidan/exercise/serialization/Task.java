package cn.zhaishidan.exercise.serialization;

import java.io.Serializable;

/**
 * Created by stan on 2017/1/8.
 */
public abstract class Task implements Serializable {

    public void run() {
        System.out.println("run task!");
    }
}
