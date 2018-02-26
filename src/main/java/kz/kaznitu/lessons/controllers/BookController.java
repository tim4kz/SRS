package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Book;
import kz.kaznitu.lessons.reposotories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    private long a;

    @GetMapping("/main")
    public String allBook(Model model){
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books",books);
        return "books";
    }

    @RequestMapping("/addd")
    public String showFormmm(Model model){
        model.addAttribute("bookk",new Book());
        return "bookupdate";
    }

    @GetMapping("/add")
    public String bookForm(Model model){
        model.addAttribute("book",new Book());
        return "book_add_form";
    }

    @GetMapping("/main2")
    public @ResponseBody Iterable<Book> allBooks(){
        return bookRepository.findAll() ;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/book/main";
    }

    @PostMapping("/adds")
    public String addsBooks(@ModelAttribute Book book){
        Book book1 = new Book();
        book1.setId(a);
        book1.setBookName(book.getBookName());
        book1.setYear(book.getYear());
        bookRepository.save(book1) ;

        return "redirect:/book/main" ;
    }

    @RequestMapping(value = "/updateBook",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Book> book = (Optional <Book> ) bookRepository.findById(id);
        model.addAttribute("bookk",book);
        return new ModelAndView("bookupdate");
    }

    @RequestMapping(value = "/deleteBook",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        bookRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/main");
    }
}