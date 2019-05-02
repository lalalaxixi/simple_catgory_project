package catgoryapp.inventorydao;

import catgoryapp.inventorydao.Inventory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;

@Repository
@Transactional

public class InventoryRepositoryImplem implements InventoryRepositoryCustom{
  @PersistenceContext
  EntityManager entityManager;

  @Transactional
  @Override
  public void deleteInvById(Integer id){
    Inventory invt=entityManager.find(Inventory.class,id);
    if(invt!=null){
      entityManager.remove(invt);
    }
  }
}
