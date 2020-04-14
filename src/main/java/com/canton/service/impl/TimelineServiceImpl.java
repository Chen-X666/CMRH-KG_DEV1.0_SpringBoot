package com.canton.service.impl;

import com.canton.dao.util.PrefixUtil;
import com.canton.model.data.interfaces.Data;
import com.canton.model.ontology.Statement;
import com.canton.service.TimelineService;
import com.canton.utils.DataUtil;
import com.canton.utils.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Auther ChenX
 * @Date 2020.4.3
 * 时间轴
 **/
@Service
public class TimelineServiceImpl extends BaseService implements TimelineService {
    PrefixUtil prefix = new PrefixUtil();

    @Override
    public String getAll() {


        String rank = prefix.setPrefix("Time","排序时间");
        String time = prefix.setPrefix("Event","开始时间");

        String sparqlStr =
                "SELECT DISTINCT ?subject ?time ?rank "
                        + "  WHERE {"
                        + "  ?subject " + time +" ?time."
                        + "  ?time " + rank +" ?rank.}"
                        + "  ORDER BY ?rank";


        Collection<Statement> statements = getOntologyResolver().query(sparqlStr);

        String result = null;

        if (statements.size() > 0) {

            Data data = DataUtil.transferStatementsToData(statements);

            result = JsonUtil.formatAsJson(data);

        }
        else
        {
            System.out.println("无检索all");
        }
        return result;
    }
}
