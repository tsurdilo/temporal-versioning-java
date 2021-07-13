package io.temporal.demo.versioning.worker;

import io.temporal.client.WorkflowClient;
import io.temporal.demo.versioning.activities.CustomerActivitiesImpl;
import io.temporal.demo.versioning.workflow.CustomerWorkflowImpl;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class VersioningWorkflowWorker {
    public static final String TASK_QUEUE = "versioningTaskQueue";
    private static final WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
    private static final WorkflowClient client = WorkflowClient.newInstance(service);
    private static final WorkerFactory factory = WorkerFactory.newInstance(client);

    public static void main(String[] args) {
        try {
            Worker worker = factory.newWorker(TASK_QUEUE);
            worker.registerWorkflowImplementationTypes(CustomerWorkflowImpl.class);
            worker.registerActivitiesImplementations(new CustomerActivitiesImpl());

            factory.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
