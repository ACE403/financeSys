package com.example.validatingforminput.userAuthentication;

import jakarta.persistence.*;

@Entity
@Table(name = "financial_data")
public class FinancialData {

//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Define properties for income, expenses, financial goals, etc.
        private double income;
        private double expenses;
        private double financialGoals;



    // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public double getExpenses() {
            return expenses;
        }

        public void setExpenses(double expenses) {
            this.expenses = expenses;
        }

        public double getFinancialGoals() {
            return financialGoals;
        }

        public void setFinancialGoals(double financialGoals) {
            this.financialGoals = financialGoals;
        }


}