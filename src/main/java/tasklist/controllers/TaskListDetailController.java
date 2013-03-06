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
import tasklist.service.TaskListService;
import tasklist.service.TaskService;

/**
* @author Hodac Jan
* @version $Revision$
*/

@Controller
@RequestMapping("/taskListDetail")
public class TaskListDetailController {
  
  @Autowired
  private TaskService taskService;
  
  @Autowired
  private TaskListService taskListService;
  
  @RequestMapping(value = "/{taskListId}", method = RequestMethod.GET)
  public String nactiListSTasky(@PathVariable long taskListId, Model model) {
    model.addAttribute("taskList", taskListService.nactiDleIdSTasky(taskListId));
    if (!model.containsAttribute("task")) {
      model.addAttribute("task", new Task());
    }
    return "taskListDetail";
  }
  
  @RequestMapping(value = "/{taskListId}", method = RequestMethod.POST)
  public String addTask(@PathVariable long taskListId, Task task) {
    task.setTaskListId(taskListId);
    taskService.uloz(task);
    return "redirect:/taskListDetail/" + task.getTaskListId();
  }
  
  @RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
  public String delTask(@PathVariable long taskId) {
    long taskListId = taskService.deleteTask(taskId);
    return "redirect:/taskListDetail/" + taskListId;
  }
}
