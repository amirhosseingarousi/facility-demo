package ir.dotin.facilitiesdemo.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "legal_customer")
public class LegalCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @Column(name = "economic_code")
    private String economicCode;

    @Column(name = "number")
    private String number;

    public LegalCustomer() {
    }

    public LegalCustomer(String companyName, LocalDate registerDate, String economicCode) {
        this.companyName = companyName;
        this.registerDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalCustomer(int id, String companyName, LocalDate registerDate, String economicCode, String number) {
        this.id = id;
        this.companyName = companyName;
        this.registerDate = registerDate;
        this.economicCode = economicCode;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }
}
