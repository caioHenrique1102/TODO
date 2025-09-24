package com.caiodev.todo.Model.Repository;

import com.caiodev.todo.Model.Entity.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel,Long> {

}
