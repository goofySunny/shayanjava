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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String uploadNewShowcaseItem(@ModelAttribute ShowcaseItem item, RedirectAttributes redirectAttributes, BindingResult result, MultipartFile file)
            throws IOException {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail!");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong!");
            return "redirect:/add";
        }

        service.createShowcaseItem(item, file);
        
        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Showcase Item Added");
        return "redirect:/admin/showcase/add";
    }

    @PostMapping("/edit/{id}")
    public String updateShowcaseItem(@PathVariable long id, @ModelAttribute ShowcaseItem item, RedirectAttributes redirectAttributes, BindingResult result) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail!");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong!");
            return "redirect:/admin/showcase/edit/" + id;
        }

        try {
            service.updateShowCaseItem(item, id);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail!");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong!");
            return "redirect:/admin/showcase/edit/" + id;
        }

        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Showcase Item Added");
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
