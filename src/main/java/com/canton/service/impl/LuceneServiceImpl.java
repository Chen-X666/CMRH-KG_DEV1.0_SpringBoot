package com.canton.service.impl;

import com.canton.dao.entity.Lucene;
import com.canton.service.LuceneService;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Paths;

/**
 * @Auther ChenX
 * @Date 2020.4.7
 **/
@Service
public class LuceneServiceImpl implements LuceneService {
    /**
     * 全文检索-构建索引
     **/
    private static final Logger logger = LoggerFactory.getLogger(LuceneServiceImpl.class);



    @Override
    public Lucene getKeyword(String keyword) throws Exception {
        File directory = new File("src/main/resources");
        String path = directory.getCanonicalPath();

        //获取要查询的路径，也就是索引所在的位置
        Directory  dir = FSDirectory.open(Paths.get(path+"/lucene"));
        IndexReader reader = DirectoryReader.open(dir);

        //构建 IndexSearcher
        IndexSearcher searcher = new IndexSearcher(reader);

        //使用中文分词器
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

        //由中文分词器初始化查询解析器
        QueryParser parser = new QueryParser("contents", analyzer);

        //通过解析要查询的 String，获取查询对象
        Query query = parser.parse(keyword);

        //记录索引开始时间
        long startTime = System.currentTimeMillis();

        //开始查询，查询前 10 条数据，将记录保存在 docs 中
        TopDocs docs = searcher.search(query, 10);
        //记录索引结束时间
        long endTime = System.currentTimeMillis();
        logger.info("匹配“{}”共耗时{}毫秒", keyword, (endTime - startTime));
        logger.info("查询到{}条记录", docs.totalHits);

        //如果不指定参数的话，默认是加粗，即 <b><b/>
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color=red>","</font></b>");
        //根据查询对象计算得分，会初始化一个查询结果最高的得分
        QueryScorer scorer = new QueryScorer(query);
        //根据这个得分计算出一个片段
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        //将这个片段中的关键字用上面初始化好的高亮格式高亮
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        //设置一下要显示的片段
        highlighter.setTextFragmenter(fragmenter);

        //取出每条查询结果
        //List<String> list = new ArrayList<>();
        //list.add("查询到" + docs.totalHits + "条记录，耗时"+(endTime - startTime)+"毫秒");
        Lucene lucene = new Lucene();
        lucene.setNum("查询到" + docs.totalHits + "条记录，耗时"+(endTime - startTime)+"毫秒");
        for(ScoreDoc scoreDoc : docs.scoreDocs) {
            //scoreDoc.doc 相当于 docID，根据这个 docID 来获取文档
            Document doc = searcher.doc(scoreDoc.doc);
            logger.info("fileName:{}", doc.get("fileName"));
            //logger.info("contents:{}", doc.get("contents"));
            String contents = doc.get("contents");

            //显示高亮
            if(contents != null) {
                TokenStream tokenStream = analyzer.tokenStream("contents", new StringReader(contents));
                String summary = highlighter.getBestFragment(tokenStream, contents);
                logger.info("得分最高的的content:{}", summary);
                String txt =".txt";//去掉文件后缀


                //list.add("《"+doc.get("fileName").replaceAll(txt,"")+"》");
               // list.add(summary);
            }
        }
        reader.close();
        return lucene;
    }



}



