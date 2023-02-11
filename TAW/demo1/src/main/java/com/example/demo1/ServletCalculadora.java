package com.example.demo1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class ServletCalculadora {

    protected void  procesar(HttpServletRequest request, HttpServletResponse response) {
        String str;
        double op1, op2, resultado=0.0;
        char operacion;

        str = request.getParameter("op1");
        op1= Double.parseDouble(str);

        str = request.getParameter("op2");
        op2= Double.parseDouble(str);

        //Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(param)
    }
}
