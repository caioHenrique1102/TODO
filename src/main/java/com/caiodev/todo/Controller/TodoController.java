package com.caiodev.todo.Controller;
import com.caiodev.todo.DTO.TodoDTO;
import com.caiodev.todo.Model.Entity.TodoModel;
import com.caiodev.todo.Service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TodoModel> buscar(@PathVariable Long id){
        return ResponseEntity.ok(todoService.buscar(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TodoModel>> listar(){
        return ResponseEntity.ok(todoService.listar());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        todoService.deletar(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<TodoModel> alterar(@PathVariable Long id, @RequestBody TodoDTO todoDTO){
        return ResponseEntity.ok(todoService.atualizar(id, new TodoModel(todoDTO)));
    }

}
