package com.spring.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pet.entity.Appointment;
import com.spring.pet.global.GlobalData;
import com.spring.pet.service.AppointmentService;
import com.spring.pet.service.CategoryService;
import com.spring.pet.service.ProductService;

@Controller
public class HomeController{
		
		@Autowired
		CategoryService categoryService;
		@Autowired
		ProductService productService;
		
		@Autowired
		AppointmentService appointmentService;
		
		@GetMapping({"/","/home"})
		public String home(Model model){
			
			model.addAttribute("cartCount",GlobalData.cart.size());//for cart
			return "index";
		}
		
		@RequestMapping("/Appointment")
		public String Appointment(Model m)
		{
			Appointment app= new Appointment();
			m.addAttribute("Appointment",app);
			return "Appointment";
		}
		
		@PostMapping("/Appointment/save-app")
		public String saveAppointment(@ModelAttribute("Appointment") Appointment app, ModelAndView modelAndView)
		{
			appointmentService.save(app);
		

			return "redirect:/Appointment";
		}
		
		@GetMapping("/shop")
		public String shop(Model model){
			model.addAttribute("categories",categoryService.getAllCategory());
			model.addAttribute("products",productService.getAllProduct());
			model.addAttribute("cartCount",GlobalData.cart.size());// for cart
			
			return "shop";
		}
		@GetMapping("/shop/category/{id}")
		public String shopByCategory(Model model,@PathVariable int id){
			model.addAttribute("categories",categoryService.getAllCategory());
			model.addAttribute("cartCount",GlobalData.cart.size());//for cart
			model.addAttribute("products",productService.getAllProductsByCategoryId(id));
			return "shop";
		}
		
		
		@GetMapping("/shop/viewproduct/{id}")
		public String viewProduct(Model model, @PathVariable int id) {
			model.addAttribute("product", productService.getProductById(id).get());
			model.addAttribute("cartCount",GlobalData.cart.size());//for cart
			return "viewProduct";
		}

		
		
	}
		


