package ir.najaftech.controller;


import ir.najaftech.service.ShowcaseItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ProtectedController {

    private final ShowcaseItemService service;


}
