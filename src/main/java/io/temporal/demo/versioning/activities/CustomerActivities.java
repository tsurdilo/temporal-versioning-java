package io.temporal.demo.versioning.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.demo.versioning.model.Account;
import io.temporal.demo.versioning.model.Customer;

@ActivityInterface
public interface CustomerActivities {
    boolean checkCustomerAccount(Customer customer);
    Account getCustomerAccount(Customer customer);
    Account updateCustomerAccount(Account account, int amount, String message);
    void sendBonusEmail(Customer customer, String message);
}
