package com.caiodev.todo.Service;

import com.caiodev.todo.Model.Entity.TodoModel;
import com.caiodev.todo.Model.Repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoModel criar(TodoModel todoModel){
       return todoRepository.save(todoModel);
    }

    public List<TodoModel> listar(Long id ){
        buscar(id);
        return todoRepository.findAll();

    }

    public TodoModel buscar(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo não encontrado"));
    }

    public void deletar(Long id){
        todoRepository.deleteById(id);
    }

    public TodoModel atualizar(TodoModel todoModel){
        buscar(todoModel.getId());
        return todoRepository.save(todoModel);
    }




}
