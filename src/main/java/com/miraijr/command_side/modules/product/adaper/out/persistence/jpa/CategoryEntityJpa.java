package com.miraijr.command_side.modules.product.adaper.out.persistence.jpa;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Column;
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

  @Column(nullable = false, name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Column(nullable = false, name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<CategoryEntityJpa> subCategories;

  @PrePersist
  protected void onCreate() {
    Date now = new Date();
    createdAt = now;
    updatedAt = now;
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = new Date();
  }
}
