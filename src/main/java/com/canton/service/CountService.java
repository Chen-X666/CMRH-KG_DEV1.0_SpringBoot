package com.canton.service;

import java.util.Map;

public interface CountService {
    /**
     * 获取本体库中所有三元组 实体 关系 属性 数量。
     * @return
     */
    Map<String, Integer> countAll();

    int countAllBooks();

}
