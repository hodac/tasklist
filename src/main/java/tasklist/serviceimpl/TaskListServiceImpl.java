/**
 * 
 */
package tasklist.serviceimpl;

import java.util.List;

import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tasklist.entity.TaskList;
import tasklist.service.TaskListService;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Service
@Transactional
public class TaskListServiceImpl implements TaskListService {

  @Autowired
  private CurrentSessionContext sessionContext;
  
  @SuppressWarnings("unchecked")
  public List<TaskList> nactiVsechny() {
    return sessionContext.currentSession().createCriteria(TaskList.class).list();
  }
  
  public void uloz(TaskList list) {
    sessionContext.currentSession().persist(list);
  }
  
  public TaskList nactiDleIdSTasky(long taskListId) {
    return (TaskList) sessionContext.currentSession().createQuery("SELECT l FROM TaskList l LEFT JOIN FETCH l.tasks WHERE l.id=:taskListId")
            .setParameter("taskListId", taskListId).uniqueResult();
  }
  
}
