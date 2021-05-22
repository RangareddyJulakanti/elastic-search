package com.example.elasticsearch;

import com.example.elasticsearch.entity.Address;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ElasticsearchRepository<Address, String> {

}
