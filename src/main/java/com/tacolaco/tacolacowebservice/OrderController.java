package com.tacolaco.tacolacowebservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    public static Map<String, Double> tacos;
    static {
        tacos = new HashMap<>();
        tacos.put("Veggie Taco", 2.50);
        tacos.put("Chicken Taco", 3.00);
        tacos.put("Beef Taco", 3.00);
        tacos.put("Chorizo Taco", 3.50);
    }
    @PostMapping(path = "/getOrderTotal")
    public String getOrderTotal(@RequestBody List<Order> orderList) {

        Iterator<Order> it = orderList.iterator();
        double total = 0.0;
        int totalQuantity = 0;
        while (it.hasNext()){
            Order o = it.next();
            total = total + tacos.get(o.getName())*o.getQuantity();
            totalQuantity += o.getQuantity();
        }
        if(totalQuantity>=4)
            total *= 0.8;
        String totalStr = String.format("%.02f", total);
        return totalStr;
    }
}
