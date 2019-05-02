package catgoryapp.catgorydao;

import catgoryapp.catgorydao.Catgory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

@Repository
@Transactional(readOnly = true)
public class CatgoryRepositoryImplem implements CatgoryRepositoryCustom{
  @PersistenceContext
  EntityManager entityManager;


  @Override
  public Catgory getById(Integer parentid){
    Query curr_query=entityManager.createNativeQuery("SELECT * FROM catgory WHERE id= ?");
    curr_query.setParameter(1,parentid);

    return (Catgory) curr_query.getSingleResult();
  }
}
