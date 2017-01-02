package org.tgo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "expense")
@NamedQueries({
        @NamedQuery(name = "Expense.getAll", query = "SELECT e FROM Expense e") })
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "expenseIdGenerator")
    @TableGenerator(name = "expenseIdGenerator", table = "id_table")
    private int id;

    private String descricao;
    private String local;
    private double valor;

    @ManyToMany
    @JoinTable(
            name = "expense_category", 
            joinColumns = @JoinColumn(name = "expense"),
            inverseJoinColumns=@JoinColumn(name="category"))
    private List<Category> categories;

    @Temporal(TemporalType.DATE)
    private Date data;

    public Expense() {
    }

    public Expense(String descricao, String local, double valor, Date data) {
        this.descricao = descricao;
        this.local = local;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
