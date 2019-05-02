package catgoryapp.catgorydao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import catgoryapp.catgorydao.Catgory;

import java.util.List;


@Repository
public interface CatgoryRepository extends JpaRepository<Catgory,String>, CatgoryRepositoryCustom{

}
