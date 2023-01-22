package com.task.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.allocation.exceptionhandling.TaskException;
import com.task.allocation.model.Tasks;
import com.task.allocation.repo.TaskRepo;

@Service
public class TaskAllocationService {

	
	@Autowired
	TaskRepo taskrepo;
	
	public Tasks savetask(Tasks task)
	{
	return	taskrepo.save(task);
	}
	
	
	public Tasks upDateTasks(Tasks task)throws TaskException
	{
		Tasks oldtask=taskrepo.findByName(task.getName());
		
		if(oldtask==null)
		{
			throw new TaskException("task not found");
		}
		
		oldtask.setAssignee(task.getAssignee());
		oldtask.setStart_date(task.getStart_date());
		oldtask.setEnd_date(task.getEnd_date());
		oldtask.setComments(task.getComments());
		return taskrepo.save(oldtask);
		

	}
	
	public List<Tasks>getTasks()
	{
		return taskrepo.findAll();
	}
	
	public Tasks deleteTask(String name)
	{
		Tasks oldtask=taskrepo.findByName(name);
		taskrepo.delete(oldtask);
		return oldtask;
	}
	
	public List<Tasks>  getTaskByName(String name)
	{
		String query=".*"+name+".*";
		List<Tasks> oldtasks=taskrepo.findByNameRegex(query);
		
		return oldtasks;
	}
}
