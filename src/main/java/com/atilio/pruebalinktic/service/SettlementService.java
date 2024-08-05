package com.atilio.pruebalinktic.service;

import com.atilio.pruebalinktic.entity.*;
import com.atilio.pruebalinktic.repository.CustomerRepository;
import com.atilio.pruebalinktic.repository.PremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Calendar.*;

@Service
public class SettlementService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PremiumRepository premiumRepository;

    public Customer findCustomer(CustomerInputData customerInputData) {
        try {
            DocumentTypes documentType = DocumentTypes.valueOf(customerInputData.tipoIdentificacion().toUpperCase());
            int docType = documentType.ordinal() + 1;
            CustomerId customerId = new CustomerId(customerInputData.nroIdentificacion(), docType);
            return customerRepository.findById(customerId).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Premiums> findPremiumsAux(int customerAge) {
        return premiumRepository.findByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(customerAge, customerAge);
    }

    public List<Premiums> findPremiums(Customer customer) {
        int customerAge = this.getCustomerAge(customer.getBirthDate());
        return premiumRepository.findByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(customerAge, customerAge);
    }

    public CustomerTotal calculateTotalSettlement(CustomerInputData customerInputData) {
        Customer customer = this.findCustomer(customerInputData);
        if (customer == null) {
            return null;
        }
        List<Premiums> premiums = findPremiums(customer);
        List<Settlement> settlementList = new ArrayList<>();
        for (Premiums premium : premiums) {
            float premiumValue = this.calculatePremiumValue(customerInputData.valorAsegurado(), premium.getPremiumPercentage());
            settlementList.add(new Settlement(premium.getProtection(), premiumValue));
        }
        CustomerTotal customerTotal = new CustomerTotal(customerInputData, settlementList);
        customerTotal.getTotalSettlement();
        return customerTotal;

    }

    public float calculatePremiumValue(float insuranceValue, float percentagePremium) {
        return insuranceValue * percentagePremium;
    }

    public int getCustomerAge(Date customerBithDate) {
        Date today = new Date();
        return getDiffYears(customerBithDate, today);
    }

    private static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }


}