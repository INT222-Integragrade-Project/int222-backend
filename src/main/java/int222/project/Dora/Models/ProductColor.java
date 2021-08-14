package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductColor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private long productColorId;
  @Getter
  @Setter
  private long productId;
  @Getter
  @Setter
  private long colorId;
  @Getter
  @Setter
  private long stock;
  @Getter
  @Setter
  private String imageName;
  @ManyToOne
  @JoinColumn(name = "productId",insertable = false,updatable = false)
  private Product Product;
  @ManyToOne
  @JoinColumn(name = "colorId",insertable = false,updatable = false)
  private Color Color;
  @OneToMany(mappedBy = "ProductColor")
  Set<int222.project.Dora.Models.Favorite> Favorite;
}
