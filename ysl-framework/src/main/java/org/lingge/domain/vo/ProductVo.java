package org.lingge.domain.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.lingge.domain.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVo {
    private int total;
    private List<Product> shoppingList;

}
