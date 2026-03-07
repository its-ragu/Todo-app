//
//package in.ragupathi.todoapp.controller;
//
//import in.ragupathi.todoapp.entity.TodoEntity;
//import in.ragupathi.todoapp.repository.TodoRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@RequiredArgsConstructor
//@Controller
//public class TodoController {
//
//    private final TodoRepository todoRepository;
//
//   @GetMapping({"","/","/home"})
//       public String showHomePage(Model model){
//        model.addAttribute("todos",todoRepository.findAll());
//        return "index";
//    }
//    @PostMapping("/add")
//    public String add(@RequestParam String title){
//       TodoEntity newTodo= TodoEntity.builder()
//                .title(title)
//                .completed(false)
//                .build();
//       todoRepository.save(newTodo);
//       return "redirect:/";
//    }
//
//    @GetMapping("/update/{id}")
//    public String update(@PathVariable Long id){
//       TodoEntity existingTodo= todoRepository.findById(id)
//                .orElseThrow(()->new RuntimeException("Todo not found:"+id));
//        existingTodo.setCompleted(true);
//        todoRepository.save(existingTodo);
//        return "redirect:/";
//    }
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id){
//        TodoEntity existingTodo= todoRepository.findById(id)
//                .orElseThrow(()->new RuntimeException("Todo not found:"+id));
//        todoRepository.delete(existingTodo);
//        return "redirect:/";
//    }
//}

package in.ragupathi.todoapp.controller;

import in.ragupathi.todoapp.entity.TodoEntity;
import in.ragupathi.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping({"", "/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title) {
        TodoEntity newTodo = TodoEntity.builder()
                .title(title)
                .completed(false)
                .build();
        todoRepository.save(newTodo);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        TodoEntity existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found: " + id));
        existingTodo.setCompleted(!existingTodo.isCompleted());  // toggle instead of hardcoding true
        todoRepository.save(existingTodo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);  // no need to fetch entity first
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        TodoEntity existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found: " + id));
        model.addAttribute("todo", existingTodo);
        return "edit";
    }


    @PostMapping("/edit/{id}")
    public String editSave(@PathVariable Long id, @RequestParam String title) {
        TodoEntity existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found: " + id));
        existingTodo.setTitle(title);
        todoRepository.save(existingTodo);
        return "redirect:/";
    }
}
