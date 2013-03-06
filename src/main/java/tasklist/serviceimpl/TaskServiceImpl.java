/**
 * 
 */
package tasklist.serviceimpl;

import java.util.List;

import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tasklist.entity.Task;
import tasklist.service.TaskService;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

  @Autowired
  private CurrentSessionContext sessionContext;
  
  @SuppressWarnings("unchecked")
  public List<Task> nactiDleTaskListId(Long taskListId) {
    return sessionContext.currentSession().createQuery("SELECT t FROM Task t WHERE t.taskListFxid=:taskListId")
            .setParameter("taskListId", taskListId).list();
  }
  
  public Task nactiDleId(Long taskId) {
    return (Task) sessionContext.currentSession().get(Task.class, taskId);
  }

  public void uloz(Task task) {
    if (task.getId() == null) {
      sessionContext.currentSession().persist(task);
    } else {
      sessionContext.currentSession().merge(task);
    }
  }

  public Long deleteTask(Long taskId) {
    Task task = nactiDleId(taskId);
    sessionContext.currentSession().delete(task);
    return task.getTaskListId();
  }

}
