package uz.pdp.model;

import lombok.*;

// PROJECT NAME shop_bot
// TIME 14:15
// MONTH 04
// DAY 12
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartProduct {
    private Integer id;
    private String customerId;
    private Integer productId;
    private Integer quantity;


    public CartProduct(String customerId, Integer productId, Integer quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
