package catgoryapp.inventorydao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import catgoryapp.inventorydao.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer>, InventoryRepositoryCustom{

}
