package com.canton.service.impl;

import org.junit.jupiter.api.Test;

import java.util.List;


class LuceneServiceImplTest {

    @Test
    void getKeyword() {

        try {
LuceneServiceImpl lucene = new LuceneServiceImpl();
           lucene.getKeyword("黄埔军校");

            //addAttribute("list", list);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
