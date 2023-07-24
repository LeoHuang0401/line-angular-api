package tw.com.imsoft.domain.vo.angular;

import tw.com.imsoft.domain.vo.order.OrderProductDetail;

public class OrderDetail {

    private OrderProductDetail orderDetail;
    
    private String noM;
    
    private String noL;
    
    private String sizeM;
    
    private String sizeL;
    
    private String priceM;
    
    private String priceL;
    
    private int listSize; 

    public OrderProductDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderProductDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getNoM() {
        return noM;
    }

    public void setNoM(String noM) {
        this.noM = noM;
    }

    public String getNoL() {
        return noL;
    }

    public void setNoL(String noL) {
        this.noL = noL;
    }

    public String getSizeM() {
        return sizeM;
    }

    public void setSizeM(String sizeM) {
        this.sizeM = sizeM;
    }

    public String getSizeL() {
        return sizeL;
    }

    public void setSizeL(String sizeL) {
        this.sizeL = sizeL;
    }

    public String getPriceM() {
        return priceM;
    }

    public void setPriceM(String priceM) {
        this.priceM = priceM;
    }

    public String getPriceL() {
        return priceL;
    }

    public void setPriceL(String priceL) {
        this.priceL = priceL;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    
}
