package com.ticket.DTO;

import java.math.BigDecimal;

/**
 * DTO for {@link com.ticket.models.User}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class UserDTO extends AbstractDTO{

    private int city;

    private String name;
    private String moneyAccount;
    private String password;
    private String email;
    private String confirmPassword;

    private BigDecimal balance;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(String moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
