package com.canton.service;

import com.canton.dao.entity.Lucene;

import java.util.List;

public interface LuceneService {
     List<String> getKeyword(String keyword) throws Exception;

}
