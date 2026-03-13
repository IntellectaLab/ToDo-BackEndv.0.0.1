package org.acme.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.application.dto.CreateTodoDto;
import org.acme.domain.models.Todo;
import org.acme.domain.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CreateTodoUseCase {

    private final TodoRepository todoRepository;

    @Inject
    public CreateTodoUseCase(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo execute(CreateTodoDto todoDto) {
        Todo todo=new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setId(UUID.randomUUID());
        todo.setCreatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }
}
