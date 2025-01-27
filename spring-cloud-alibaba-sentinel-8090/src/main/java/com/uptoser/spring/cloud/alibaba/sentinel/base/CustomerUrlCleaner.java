package com.uptoser.spring.cloud.alibaba.sentinel.base;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CustomerUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) {
        if(StringUtils.isEmpty(originUrl)){
            return originUrl;
        }
        if(originUrl.startsWith("/clean/")){
            return "/clean/*";
        }
        return originUrl;
    }
}
