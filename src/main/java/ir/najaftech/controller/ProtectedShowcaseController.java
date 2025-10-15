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
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin/showcase")
@RequiredArgsConstructor
public class ProtectedShowcaseController {

    private final ShowcaseItemService service;

    @GetMapping()
    public ModelAndView showcaseDash() {
        ModelAndView mv = new ModelAndView("showcase-dash");
        mv.addObject("showcaseItems", service.getAllShowcaseItems());
        return mv;
    }

    @GetMapping("/add")
    public String createShowcase(Model model) {
        model.addAttribute("showcaseItem", new ShowcaseItem());
        return "showcase-addition";
    }

    @PostMapping("/upload")
    public String uploadNewShowcaseItem(@ModelAttribute ShowcaseItem item, Model model, BindingResult result)
            throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/add";
        }

        service.createShowcaseItem(item);

        model.addAttribute("message", "Showcase Item added");
        return "redirect:/admin/showcase/add";
    }

    @PostMapping("/edit/{id}")
    public String updateShowcaseItem(@PathVariable long id, @ModelAttribute ShowcaseItem item, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/showcase/edit/" + id;
        }

        try {
            service.updateShowCaseItem(item, id);
        } catch (Exception ex) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/showcase/edit/" + id;
        }

        model.addAttribute("successMessage", "Showcase item successfully modified");
        return "redirect:/admin/showcase";
    }

    @GetMapping("/edit/{id}")
    public String editShowcase(@PathVariable long id, Model model) {
        ShowcaseItem item = service.getShowCaseItemById(id);
        model.addAttribute("showcaseItem", item);
        model.addAttribute("successMessage", "Showcase was successfully modified");
    return "showcase-edit";
    }
    

}
