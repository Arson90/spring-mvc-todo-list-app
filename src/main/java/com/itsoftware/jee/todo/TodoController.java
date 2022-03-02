package com.itsoftware.jee.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	private final TodoDAOImpl todoDAOImpl;

	@Autowired
	public TodoController(TodoDAOImpl todoDAOImpl) {
		this.todoDAOImpl = todoDAOImpl;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/listTodos", method = RequestMethod.GET)
	public String getTodo(ModelMap model) {
		model.addAttribute("listTodos", todoDAOImpl.getAllTodos());
		return "list-todo";
	}
	
	@RequestMapping(value = "/addTodo", method = RequestMethod.GET)
	public String showFormAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@RequestMapping(value = "/addTodo", method = RequestMethod.POST)
	public String addTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoDAOImpl.addTodo(todo);
		model.clear();
		return "redirect:listTodos";
	}

	@RequestMapping(value="/edit-todo", method = RequestMethod.GET)
    public String edit(@RequestParam int id, ModelMap model){
        Todo todo = todoDAOImpl.getTodo(id);
        model.addAttribute("todo",todo);
        return "edit-todo-form";
    }

	@RequestMapping(value="/edit-todo", method = RequestMethod.POST)
    public String edit(@Valid Todo todo, BindingResult result, ModelMap model){
		if(result.hasErrors()) {
			return "edit-todo-form";
		}
		todoDAOImpl.updateTodo(todo);
        model.clear();
        return "redirect:listTodos";
    }

	@RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, ModelMap model) {
		todoDAOImpl.deleteTodo(id);
		model.clear();
		return "redirect:listTodos";
	}
}







