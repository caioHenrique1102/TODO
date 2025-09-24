package com.caiodev.todo.Model.Entity;
import com.caiodev.todo.DTO.TodoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int prioridade;
    private boolean status;

    public TodoModel(TodoDTO todoDTO) {
        this.nome = todoDTO.nome();
        this.descricao = todoDTO.descricao();
        this.prioridade = todoDTO.prioridade();

    }
}
