//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//package in.ragupathi.todoapp.repository;
//
//import in.ragupathi.todoapp.entity.TodoEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
//
////}
//@Service
//@RequiredArgsConstructor
//public class TodoService {
//
//    private final TodoRepository todoRepository;
//
//    public List<TodoEntity> getAllTodos() {
//        return todoRepository.findAll();
//    }
//
//    public void addTodo(String title) {
//        TodoEntity todo = TodoEntity.builder()
//                .title(title)
//                .build();
//        todoRepository.save(todo);
//    }
//
//    public void toggleComplete(Long id) {
//        TodoEntity todo = todoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Todo not found"));
//        todo.setCompleted(!todo.isCompleted());
//        todoRepository.save(todo);
//    }
//
//    public void deleteTodo(Long id) {
//        todoRepository.deleteById(id);
//    }
//}
package in.ragupathi.todoapp.repository;

import in.ragupathi.todoapp.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}