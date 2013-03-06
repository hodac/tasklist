/**
 * 
 */
package tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tasklist.entity.Task;
import tasklist.service.TaskService;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Controller
@RequestMapping("/task")
public class TaskController {
  
  @Autowired
  private TaskService taskService;
  
  @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
  public String editTask(@PathVariable long taskId, Model model) {
    model.addAttribute("task", taskService.nactiDleId(taskId));
    return "task";
  }

  @RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
  public String editTask(Task task) {
    taskService.uloz(task);
    return "redirect:/taskListDetail/" + task.getTaskListId();
  }

}
