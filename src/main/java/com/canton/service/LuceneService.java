package com.canton.service;

import com.canton.dao.entity.Lucene;

import java.util.List;

public interface LuceneService {
     List<Lucene> getKeyword(String keyword) throws Exception;

}
