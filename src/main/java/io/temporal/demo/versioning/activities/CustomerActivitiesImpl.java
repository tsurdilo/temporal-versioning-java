package io.temporal.demo.versioning.activities;

import io.temporal.demo.versioning.model.Account;
import io.temporal.demo.versioning.model.Customer;

public class CustomerActivitiesImpl implements CustomerActivities {
    @Override
    public boolean checkCustomerAccount(Customer customer) {
        return true;
    }

    @Override
    public Account getCustomerAccount(Customer customer) {
        // create some dummy account
        Account account = new Account("account-" + customer.getAccountNum(), customer.getAccountNum(),
                "Customer Account", customer);

        return account;
    }

    @Override
    public Account updateCustomerAccount(Account account, int amount, String message) {
        account.updateAmount(amount, message);
        return account;
    }

    @Override
    public void sendBonusEmail(Customer customer, String message) {
        // sending some email via 3rd party libs...
    }
}
