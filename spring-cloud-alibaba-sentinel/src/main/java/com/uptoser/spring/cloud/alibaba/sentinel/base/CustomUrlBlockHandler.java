package com.uptoser.spring.cloud.alibaba.sentinel.base;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义URL限流异常
 * 在默认情况下，URL触发限流后会直接返回:Blocked by Sentinel (flow limiting)
 * 如果希望修改触发限流之后的返回结果形式实现BlockExceptionHandler并且重写handle方法
 *
 * 还有一种场景是，当触发限流之后，我们希望直接跳转到一个降级页面，可以通过下面这个配置来实现:
 * spring.cloud.sentinel.servlet.block-page={url}
 */
@Service
public class CustomUrlBlockHandler implements BlockExceptionHandler{

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        String message = "{\"code\":999,\"msg\":\"访问人数过多\"}";
        httpServletResponse.getWriter().write(message);
    }
}

