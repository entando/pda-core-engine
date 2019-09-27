package org.entando.plugins.pda.core.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;

public class FakeTask extends Task {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PROCESS_ID = "processId";
    private static final String PROCESS_INSTANCE_ID = "processInstanceId";
    private static final String CONTAINER_ID = "containerId";

    @Builder
    public FakeTask(String id, String name, String processId, Integer processInstanceId, String containerId,
            @Singular("extraProperty") Map<String,Object> extraProperties) {
        super(new HashMap<>(extraProperties));

        this.data.put(ID, id);
        this.data.put(NAME, name);
        this.data.put(PROCESS_ID, processId);
        this.data.put(PROCESS_INSTANCE_ID, processInstanceId);
        this.data.put(CONTAINER_ID, containerId);
    }

    @Override
    public String getId() {
        return (String) data.get(ID);
    }

    @Override
    public String getName() {
        return (String) data.get(NAME);
    }

    @Override
    public String getProcessId() {
        return (String) data.get(PROCESS_ID);
    }

    @Override
    public String getProcessInstanceId() {
        return (String) data.get(PROCESS_INSTANCE_ID);
    }

    @Override
    public String getContainerId() {
        return (String) data.get(CONTAINER_ID);
    }

}