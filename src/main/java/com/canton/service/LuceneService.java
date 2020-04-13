package com.canton.service;

import com.canton.dao.entity.Lucene;

public interface LuceneService {
     Lucene getKeyword(String keyword) throws Exception;

}
