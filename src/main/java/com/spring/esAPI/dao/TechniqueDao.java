package com.spring.esAPI.dao;

import com.spring.esAPI.Constants;
import com.spring.esAPI.beans.TechniqueBean;


import lombok.extern.slf4j.Slf4j;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.ArrayList;
import java.util.List;


@Component
public class TechniqueDao {
    private final ElasticsearchOperations elasticsearchOperations;
    
    Logger logger = LoggerFactory.getLogger(TechniqueDao.class);

    public TechniqueDao(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<TechniqueBean> findTechniqueName(final  String query){
        // 1. Create query on multiple fields enabling fuzzy search
        QueryBuilder queryBuilder=QueryBuilders.multiMatchQuery(query,"techniquename","subtechniques").fuzziness(Fuzziness.AUTO);

        // 2. Execute search
        Query searchQuery=new NativeSearchQueryBuilder().withFilter(queryBuilder).build();

        logger.debug("Searching..");
        
        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of(Constants.MITRE_INDEX));

        // 3. Map searchHits to product list
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();

        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;
    }

    public List<TechniqueBean> findTechniqueID(final  String query){

        QueryBuilder queryBuilder=QueryBuilders.matchQuery("id",query);
        Query searchQuery=new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of(Constants.MITRE_INDEX));
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();
        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;

    }

    public List<TechniqueBean> findTechniqueTactic(final String query){

        QueryBuilder queryBuilder=QueryBuilders.matchQuery("tactic",query).fuzziness(Fuzziness.AUTO);
        Query searchQuery=new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of(Constants.MITRE_INDEX));
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();
        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;
    }

    public List<TechniqueBean> findTechniqueSubtenchnique(final String query){

        QueryBuilder queryBuilder=QueryBuilders.matchQuery("subtechniques",query);
        Query searchQuery=new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of(Constants.MITRE_INDEX));
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();
        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;
    }

    public List<TechniqueBean> findTechniqueSubtenchniqueOf(final String query){

        QueryBuilder queryBuilder=QueryBuilders.matchQuery("subtechniqueof",query);
        Query searchQuery=new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of(Constants.MITRE_INDEX));
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();
        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;
    }
}
