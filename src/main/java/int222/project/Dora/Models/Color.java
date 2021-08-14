package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Color {

  @Id
  @Getter
  @Setter
  private long colorId;
  @Getter
  @Setter
  private String colorName;
  @Getter
  @Setter
  private String colorCode;
  @OneToMany(mappedBy = "Color")
  Set<ProductColor> productcolor;

}
