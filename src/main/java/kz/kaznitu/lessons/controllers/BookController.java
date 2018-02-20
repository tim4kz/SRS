package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.reposotories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/demo")
public class BookController {

    private BookRepository bookRepository;
}
