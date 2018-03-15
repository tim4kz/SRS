package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Admin;
import kz.kaznitu.lessons.reposotories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("admin",new Admin());
        return "admin_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("adminn",new Admin());
        return "update";
    }
    @PostMapping("/add")
    public String addAdmin(@ModelAttribute Admin admin){
        adminRepository.save(admin) ;

        return "redirect:/demo/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Admin> allAuthors(){
        return adminRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAdmins2(Model model){
        List<Admin> admins = (List<Admin>) adminRepository.findAll();
        model.addAttribute("admins", admins) ;
        return "admins" ;
    }

    @PostMapping("/adds")
    public String addsAdmin(@ModelAttribute Admin admin){
        Admin admin1 = new Admin();
        admin1.setId(a);
        admin1.setFirstName(admin.getFirstName());
        admin1.setLastName(admin.getLastName());
        admin1.setEmail(admin.getEmail());
        adminRepository.save(admin1) ;

        return "redirect:/demo/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Admin> author = (Optional <Admin> ) adminRepository.findById(id);
        model.addAttribute("authorr",author);
        return new ModelAndView("update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        adminRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all");
    }
}
