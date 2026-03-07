////package in.ragupathi.todoapp.entity;
////
////import jakarta.persistence.*;
////import lombok.AllArgsConstructor;
////import lombok.Builder;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////@Entity
////@Table(name = "tbl_todos")
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
////@Builder
////public class TodoEntity {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(nullable = false,unique = true)
////    private String title;
////
////    private Boolean completed;
////
////}
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "tbl_todos")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class TodoEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String title;
//
//    @Column(nullable = false)
//    @Builder.Default
//    private boolean completed = false;
//}
package in.ragupathi.todoapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    @Builder.Default
    private boolean completed = false;
}