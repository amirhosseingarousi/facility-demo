package ir.dotin.facilitiesdemo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rate")
    private double rate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id")
    private List<GrantCondition> conditions = new ArrayList<>();

    public Loan() {
    }

    public Loan(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<GrantCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<GrantCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", conditions=" + conditions +
                '}';
    }
}
