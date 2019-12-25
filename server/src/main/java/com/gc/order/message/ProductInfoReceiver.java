package com.gc.order.message;

import com.alibaba.fastjson.JSONObject;
import com.gc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        List<ProductInfoOutput> productInfoOutput = JSONObject.parseArray(message, ProductInfoOutput.class);
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutput);

        // 储存到redis
        productInfoOutput.forEach(productInfo -> {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfo.getProductId()),
                    String.valueOf(productInfo.getProductStock()));
        });

    }
}
