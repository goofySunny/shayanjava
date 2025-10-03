package ir.najaftech.controller;


import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.service.ShowcaseItemService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/admin/showcase")
@RequiredArgsConstructor
public class ProtectedShowcaseController {

    private final ShowcaseItemService service;

    @GetMapping()
    public String showcaseDash() {
        return "showcase-dash";
    }

    @GetMapping("/add")
    public String createShowcase(Model model) {
        model.addAttribute("showcaseItem", new ShowcaseItem());
        return "showcase-addition";
    }

    @PostMapping("/edit")
    public String editShowcase() {
        return "showcase-edit";
    }

    @PostMapping("/upload")
    public String uploadNewShowcaseItem(@ModelAttribute ShowcaseItem item, Model model, BindingResult result) throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/add";
        }

        service.createShowcaseItem(item);

        model.addAttribute("message", "Showcase Item added");
        return "redirect:/admin/showcase/add";
    }

}
