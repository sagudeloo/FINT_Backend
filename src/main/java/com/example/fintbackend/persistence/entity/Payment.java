/*package com.example.fintbackend.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer idPayment;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "cv_number")
    private Integer cvNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvNumber() {
        return cvNumber;
    }

    public void setCvNumber(Integer cvNumber) {
        this.cvNumber = cvNumber;
    }
}


 */