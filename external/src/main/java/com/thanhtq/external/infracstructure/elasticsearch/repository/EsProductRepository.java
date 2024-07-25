package com.thanhtq.external.infracstructure.elasticsearch.repository;

import com.thanhtq.external.infracstructure.elasticsearch.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsProductRepository extends ElasticsearchRepository<ProductDocument, String> {
    boolean existsByProductId(String productId);
}
