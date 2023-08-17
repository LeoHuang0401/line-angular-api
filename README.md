# line-anular-api
利用Spring Boot來實作模擬一家咖啡簡餐店的行動預點功能的後端api!  
搭配Repository - angular-line angular前端框架  

# 頁面功能說明：
`OrderController` - 呈現菜單頁面資訊、呈現商品詳細資訊及加入購物車功能api

`ShopCarController` - 呈現購物車頁面資訊、調整數量功能api

`OrderCheckController` - 接受前端選取取餐時間及統整購物車頁面資料api

`OrderCheckPay` - 統整最終訂單資訊api

`ConfirmOrderController` - 實作Line Pay Api功能(Request API、Confirm API)

`SucessPayController` - 呈現訂單完成詳細資訊api

`OrderHistoryController` - 呈現歷史訂單資訊api

`OrderHistoryDetailController` - 呈現歷史指定訂單的詳細資訊

# API URL 列表：
- 商品頁面
```
/angular/order
```
- 商品詳細資訊
```
/angular/order/orderData
```
- 將商品加入購物車
```
/angular/order/checkToShopCar
```
- 購物車畫面
```
/angular/shopCar
```
- 購物車移除商品
```
/angular/shopCar/remove
```
- 購物車新增、減少商品數量
```
/angular/shopCar/edit
```
- 確認明細及選擇取餐時間
```
/orderCheck
```
- 確認付款
```
/orderCheckPay
```
- LINE PAY RequestAPI
```
/angular/confirmOrder/checkLinePay
```
- LINE PAY ConfirmAPI
```
/angular/confirmOrder/checkPay
```
- 付款成功頁面
```
/sucessPay
```
- 過去訂單紀錄
```
/angular/orderHistory
```
- 過去訂單記錄(詳細資料)
```
/angular/orderHistoryDetail
```

# 資料庫使用
- Oracle 19c
- Mybatis

# 前端頁面
- angular-line(https://github.com/LeoHuang0401/angular-line)
