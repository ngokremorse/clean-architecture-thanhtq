package com.thanhtq.external.infracstructure.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(
        dynamic = Dynamic.TRUE,
        indexName = "product-index"
)
@Data
public class ProductDocument {

    @Id
    private String id;
    private String productId;
    private String title;
    private String sku;
    @Field(
            type = FieldType.Nested,
            name = "price"
    )
    private MoneyObject price;
}
