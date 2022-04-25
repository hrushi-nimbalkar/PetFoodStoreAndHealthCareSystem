package com.spring.pet.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.nio.file.Path;

//import org.apache.tomcat.util.codec.binary.StringUtils;
//import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.thymeleaf.util.StringUtils;

import com.spring.pet.dto.ProductDTO;
//import com.spring.pet.config.FileUploadUtil;
//import com.spring.pet.dto.ProductDTO;
import com.spring.pet.entity.Appointment;
import com.spring.pet.entity.Category;
import com.spring.pet.entity.Product;
import com.spring.pet.service.AppointmentService;
import com.spring.pet.service.CategoryService;
import com.spring.pet.service.ProductService;

//import antlr.StringUtils;

//import wniemiec.util.data.StringUtils;




@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir")+ "/src/main/resources/static/images";
    @Autowired
    CategoryService categoryService;
	
    @Autowired
    ProductService productService;
    
    @Autowired
	AppointmentService appointmentService;

    @RequestMapping("/admin")
    public String adminHome(){
    	
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
    	
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    //today added thing-8/4/2022

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else
            return "404";    
    }

    //Product Section

    @GetMapping("/admin/product")
    public String getProduct(Model model){
    	
        model.addAttribute("products",productService.getAllProduct());
        return "product";
    }

     @GetMapping("/admin/product/add")
     public String getProductadd(Model model){
    	// model.addAttribute("products",new Category());
    	 model.addAttribute("productDTO",new ProductDTO());
     	 model.addAttribute("categories",categoryService.getAllCategory());
         return "productsAdd";
     }

     	@PostMapping("/admin/product/add")
     	public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO ,
     								 @RequestParam("productImage") MultipartFile file ,
     								@RequestParam("imgName")String imgName) throws IOException {
     		
     		Product product = new Product();
     		product.setId(productDTO.getId());
     		product.setName(productDTO.getName());
     		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
     		product.setPrice(productDTO.getPrice());
     		product.setDescription(productDTO.getDescription());
     		
     		String imageUUID;
     		if(!file.isEmpty()) {
     			imageUUID = file.getOriginalFilename();
     			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
     			Files.write(fileNameAndPath, file.getBytes());
     			
     		} else {
     			imageUUID = imgName;
     			
     		}
     		product.setImageName(imageUUID);
     		productService.addProduct(product);
     		
     		 return "redirect:/admin/product";
     	}
     		
     	
     			
     								 
     
     
		@GetMapping("/admin/product/delete/{id}")
		public String deleteProduct(@PathVariable long id) {
			productService.removeProductById(id);
			return "redirect:/admin/product";
		}

		@GetMapping("/admin/product/update/{id}")
		public String updateProductGet(@PathVariable long id, Model model) {
			
			Product product = productService.getProductById(id).get();
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setCategoryId(product.getCategory().getId());
			productDTO.setPrice(product.getPrice());
			productDTO.setDescription(product.getDescription());
			productDTO.setImageName(product.getImageName());
			
			model.addAttribute("categories",categoryService.getAllCategory());
			model.addAttribute("productDTO",productDTO);
			
			return "productsAdd";
		}
     
     
     @RequestMapping("/admin/Appointment")
     public String saveAppointment(Model model) 
     {
    	 List<Appointment> list= appointmentService.findAll();
    	 model.addAttribute("appointment", list);
    	 return "addAppointment";
     }
     

}