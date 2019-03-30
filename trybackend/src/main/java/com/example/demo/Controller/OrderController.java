package com.example.demo.Controller;


import com.example.demo.Entity.Order;
import com.example.demo.Param.orderParam.OrderCancel;
import com.example.demo.Param.orderParam.*;
import com.example.demo.Response.FundamentalResponse;
import com.example.demo.Response.orderResponse.orderState;
import com.example.demo.Response.orderResponse.showOrder;
import com.example.demo.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;
    //
    @PostMapping(value = "/orderPend",
            consumes = {"application/json", "application/xml"}
    )
    public FundamentalResponse createOrder(@RequestBody OrderPend orderPend){
        service.createOrder(orderPend.patentID,orderPend.price,orderPend.startTime,orderPend.endTime);
        return new FundamentalResponse(true);
    }

    @PostMapping(value = "/details")
    public showOrder showorderDetails(@RequestBody OrderCancel order){
        return service.showdetails(order.getPatentID());
    }

    @PostMapping(value = "/cancelPend",
            consumes = {"application/json", "application/xml"}
    )
    public void cancelOrder(@RequestBody OrderCancel order){
        service.cancelOrder(order.getPatentID());
    }

    @PostMapping(value = "/updatePend",
            consumes = {"application/json", "application/xml"}
    )
    public void updateOrder(@RequestBody OrderUpdate order){
        service.priceReset(order.getPatentID(),order.getPrice());
    }

    @GetMapping(value = "/cheOrderState",
            consumes = {"application/json", "application/xml"}
    )
    @ResponseBody
    public orderState updateOrder(@RequestBody OrderStateCheck order){
        int state = service.checkOrderState(order.getPatentID());
        orderState st = new orderState();
        st.setState(state);
        return st;
    }

    @GetMapping(value = "/orders")
    @ResponseBody
    public Order[] getOrders(){
        List<Order> lists = service.findAllValueableOrder();
        Order[] orders = new Order[lists.size()];
        for(int i = 0;i<orders.length;i++){
            orders[i] = lists.get(i);
        }
        return orders;
    }
}
