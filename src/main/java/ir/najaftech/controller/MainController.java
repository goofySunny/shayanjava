package ir.najaftech.controller;

import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.service.ShowcaseItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    private final ShowcaseItemService showcaseService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("showcaseItems", showcaseService.getAllShowcaseItems());

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/showcase/images/{id}")
    @ResponseBody
    public ResponseEntity<Object> getImage(@PathVariable Long id) {
        ShowcaseItem item = showcaseService.getShowCaseItemById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(item.getImage().length);

        return new ResponseEntity<>(item.getImage(), headers, HttpStatus.OK);

    }
    
}