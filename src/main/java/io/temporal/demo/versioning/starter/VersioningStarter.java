package io.temporal.demo.versioning.starter;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.demo.versioning.model.Account;
import io.temporal.demo.versioning.model.Customer;
import io.temporal.demo.versioning.worker.VersioningWorkflowWorker;
import io.temporal.demo.versioning.workflow.CustomerWorkflow;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.time.Duration;

public class VersioningStarter {
    public static final WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
    public static final WorkflowClient client = WorkflowClient.newInstance(service);

    public static void main(String[] args) {
        Customer customer = new Customer("c1", "John", "john@john.com", "new", Duration.ofMinutes(2));
        WorkflowOptions newCustomerWorkflowOptions =
                WorkflowOptions.newBuilder()
                        .setWorkflowId(customer.getAccountNum())
                        .setTaskQueue(VersioningWorkflowWorker.TASK_QUEUE)
                        .build();
        CustomerWorkflow newCustomerWorkflow = client.newWorkflowStub(CustomerWorkflow.class, newCustomerWorkflowOptions);

        Account account = newCustomerWorkflow.execute(customer);

        System.out.println("Account amount: " + account.getAmount());
    }
}
