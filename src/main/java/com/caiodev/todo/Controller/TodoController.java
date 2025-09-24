package com.caiodev.todo.Controller;

import com.caiodev.todo.DTO.TodoDTO;
import com.caiodev.todo.Model.Entity.TodoModel;
import com.caiodev.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<TodoModel> cadastrar(@RequestBody TodoDTO todoDTO){
        return ResponseEntity.ok(todoService.criar(new TodoModel(todoDTO)));
    }

}
