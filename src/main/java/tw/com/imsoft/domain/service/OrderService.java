package tw.com.imsoft.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.imsoft.dao.mapper.custom.MemberCustomMapper;
import tw.com.imsoft.dao.mapper.custom.ProductCustomMapper;
import tw.com.imsoft.dao.model.Member;
import tw.com.imsoft.domain.vo.order.OrderData;
import tw.com.imsoft.domain.vo.order.OrderProductDetail;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrderService {

    @Autowired
    ProductCustomMapper productCustomMapper;
    
    @Autowired
    MemberCustomMapper memberCustomMapper;
    
    /*
     * 菜單商品
     */
    public List<OrderData> getProductData(){
        List<Map<String,Object>> dataList = productCustomMapper.selectProductData();
        // 最終商品結構
        List<OrderData> finalList = new ArrayList<>();
        // OrderData 商品內容
        List<Map<String,Object>> orderDataList = new ArrayList<>();
        OrderData orderData = new OrderData();
        // 取出一筆資料內的商品種類作為基準判斷
        String cateId = dataList.get(0).get("PRODUCT_CATEGORY_ID").toString();
        for(Map<String,Object> data : dataList) {
            if(!cateId.equals(data.get("PRODUCT_CATEGORY_ID").toString())) {
                finalList.add(orderData);
                orderData = new OrderData();
                orderDataList = new ArrayList<>();
            }
            orderData.setProductCategoryName(data.get("PRODUCT_CATEGORY_NAME").toString());
            String[] priceData = data.get("PRICE").toString().split(",");
            data.put("price1", priceData[0]);
            if(priceData.length > 1) {
            data.put("price2", priceData[1]);
            }
            orderDataList.add(data);
            orderData.setDataList(orderDataList);
            cateId = data.get("PRODUCT_CATEGORY_ID").toString();
            
        }
        finalList.add(orderData);
        return finalList;
    }
    
    /*
     * 商品資訊
     */
    public OrderProductDetail getProductDetail(String id){
        return productCustomMapper.selectProductDetail(id);
    }
    
    /*
     *  商品加入購物車 加(session)
     */
//    public void checkToShopCar(HttpServletRequest req,OrderToShopCar orderToShopCar) {
//        List<OrderToShopCar> detailList =(List) req.getSession().getAttribute("productData");
//        String productName = req.getParameter("productName");
//        String productId = req.getParameter("productId");
//        String productSizeId = req.getParameter("finalNo");
//        int num = Integer.parseInt(req.getParameter("num").toString());
//        String size = req.getParameter("finalSize");
//        String price = req.getParameter("finalPrice");
//        String ice = req.getParameter("finalIce");
//        String sweet = req.getParameter("finalSweet");
//        boolean repeat = false;
//        // 判斷session 裡是否已有商品
//        if(detailList != null && !detailList.isEmpty()) {
//            for (OrderToShopCar ots : detailList) {
//                // 判斷選取商品是否跟session 內的商品資訊一樣
//                if (productId.equals(ots.getProductId()) && productName.equals(ots.getProductName())
//                        && productSizeId.equals(ots.getProductSizeId()) && size.equals(ots.getSize())
//                        && price.equals(ots.getFinalPrice()) && ice.equals(ots.getIce()) && sweet.equals(ots.getSweet())) {
//                    ots.setNum(ots.getNum() + num);
//                    repeat = true;
//                    break;
//                }
//            }
//            if (!repeat) {
//                OrderToShopCar order = setOrder(productName,productId,productSizeId,size,price,ice,sweet,num);
//                OrderToShopCar order = new OrderToShopCar();
//                order.setProductName(productName);
//                order.setProductId(productId);
//                order.setProductSizeId(productSizeId);
//                order.setSize(size);
//                order.setPrice(price);
//                order.setIce(ice);
//                order.setSweet(sweet);
//                order.setNum(num);
//                detailList.add(order);
//            }
//        }else {
//            detailList = new ArrayList<>();
//            OrderToShopCar order = setOrder(productName,productId,productSizeId,size,price,ice,sweet,num);
//            OrderToShopCar order = new OrderToShopCar();
//            order.setProductName(productName);
//            order.setProductId(productId);
//            order.setProductSizeId(productSizeId);
//            order.setSize(size);
//            order.setPrice(price);
//            order.setIce(ice);
//            order.setSweet(sweet);
//            order.setNum(num);
//            detailList.add(order);
//        }
//        System.out.println("detailList => " + detailList);
//        req.getSession().setAttribute("productId", productId);
//        req.getSession().setAttribute("productData", detailList);
//    }
    
    public List<OrderToShopCar> checkToShopCar(HttpServletRequest req,OrderToShopCar orderToShopCar) {
//        List<OrderToShopCar> detailList = orderToShopCar.getDataList();
        List<OrderToShopCar> detailList = orderToShopCar.getDataList();
        String productName = orderToShopCar.getProductName();
        String productId = orderToShopCar.getProductId();
        String productSizeId = orderToShopCar.getProductSizeId();
        int num = orderToShopCar.getNum();
        String size = orderToShopCar.getSize();
        String price = orderToShopCar.getFinalPrice();
        String ice = orderToShopCar.getIce();
        String sweet = orderToShopCar.getSweet();
        boolean repeat = false;
        // 判斷session 裡是否已有商品
        if(detailList != null && !detailList.isEmpty()) {
            System.out.println("購物車有東西");
            for (OrderToShopCar ots : detailList) {
                // 判斷選取商品是否跟session 內的商品資訊一樣
                if (productId.equals(ots.getProductId()) && productName.equals(ots.getProductName())
                        && productSizeId.equals(ots.getProductSizeId()) && size.equals(ots.getSize())
                        && price.equals(ots.getFinalPrice()) && ice.equals(ots.getIce()) && sweet.equals(ots.getSweet())) {
                    ots.setNum(ots.getNum() + num);
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                OrderToShopCar order = setOrder(productName,productId,productSizeId,size,price,ice,sweet,num);
                detailList.add(order);
            }
        }else {
            System.out.println("購物車沒東西");
            detailList = new ArrayList<>();
            OrderToShopCar order = setOrder(productName,productId,productSizeId,size,price,ice,sweet,num);
            detailList.add(order);
        }
        System.out.println("detailList => " + detailList);
        return detailList;
    }
    
    public OrderToShopCar setOrder(String productName,String productId,String productSizeId,String size,String price,String ice,String sweet,int num) {
        OrderToShopCar order = new OrderToShopCar();
        order.setProductName(productName);
        order.setProductId(productId);
        order.setProductSizeId(productSizeId);
        order.setSize(size);
        order.setFinalPrice(price);
        order.setIce(ice);
        order.setSweet(sweet);
        order.setNum(num);
        return order;
    }
}
