package com.thanhtq.external.infracstructure.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@Document(dynamic = Dynamic.TRUE, indexName = "#{@esConfig.getProductIndex()}")
@Document(dynamic = Dynamic.TRUE, indexName = "product-index")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDocument {

    @Id
    private String Id;
    @Field(
            name = "productId",
            type = FieldType.Text
    )
    private String productId;
    @Field(
            name = "title",
            type = FieldType.Text
    )
    private String title;
    @Field(
            name = "sku",
            type = FieldType.Text
    )
    private String sku;

    @Field(
            name = "money",
            type = FieldType.Object
    )
    private MoneyObject price;

    @Field(
            name = "createDate",
            type = FieldType.Date
    )
    private ZonedDateTime createDate;
}
