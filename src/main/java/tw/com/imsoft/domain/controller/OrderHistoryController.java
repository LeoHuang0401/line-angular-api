package tw.com.imsoft.domain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.domain.service.OrderHistoryService;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryData;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryDetailData;

/*
 *  過去訂單紀錄
 */
@Controller
public class OrderHistoryController {

    @Autowired
    OrderHistoryService orderHistoryService;
    
//    @RequestMapping("/orderHistory")
//    public ModelAndView getOrderHistory(HttpServletRequest req) {
//        ModelAndView mv = new ModelAndView("/orderHistory");
//        List listSize = (List) req.getSession().getAttribute("productData");
//        if(listSize != null) {
//            mv.addObject("shopCarNum",listSize.size());
//        }
//        if(req.getSession().getAttribute("uLineId") != null) {
//            String memId = req.getSession().getAttribute("uLineId").toString();
//            List<OrderHistoryData> orderHistoryList = orderHistoryService.getOrderHistoryData(memId);
//            mv.addObject("dataList", orderHistoryList);
//        }
//        return mv;
//    }
    @RequestMapping("/angular/orderHistory")
    public @ResponseBody List<OrderHistoryData> getOrderHistory(String uLineD) {
        String memId = uLineD;
        List<OrderHistoryData> orderHistoryList = orderHistoryService.getOrderHistoryData(memId);
        System.out.println("orderHistoryList => " + orderHistoryList);
        return orderHistoryList;
    }
    
//    @PostMapping("/orderHistoryDetail")
//    public ModelAndView getOrderHistoryDetail(HttpServletRequest req,String orderN,String totalPrice,String orderTime) {
//        ModelAndView mv = new ModelAndView("/orderHistoryDetail");
//        List listSize = (List) req.getSession().getAttribute("productData");
//        if(listSize != null) {
//            mv.addObject("shopCarNum",listSize.size());
//        }
//        if(orderN != null && !"".equals(orderN)) {
//            List<OrderHistoryDetailData> detailDataList = orderHistoryService.getOrderHistoryDetailData(orderN);
//            mv.addObject("orderNo",orderN);
//            mv.addObject("totalPrice",totalPrice);
//            mv.addObject("orderTime",orderTime);
//            mv.addObject("detailList",detailDataList);
//        }
//        return mv;
//    }
    @PostMapping("/angular/orderHistoryDetail")
    public @ResponseBody List<OrderHistoryDetailData> getOrderHistoryDetail(@RequestBody String orderNo) {
        List<OrderHistoryDetailData> detailDataList = orderHistoryService.getOrderHistoryDetailData(orderNo);
        return detailDataList;
    }
    
}
