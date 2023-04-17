package ir.dotin.facilitiesdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "grant_condition")
public class GrantCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "min_year")
    private int minYear;

    @Column(name = "max_year")
    private int maxYear;

    @Column(name = "min_amount")
    private double minAmount;

    @Column(name = "max_amount")
    private double maxAmount;


    public GrantCondition() {
    }

    public GrantCondition(String name, int minYear, int maxYear, double minAmount, double maxAmount) {
        this.name = name;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
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

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(double minAmount) {
        this.minAmount = minAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String toString() {
        return "GrantCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minYear=" + minYear +
                ", maxYear=" + maxYear +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                '}';
    }
}
