package tw.com.imsoft.domain.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.imsoft.domain.service.ConfirmOrderService;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

/*
 *  確認訂單頁面 以及 LINE PAY APIs
 */
@Controller
public class ConfirmOrderController {
    
    @Autowired
    ConfirmOrderService confirmOrderService;
    
    /*
     * 消費者付款請求 Api
     */
//    @PostMapping(value = "/confirmOrder/checkLinePay")
//    public void pay(HttpServletRequest req,HttpServletResponse res) {
//        try {
//            if(req.getSession().getAttribute("takeTime") != null) {
//                String takeTime = req.getSession().getAttribute("takeTime").toString();
//                System.out.println(takeTime);
//    //          取得LinePay 付款頁面
//                String linePayUrl = confirmOrderService.requestApi(req,takeTime);
//    //          轉導至LinePay 付款頁面
//                res.sendRedirect(linePayUrl);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    @PostMapping(value = "/angular/confirmOrder/checkLinePay")
    public @ResponseBody Map<String,String> pay(@RequestBody List<OrderToShopCar> dataList,String takeTime,String totalPrice,String uLineD) {
        //取得LinePay 付款頁面
        System.out.println("pay#start");
        Map<String,String> url = new HashMap<>();
        if(dataList != null && takeTime != null && !"".equals(takeTime) && totalPrice != null && !"".equals(totalPrice)) {
            url.put("url", confirmOrderService.requestApi(dataList, takeTime, totalPrice,uLineD));
        }
        return url;
    }
    
    /*
     * 商家請款Api
     */
//    @RequestMapping("/confirmOrder/checkPay")
//    public void checkPay(HttpServletResponse res,String transactionId,String orderId) {
//        try {
////          請款Api
//            confirmOrderService.confirmApi(transactionId, orderId);
////          成功後轉導至成功付款頁面
//            res.sendRedirect("../sucessPay");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    @RequestMapping("/angular/confirmOrder/checkPay")
    public @ResponseBody Map<String,String> checkPay(HttpServletResponse res,String transactionId,String orderId) {
        Map<String,String> returnCode = new HashMap<>();
//          請款Api
        if (transactionId != null && !"".equals(transactionId) && orderId != null && !"".equals(orderId)) {
            returnCode.put("orderNo", orderId);
            returnCode.put("returnCode", confirmOrderService.confirmApi(transactionId, orderId));
        }
        System.out.println("returnCode => " + returnCode);
        return returnCode;
    }
    
}
