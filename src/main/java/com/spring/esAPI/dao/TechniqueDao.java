package com.spring.esAPI.dao;

import com.spring.esAPI.beans.TechniqueBean;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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

    public TechniqueDao(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<TechniqueBean> findTechniqueName(final  String query){
        // 1. Create query on multiple fields enabling fuzzy search
        QueryBuilder queryBuilder=QueryBuilders.multiMatchQuery(query,"techniquename","subtechniques").fuzziness(Fuzziness.AUTO);

        // 2. Execute search
        Query searchQuery=new NativeSearchQueryBuilder().withFilter(queryBuilder).build();

        SearchHits<TechniqueBean>TechniqueHits=elasticsearchOperations.search(searchQuery,TechniqueBean.class,IndexCoordinates.of("mitre123"));

        // 3. Map searchHits to product list
        List<TechniqueBean>TechniqueMatch = new ArrayList<>();

        TechniqueHits.forEach(searchHit -> {
            TechniqueMatch.add(searchHit.getContent());
        });

        return TechniqueMatch;



    }

}
