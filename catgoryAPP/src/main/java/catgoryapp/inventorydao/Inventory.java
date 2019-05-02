package catgoryapp.inventorydao;

import javax.persistence.*;
import catgoryapp.catgorydao.Catgory;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "inventory", schema="spring_data_jpa_example")

public class Inventory {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "catgoryid")
   private Integer catgoryid;


   public Integer getID(){
     return id;
   }
   public void setID(Integer id){
     this.id=id;
   }
   public String getName(){
     return name;
   }
   public void setName(String name){
     this.name=name;
   }
   public Integer getCatgoryId(){
     return catgoryid;
   }
   public void getCatgoryId(Catgory  catgory){
     this.catgoryid=catgoryid;
   }
}
