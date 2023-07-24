package tw.com.imsoft.domain.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.imsoft.domain.service.OrderService;
import tw.com.imsoft.domain.vo.angular.OrderDetail;
import tw.com.imsoft.domain.vo.order.OrderData;
import tw.com.imsoft.domain.vo.order.OrderProductDetail;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
    /*
     *  菜單menu
     */
//	@RequestMapping("/order")
//	public ModelAndView order(HttpServletRequest req,String id) {
//	    ModelAndView mv = new ModelAndView("/order");
//	    // 付款畫面回首頁後清除session 資訊
//	    if(req.getSession().getAttribute("takeTime") != null) {
//	        req.getSession().removeAttribute("takeTime");
//	        req.getSession().removeAttribute("orderNo");
//	        req.getSession().removeAttribute("totalPrice");
//	    }
//	    mv.addObject("data",orderService.getProductData());
//	    // 購物車商品數呈現於首頁
//	    List listSize = (List) req.getSession().getAttribute("productData");
//	    if(listSize != null) {
//	        mv.addObject("shopCarNum",listSize.size());
//	    }
//		return mv;
//	}
	
	@CrossOrigin
	@RequestMapping("/angular/order")
    public @ResponseBody List<OrderData> orderTest(HttpServletRequest req,String id) {
	    System.out.println("orderAngular#in");
        return orderService.getProductData();
    }
	
	// 將line資訊加入session
//	@RequestMapping("/order/Line")
//    public void orderLineId(HttpServletRequest req,String id, String name,HttpServletResponse res) {
//        if(!"".equals(id) && req.getSession().getAttribute("uLineId") == null) {
//            req.getSession().setAttribute("uLineId", id);
//            req.getSession().setAttribute("uLineName", name);
//        }
//        res.setStatus(res.SC_OK);
//    }
	
	/*
	 *  商品資訊
	 */
//	@RequestMapping("/order/orderData")
//	public ModelAndView orderData(HttpServletRequest req,String id) {
//	    ModelAndView mv = new ModelAndView("/productDetail");
//	    if(id != null && !"".equals(id)) {
//	        OrderProductDetail detail = orderService.getProductDetail(id);
//	        mv.addObject("detail", detail);
//	        String[] sizeIdData = detail.getProductSizeId().split(",");
//	        String[] sizeData = detail.getProductSizeName().split(",");
//	        String[] priceData = detail.getPrice().split(",");
//	        mv.addObject("noM", sizeIdData[0]);
//            if(sizeIdData.length > 1) {
//                mv.addObject("noL", sizeIdData[1]);
//            }
//	        mv.addObject("sizeM", sizeData[0]);
//	        if(sizeData.length > 1) {
//	            mv.addObject("sizeL", sizeData[1]);
//	        }
//	        mv.addObject("priceM", priceData[0]);
//            if(sizeData.length > 1) {
//                mv.addObject("priceL", priceData[1]);
//            }
//	    }
//	    List listSize = (List) req.getSession().getAttribute("productData");
//        if(listSize != null) {
//            mv.addObject("shopCarNum",listSize.size());
//        }
//	    return mv;
//	}
	
	@RequestMapping("/angular/order/orderData")
    public @ResponseBody OrderDetail orderData(HttpServletRequest req,String id) {
        OrderDetail orderDetail = new OrderDetail();
        if(id != null && !"".equals(id)) {
            OrderProductDetail detail = orderService.getProductDetail(id);
            orderDetail.setOrderDetail(detail);
            String[] sizeIdData = detail.getProductSizeId().split(",");
            String[] sizeData = detail.getProductSizeName().split(",");
            String[] priceData = detail.getPrice().split(",");
            orderDetail.setNoM(sizeIdData[0]);
            if(sizeIdData.length > 1) {
                orderDetail.setNoL(sizeIdData[1]);
            }
            orderDetail.setSizeM(sizeData[0]);
            if(sizeData.length > 1) {
                orderDetail.setSizeL(sizeData[1]);
            }
            orderDetail.setPriceM(priceData[0]);
            if(sizeData.length > 1) {
                orderDetail.setPriceL(priceData[1]);
            }
        }
        List listSize = (List) req.getSession().getAttribute("productData");
        if(listSize != null) {
            orderDetail.setListSize(listSize.size());
        }
        
        return orderDetail;
    }

	/*
	 *  商品加入購物車 加(session)
	 */
//	@PostMapping("/order/checkToShopCar")
//	public void checkToShopCar(HttpServletRequest req,HttpServletResponse res) {
//	    orderService.checkToShopCar(req);
//	    try {
//            res.sendRedirect("../order");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//	}
	
	@PostMapping("/angular/order/checkToShopCar")
    public @ResponseBody List<OrderToShopCar> checkToShopCar(HttpServletRequest req,@RequestBody OrderToShopCar orderToShopCar) {
	    System.out.println("checkToShopCar#start");
	    System.out.println("orderToShopCar => " + orderToShopCar);
       return orderService.checkToShopCar(req,orderToShopCar);
//        try {
//            res.sendRedirect("../order");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
