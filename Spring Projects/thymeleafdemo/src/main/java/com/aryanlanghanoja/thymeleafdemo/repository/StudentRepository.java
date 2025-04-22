package com.aryanlanghanoja.thymeleafdemo.repository;
import org.springframework.data.repository.CrudRepository;
import com.aryanlanghanoja.thymeleafdemo.beans.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    
}
