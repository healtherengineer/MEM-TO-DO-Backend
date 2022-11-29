package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getByCategoryId(int id);

    Category getByName(String name);

    @Query("")
    List<ToDo> getTodosByCategoryId(int id);
    //Category e göre to-do ları listeleyen birşeye ihtiyaç duyabiliriz.Sorgusu sonra yazılacak.
}
