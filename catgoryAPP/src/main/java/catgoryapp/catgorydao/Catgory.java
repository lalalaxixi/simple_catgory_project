package catgoryapp.catgorydao;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "catgory", schema="spring_data_jpa_example")

public class Catgory {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  //obj property
  private Integer id;

  @Column(name = "title")
  private String title;


  @Column(name = "parentid")
  private Integer parentid;
  //get and set for obj property
  public Integer getID(){
    return id;
  }
  public void setID(Integer id){
    this.id=id;
  }

  public String getTitle(){
    return title;
  }
  public void setTitle(String title){
    this.title=title;
  }


  public Integer getPID(){
    return parentid;
  }
  public void setPID(Integer parentid){
    this.parentid=parentid;
  }
}
