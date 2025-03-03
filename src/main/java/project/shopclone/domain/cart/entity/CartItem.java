package project.shopclone.domain.cart.entity;

import jakarta.persistence.*;
import lombok.*;
import project.shopclone.domain.product.entity.Product;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Setter
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    private Integer count;   // 수량

    // 상품 정보
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;

    public void updateCount(Integer count){
        this.count = count;
    }
}
