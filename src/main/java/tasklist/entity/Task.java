/**
 * 
 */
package tasklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Entity
public class Task {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 50)
  private String text;
  
  private boolean done;
  
  private String priority;

  private Long taskListId;
  
  public Task() {
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
  
  
  public void setDone(boolean done) {
    this.done = done;
  }
  
  public boolean isDone() {
    return done;
  }
  
  public void setPriority(String priority) {
    this.priority = priority;
  }
  
  public String getPriority() {
    return priority;
  }
  
  public void setTaskListId(Long taskListId) {
    this.taskListId = taskListId;
  }
  
  public Long getTaskListId() {
    return taskListId;
  }
}
