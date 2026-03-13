package org.acme.domain.repository;

import org.acme.domain.models.Todo;

public interface TodoRepository {
    Todo save(Todo todo);
}
