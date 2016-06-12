package org.tgo.expense;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tgo.expense.model.Expense;

@WebServlet(urlPatterns = { "/expense" }, name = "ExpenseServlet")
public class ExpenseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String descricao = req.getParameter("descricao");
        String local = req.getParameter("local");
        String valor = req.getParameter("valor");
      
        Date data = null;
        
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("data"));
        } catch (ParseException e) {
            throw new IllegalArgumentException("A data deve estar no formato dd/mm/aaaa");
        }

        Expense expense = new Expense(descricao, local, new Double(valor),data);
        ExpenseRepository.getInstance().save(expense);
    }

}
