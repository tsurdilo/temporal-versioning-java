package io.temporal.demo.versioning.workflow;

import io.temporal.demo.versioning.model.Account;
import io.temporal.demo.versioning.model.Customer;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface CustomerWorkflow {
    @WorkflowMethod
    Account execute(Customer customer);
}
