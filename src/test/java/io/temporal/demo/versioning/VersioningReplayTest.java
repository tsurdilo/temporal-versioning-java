package io.temporal.demo.versioning;

import io.temporal.demo.versioning.workflow.CustomerWorkflowImpl;
import io.temporal.testing.WorkflowReplayer;
import org.junit.Test;
public class VersioningReplayTest {

    @Test
    public void testInitVersionReplay() throws Exception {
        WorkflowReplayer.replayWorkflowExecutionFromResource(
                "initversioneventhistory.json", CustomerWorkflowImpl.class);
    }

    @Test
    public void testV1VersionReplay() throws Exception {
        WorkflowReplayer.replayWorkflowExecutionFromResource(
                "v1eventhistory.json", CustomerWorkflowImpl.class);
    }
}
