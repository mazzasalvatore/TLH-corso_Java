package com.corso.web.general;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class AListener implements ServletRequestListener {

  

    public void requestDestroyed(ServletRequestEvent sre)  { 
     	System.out.println("Request distrutta; " + ((HttpServletRequest)sre.getServletRequest()).getRequestURI());
         }

    public void requestInitialized(ServletRequestEvent sre)  { 
     	System.out.println("Request inizializzata; " + ((HttpServletRequest)sre.getServletRequest()).getRequestURI());
    }

}
