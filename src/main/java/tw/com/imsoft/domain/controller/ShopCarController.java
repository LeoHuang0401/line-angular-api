package tw.com.imsoft.domain.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.imsoft.domain.service.ShopCarService;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

/*
 *  購物車頁面
 */
@Controller
public class ShopCarController {

    @Autowired
    ShopCarService shopCarService;
    
    /*
     * 取得session裡購物車資訊
     */
//    @RequestMapping("/shopCar")
//    public ModelAndView shopCar(HttpServletRequest req) {
//        ModelAndView mv = new ModelAndView("/shopCar");
//        Map<String,Object> totalMap = shopCarService.showShopCar(req);
//        int size = shopCarService.getShopCarNum(req);
//        if(size > 0) {
//            mv.addObject("shopCarNum",size);
//        }
//        mv.addObject("dataList", req.getSession().getAttribute("productData"));
//        mv.addObject("total", totalMap);
//        return mv;
//    }
    
    @RequestMapping("/angular/shopCar")
    public @ResponseBody Map<String,Object> shopCar(HttpServletRequest req, @RequestBody List<OrderToShopCar> dataList) {
        Map<String,Object> totalMap = shopCarService.showShopCar(req,dataList);
        return totalMap;
    }
    
    /*
     * 移除選擇的購物車商品
     */
//    @PostMapping("/shopCar/remove")
//    public @ResponseBody void removeProduct(HttpServletRequest req,String index) {
//        shopCarService.removeProduct(req,index);
//    }
    
    @PostMapping("/angular/shopCar/remove")
    public @ResponseBody List<OrderToShopCar> removeProduct(HttpServletRequest req,String idx,@RequestBody List<OrderToShopCar> dataList) {
        return shopCarService.removeProduct(req,idx,dataList);
    }
    
    /*
     * 調整商品數量
     */
//    @PostMapping("/shopCar/edit")
//    public @ResponseBody void editProduct(HttpServletRequest req,String index,int num,String mt) {
//        shopCarService.editProduct(req, index, num, mt);
//    }
    @PostMapping("/angular/shopCar/edit")
    public @ResponseBody List<OrderToShopCar> editProduct(HttpServletRequest req,String idx,String mt,@RequestBody List<OrderToShopCar> dataList) {
        return shopCarService.editProduct(req, idx, mt,dataList);
    }
    
}
