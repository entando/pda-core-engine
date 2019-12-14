package org.entando.plugins.pda.core.engine;

import lombok.Builder;
import org.entando.plugins.pda.core.service.group.FakeGroupService;
import org.entando.plugins.pda.core.service.process.FakeProcessService;
import org.entando.plugins.pda.core.service.task.FakeTaskCommentService;
import org.entando.plugins.pda.core.service.task.FakeTaskDefinitionService;
import org.entando.plugins.pda.core.service.task.FakeTaskService;
import org.springframework.stereotype.Component;

@Component
public class FakeEngine extends Engine {
    public static final String TYPE = "fake";

    @Builder
    public FakeEngine(FakeTaskService taskService, FakeTaskDefinitionService taskDefinitionService,
            FakeTaskCommentService taskCommentService, FakeProcessService processService,
            FakeGroupService groupService) {
        super(TYPE, taskService, taskDefinitionService, taskCommentService, processService, groupService);
    }
}