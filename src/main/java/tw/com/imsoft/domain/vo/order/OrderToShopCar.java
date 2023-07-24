package tw.com.imsoft.domain.vo.order;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class OrderToShopCar {
    
    private String productSizeId;
    
    private String productName;

    private String productId;
    
    private String size;
    
    private String finalPrice;
    
    private String ice;
    
    private String sweet;
    
    private int num;
    
    private String uLineD;
    
    private List<OrderToShopCar> dataList;
}
