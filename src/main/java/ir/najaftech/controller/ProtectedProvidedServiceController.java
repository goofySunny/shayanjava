package ir.najaftech.controller;

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

import ir.najaftech.model.ProvidedServiceItem;
import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.service.ProvidedServiceItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/service")
@RequiredArgsConstructor
public class ProtectedProvidedServiceController {

    private final ProvidedServiceItemService service;

    @GetMapping()
    public ModelAndView providedServiceDash() {
        ModelAndView mv = new ModelAndView("service-dash");
        mv.addObject("serviceItems", service.getAllProvidedServiceItems());
        return mv;
    }

    @GetMapping("/add")
    public String createProvidedServiceItem(Model model) {
        model.addAttribute("serviceItem", new ShowcaseItem());
        return "service-addition";
    }

    @PostMapping("/upload")
    public String uploadNewProvidedServiceItem(@ModelAttribute ProvidedServiceItem item, Model model, BindingResult result)
            throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/add";
        }

        service.createProvidedServiceItem(item);

        model.addAttribute("message", "Showcase Item added");
        return "redirect:/admin/service/add";
    }

    @PostMapping("/edit/{id}")
    public String updateProvidedServiceItem(@PathVariable Long id, @ModelAttribute ProvidedServiceItem item, Model model,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/service/edit/" + id;
        }

        try {
            service.updateProvidedServiceItem(id, item);
        } catch (Exception ex) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/service/edit/" + id;
        }

        model.addAttribute("successMessage", "Service item successfully modified");
        return "redirect:/admin/service";
    }

    @GetMapping("/edit/{id}")
    public String editProvidedServiceItem(@PathVariable long id, Model model) throws Exception {
        ProvidedServiceItem item = service.getProvidedServiceItemById(id);
        model.addAttribute("serviceItem", item);
        model.addAttribute("successMessage", "Service was successfully modified");
        return "service-edit";
    }

}
