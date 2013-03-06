/**
 * 
 */
package tasklist.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Entity
public class TaskList {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 50)
  private String nazev;

  @OneToMany
  @OrderBy(value = "id")
  @JoinColumn(name = "taskListId")
  private List<Task> tasks = new ArrayList<Task>();
  
  public TaskList() {
  }
  
  public Long getId() {
    return id;
  }

  public List<Task> getTasks() {
    return tasks;
  }
  
  public void setNazev(String nazev) {
    this.nazev = nazev;
  }
  
  public String getNazev() {
    return nazev;
  }
}
