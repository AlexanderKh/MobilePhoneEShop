package ksk.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase implements Comparable{
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal sum;
    private Date date;
    @ManyToOne
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int compareTo(Object o) {
        if (o instanceof Purchase){
            return this.date.compareTo(((Purchase) o).date);
        } else {
            throw new ClassCastException();
        }
    }
}
