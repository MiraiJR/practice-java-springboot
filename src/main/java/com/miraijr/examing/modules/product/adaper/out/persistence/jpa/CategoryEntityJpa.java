package com.miraijr.examing.modules.product.adaper.out.persistence.jpa;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntityJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String slug;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_id")
  private CategoryEntityJpa parent;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<CategoryEntityJpa> subCategories;
}
