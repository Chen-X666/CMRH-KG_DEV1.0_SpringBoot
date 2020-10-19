package com.canton.service.impl;

import com.canton.dao.utils.DefaultOntModel;
import com.canton.service.CountService;
import com.canton.service.OntologyResolver;
import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther ChenX
 * @Date 2020.10.19
 **/
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private OntologyResolver ontologyResolver;


    @Override
    public Map<String, Integer> countAll() {

        OntModel ontModel = DefaultOntModel.getInstance().getOntModel();

        int statements = 0;
        int objectProperty = 0;
        int dataProperty = 0;
        int individuals = 0;
        StmtIterator statementsIter = ontModel.listStatements();
        while (statementsIter.hasNext()) {
            statementsIter.next();
            statements++;
        }
        ExtendedIterator<ObjectProperty> objectPropertysIter = ontModel.listObjectProperties();
        while (objectPropertysIter.hasNext()) {
            objectPropertysIter.next();
            objectProperty++;
        }
        ExtendedIterator<DatatypeProperty> dataPropertysIter = ontModel.listDatatypeProperties();
        while (dataPropertysIter.hasNext()) {
            dataPropertysIter.next();
            dataProperty++;
        }
        ExtendedIterator<Individual> individualsIter = ontModel.listIndividuals();
        while (individualsIter.hasNext()) {
            individualsIter.next();
            individuals++;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("statement",statements);
        map.put("individual",individuals);
        map.put("objectProperty",objectProperty);
        map.put("dataProperty",dataProperty);
        map.put("books",countAllBooks());
        return map;
    }

    @Override
    public int countAllBooks() {
        File file=new File("src/main/resources/book");
        String files[]=file.list();
        int num = files.length;
        return num;
    }

}
