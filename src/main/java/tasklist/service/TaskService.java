/**
 * 
 */
package tasklist.service;

import java.util.List;

import tasklist.entity.Task;

/**
* @author Hodac Jan
* @version $Revision$
*/

public interface TaskService {
  
  List<Task> nactiDleTaskListId(Long taskListId);

  Task nactiDleId(Long taskId);
  
  void uloz(Task task);
  
  Long deleteTask(Long taskId);
  
}
