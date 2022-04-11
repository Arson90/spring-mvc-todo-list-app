package com.itsoftware.jee.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

	private final TodoDAO todoDAO;

	@Autowired
	public TodoController(TodoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String getTodo(@RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, ModelMap model) {
		model.addAttribute("listTodos", todoDAO.getAllTodos(PageRequest.of(pageNumber-1,10, Sort.by(sort))));
		model.addAttribute("page", todoDAO.countingPages());
		model.addAttribute("name", name);
		model.addAttribute("currentPageNumber", pageNumber);
		model.addAttribute("sort", sort);
		return "list-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showFormAddTodo(@RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, ModelMap model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("name", name);
		model.addAttribute("currentPageNumber", pageNumber);
		model.addAttribute("sort", sort);
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, @Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoDAO.addTodo(todo);
		model.addAttribute("name", name);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("sort", sort);
		return "redirect:list-todos";
	}

	@RequestMapping(value="/edit-todo", method = RequestMethod.GET)
    public String edit(@RequestParam int id, @RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, ModelMap model){
        Todo todo = todoDAO.getTodo(id);
        model.addAttribute("todo",todo);
		model.addAttribute("name", name);
		model.addAttribute("currentPageNumber", pageNumber);
		model.addAttribute("sort", sort);
        return "edit-todo-form";
    }

	@RequestMapping(value="/edit-todo", method = RequestMethod.POST)
    public String edit(@RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, @Valid Todo todo, BindingResult result, ModelMap model){
		if(result.hasErrors()) {
			return "edit-todo-form";
		}
		todoDAO.updateTodo(todo);
		model.addAttribute("name", name);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("sort", sort);
        return "redirect:list-todos";
    }

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, @RequestParam String name, @RequestParam int pageNumber, @RequestParam String sort, ModelMap model) {
		todoDAO.deleteTodo(id);
		model.addAttribute("name", name);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("sort", sort);
		return "redirect:list-todos";
	}
}







