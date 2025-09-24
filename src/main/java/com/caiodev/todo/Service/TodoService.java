package com.caiodev.todo.Service;

import com.caiodev.todo.Model.Entity.TodoModel;
import com.caiodev.todo.Model.Repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

    public List<TodoModel> listar(){
        Sort sort = Sort.by(Sort.Direction.ASC ,"prioridade" );
        return todoRepository.findAll(sort);
    }

    public TodoModel buscar(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo não encontrado"));
    }

    public void deletar(Long id){
        todoRepository.deleteById(id);
    }

    public TodoModel atualizar(Long id,TodoModel todoModel){
        buscar(id);
        return todoRepository.save(todoModel);
    }

}
