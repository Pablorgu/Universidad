package com.example.demo1;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String str;
        double op1, op2, resultado = 0.0;
        char operacion;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        str = request.getParameter("op1");
        op1= Double.parseDouble(str);

        str = request.getParameter("op2");
        op2= Double.parseDouble(str);

        str = request.getParameter("operacion");
        operacion = str.charAt(0);
        //Hello
        out.println("<html><body>");

        switch (operacion) {
            case '+':
                resultado = op1 + op2;
                break;
            case '-':
                resultado = op1 - op2;
                break;
            case '*':
                resultado = op1 * op2;
                break;
            case '/':
                resultado = op1 / op2;
                break;
            default:
                System.out.println("Ningun operador seleccionado");
        }

        request.setAttribute("result", resultado);

        RequestDispatcher rd = request.getRequestDispatcher("calculadora.jsp");
        rd.forward(request,response);

    }

    public void destroy() {
    }
}