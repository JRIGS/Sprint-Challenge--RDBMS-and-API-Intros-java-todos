package com.lambdaschool.todos.services;


import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos myTodo = todosRepository.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found"));
        myTodo.setCompleted(true);
    }
}
