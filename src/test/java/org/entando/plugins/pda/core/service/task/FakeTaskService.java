package org.entando.plugins.pda.core.service.task;

import java.util.ArrayList;
import java.util.List;
import org.entando.keycloak.security.AuthenticatedUser;
import org.entando.plugins.pda.core.engine.Connection;
import org.entando.plugins.pda.core.exception.TaskNotFoundException;
import org.entando.plugins.pda.core.model.FakeTask;
import org.entando.plugins.pda.core.model.Task;
import org.entando.web.request.PagedListRequest;
import org.entando.web.response.PagedMetadata;
import org.entando.web.response.PagedRestResponse;
import org.springframework.stereotype.Service;

@Service
public class FakeTaskService implements TaskService {

    public static final String TASK_ID_1 = "1";
    public static final String TASK_NAME_1 = "Task 1";
    public static final String TASK_SUBJECT_1 = "Task Subject 1";

    public static final String TASK_ID_2 = "2";
    public static final String TASK_NAME_2 = "Task 2";
    public static final String TASK_SUBJECT_2 = "Task Subject 2";

    @Override
    public PagedRestResponse<Task> list(Connection connection, AuthenticatedUser user,
            PagedListRequest restListRequest) {
        return new PagedRestResponse<>(new PagedMetadata<>(restListRequest, createTasks()));
    }

    @Override
    public Task get(Connection connection, AuthenticatedUser user, String id) {
        for (Task task : createTasks()) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        throw new TaskNotFoundException();
    }

    private List<Task> createTasks() {
        List<Task> result = new ArrayList<>();

        result.add(FakeTask.builder()
                .id(TASK_ID_1)
                .name(TASK_NAME_1)
                .extraProperty("subject", TASK_SUBJECT_1)
                .build());

        result.add(FakeTask.builder()
                .id(TASK_ID_2)
                .name(TASK_NAME_2)
                .extraProperty("subject", TASK_SUBJECT_2)
                .build());

        return result;
    }
}
