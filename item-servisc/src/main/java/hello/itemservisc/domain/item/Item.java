package hello.itemservisc.domain.item;

import lombok.Data;
//(주의) lombok.Data를 실제로 쓰는건 위험
@Data
public class Item {
    // item 객체
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){}

    public Item(String itemName, Integer price, Integer quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
