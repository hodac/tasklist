/**
 * 
 */
package tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tasklist.entity.TaskList;
import tasklist.service.TaskListService;

/**
* @author Hodac Jan
* @version $Revision$
*/
@Controller
@RequestMapping("/taskList")
public class TaskListController {
  
  @Autowired
  private TaskListService taskListService;
  
  @RequestMapping(method = RequestMethod.GET)
  public void taskListGet(Model model) {
    model.addAttribute("taskLists", taskListService.nactiVsechny());
    if (!model.containsAttribute("taskList")) {
      model.addAttribute("taskList", new TaskList());
    }
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String taskListPost(TaskList taskList) {
    taskListService.uloz(taskList);
    return "redirect:/taskList";
  }
}
