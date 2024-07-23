package com.thanhtq.external.infracstructure.elasticsearch;

import com.thanhtq.external.infracstructure.elasticsearch.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESRepository extends ElasticsearchRepository<ProductDocument, String> {
}
