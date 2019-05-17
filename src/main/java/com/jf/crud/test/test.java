package com.jf.crud.test;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "lxj");
        map.put("age", "24");
        map.put("sex", "女");
        String name = map.getOrDefault("name", "test");
    }
}
