package com.example.elasticsearch;

import com.example.elasticsearch.entity.Address;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

  private ElasticsearchOperations elasticsearchOperations;
  private AddressRepository addressRepository;

  public TestController(ElasticsearchOperations elasticsearchOperations,AddressRepository addressRepository) {
    this.elasticsearchOperations = elasticsearchOperations;
    this.addressRepository=addressRepository;
  }


  public void test(){

    System.out.println(addressRepository.findAll());

  }
  @EventListener(ApplicationReadyEvent.class)
  public List<Address> getAll() {
   String text="H";
    QueryBuilder query = QueryBuilders.boolQuery()
            .should(
                    QueryBuilders.queryStringQuery(text)
                            .lenient(true)
                            //.field("name")
                            .field("addressLine1")
            ).should(QueryBuilders.queryStringQuery("*" + text + "*")
                    .lenient(true)
                   // .field("name")
                    .field("addressLine1"));

    NativeSearchQuery build = new NativeSearchQueryBuilder()
            .withQuery(query)
            .build();
     SearchHits<Address> searchHits=elasticsearchOperations.search(build,Address.class);
     return null;
  }
}