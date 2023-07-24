package tw.com.imsoft.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import tw.com.imsoft.domain.vo.order.OrderToShopCar;

/*
 *  購物車頁面
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ShopCarService {

    /*
     * 取得session裡購物車資訊
     */
    public Map<String,Object> showShopCar(HttpServletRequest req,List<OrderToShopCar> dataList) {
        List<OrderToShopCar> shopCarList = dataList;
        Map<String,Object> totalMap = new HashMap<>();
        int totalNum = 0;
        int totalPrice = 0;
        if(shopCarList != null && !shopCarList.isEmpty()) {
            for(OrderToShopCar ots : shopCarList) {
                totalNum += ots.getNum();
                System.out.println("totalNum => " + totalNum);
                totalPrice += (Integer.parseInt(ots.getFinalPrice()) * ots.getNum());
                System.out.println("totalPrice => " + totalPrice);
            }
            totalMap.put("totalNum", totalNum);
            totalMap.put("totalPrice", totalPrice);
            req.getSession().setAttribute("totalNum", totalNum);
            req.getSession().setAttribute("totalPrice", totalPrice);
        }
        return totalMap;
    }
    
    /*
     * 移除選擇的購物車商品
     */
//    public void removeProduct(HttpServletRequest req,String index) {
//        List<OrderToShopCar> shopCarList =(List) req.getSession().getAttribute("productData");
//        if(!shopCarList.isEmpty()) {
//            shopCarList.remove(Integer.parseInt(index));
//        }
//        req.getSession().setAttribute("productData", shopCarList);
//    }
    
    public  List<OrderToShopCar> removeProduct(HttpServletRequest req,String index,List<OrderToShopCar> dataList) {
        List<OrderToShopCar> shopCarList = dataList;
        System.out.println("shopCarList 刪除前=> " + shopCarList);
        if(!shopCarList.isEmpty()) {
            shopCarList.remove(Integer.parseInt(index));
        }
        System.out.println("shopCarList 刪除後=> " + shopCarList);
        return shopCarList;
    }
    
    /*
     * 調整商品數量
     */
//    public void editProduct(HttpServletRequest req,String index,int num,String mt) {
//        List<OrderToShopCar> shopCarList =(List) req.getSession().getAttribute("productData");
//        if(!shopCarList.isEmpty()) {
//            if("plus".equals(mt)) {
//                shopCarList.get(Integer.parseInt(index)).setNum(num+1);
//            }else if("minus".equals(mt)) {
//                shopCarList.get(Integer.parseInt(index)).setNum(num-1);
//            }
//        }
//        req.getSession().setAttribute("productData", shopCarList);
//    }
    
    public List<OrderToShopCar> editProduct(HttpServletRequest req,String index,String mt,List<OrderToShopCar> dataList) {
        List<OrderToShopCar> shopCarList = dataList;
        if(!shopCarList.isEmpty()) {
            if("plus".equals(mt)) {
                int num = shopCarList.get(Integer.parseInt(index)).getNum();
                System.out.println("num => " + num);
                shopCarList.get(Integer.parseInt(index)).setNum(num + 1);
                System.out.println("newShopCarList => " + shopCarList);
            }else if("minus".equals(mt)) {
                int num = shopCarList.get(Integer.parseInt(index)).getNum();
                shopCarList.get(Integer.parseInt(index)).setNum(num - 1);
            }
        }
        req.getSession().setAttribute("productData", shopCarList);
        return shopCarList;
    }
    
}
