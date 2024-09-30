package com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.DateFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Document(indexName = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntityElasticsearch {
  @Id
  private Long id;

  @Field(type = FieldType.Text)
  private String name;

  @Field(type = FieldType.Text)
  private String description;

  @Field(type = FieldType.Float)
  private Float price;

  @Field(type = FieldType.Long)
  private Long stock;

  @Field(type = FieldType.Text)
  private String slug;

  @Field(type = FieldType.Long)
  private Long categoryId;

  @Field(type = FieldType.Date, format = DateFormat.date_time)
  private Date createdAt;

  @Field(type = FieldType.Date, format = DateFormat.date_time)
  private Date updatedAt;
}
