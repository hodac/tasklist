/**
 * 
 */
package tasklist.service;

import java.util.List;

import tasklist.entity.TaskList;

/**
* @author Hodac Jan
* @version $Revision$
*/

public interface TaskListService {
  
  List<TaskList> nactiVsechny();
  
  TaskList nactiDleIdSTasky(long taskListId);

  void uloz(TaskList list);


}
