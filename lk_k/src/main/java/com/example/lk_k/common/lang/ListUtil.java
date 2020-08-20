package com.example.lk_k.common.lang;

import java.util.List;

public class ListUtil {

    /**
     * 合并多个list
     * @param lists
     * @param <T>
     * @return
     */
    public static <T> List<T> mergeLists(List<T>... lists) {
        Class clazz = lists[0].getClass();
        List<T> list = null;
        try {
            list = (List<T>) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0, len = lists.length; i < len; i++) {
            list.addAll(lists[i]);
        }
        return list;
    }
}