/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.fiter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyCORSFilter implements Filter{  
	  
    @Override  
    public void destroy() {  
          
    }  
  
    @Override  
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
            HttpServletResponse response = (HttpServletResponse) res;  
            response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020"); //绑定固定域被访问 
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
            response.setHeader("Access-Control-Max-Age", "3600");  
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.setHeader("Access-Control-Allow-Credentials","true");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
            response.setHeader("Content-Type", "application/json;charset=utf-8");
            chain.doFilter(req, res);  
          
    }  
  
    @Override  
    public void init(FilterConfig arg0) throws ServletException {  
          
    }

}
