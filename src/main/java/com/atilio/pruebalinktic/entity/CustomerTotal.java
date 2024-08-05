package com.atilio.pruebalinktic.entity;

import java.util.List;

public class CustomerTotal {
    private CustomerInputData customerInputData;
    private List<Settlement> settlements;
    private float totalPremium;

    public CustomerInputData getCustomerInputData() {
        return customerInputData;
    }

    public void setCustomerInputData(CustomerInputData customerInputData) {
        this.customerInputData = customerInputData;
    }

    public List<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<Settlement> settlements) {
        this.settlements = settlements;
    }

    public CustomerTotal(CustomerInputData customerInputData, List<Settlement> settlements) {
        this.customerInputData = customerInputData;
        this.settlements = settlements;
    }

    public float getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(float totalPremium) {
        this.totalPremium = totalPremium;
    }

    public void getTotalSettlement() {
        float totalPremium = 0f;
        for (Settlement settlement:settlements) {
            totalPremium += settlement.premium();
        }
       this.totalPremium =  totalPremium;
    }
}