package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Tovar;
import kz.kaznitu.lessons.reposotories.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/tovar")
public class TovarController {
    @Autowired
    private TovarRepository tovarRepository;
    private long a;

    @GetMapping("/main")
    public String allTovar(Model model){
        List<Tovar> tovars = (List<Tovar>) tovarRepository.findAll();
        model.addAttribute("tovars",tovars);
        return "tovars";
    }

    @RequestMapping("/addd")
    public String showFormmm(Model model){
        model.addAttribute("tovarr",new Tovar());
        return "tovarupdate";
    }

    @GetMapping("/add")
    public String tovarForm(Model model){
        model.addAttribute("tovar",new Tovar());
        return "tovar_add_form";
    }

    @GetMapping("/main2")
    public @ResponseBody Iterable<Tovar> alltovars(){
        return tovarRepository.findAll() ;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Tovar tovar){
        tovarRepository.save(tovar);
        return "redirect:/tovar/main";
    }

    @PostMapping("/adds")
    public String addsTovars(@ModelAttribute Tovar tovar){
        Tovar tovar1 = new Tovar();
        tovar1.setId(a);
        tovar1.setTovarName(tovar.getTovarName());
        tovar1.setCost(tovar.getCost());
        tovarRepository.save(tovar1) ;

        return "redirect:/tovar/main" ;
    }

    @RequestMapping(value = "/updateTovar",method = RequestMethod.GET)
    public ModelAndView updateAdmins(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Tovar> tovar = (Optional <Tovar> ) tovarRepository.findById(id);
        model.addAttribute("tovarr",tovar);
        return new ModelAndView("tovarupdate");
    }

    @RequestMapping(value = "/deleteTovar",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        tovarRepository.deleteById(idd);
        return new ModelAndView("redirect:/tovar/main");
    }
}