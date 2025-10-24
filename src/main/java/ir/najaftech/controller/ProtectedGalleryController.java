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

import ir.najaftech.model.GalleryItem;
import ir.najaftech.service.GalleryItemService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/gallery")
public class ProtectedGalleryController {

    private final GalleryItemService service;

    @GetMapping()
    public ModelAndView showcaseDash() {
        ModelAndView mv = new ModelAndView("gallery-dash");
        mv.addObject("GalleryItems", service.getAllGalleryItems());
        return mv;
    }

    @GetMapping("/add")
    public String createShowcase(Model model) {
        model.addAttribute("GalleryItem", new GalleryItem());
        return "gallery-addition";
    }

    @PostMapping("/upload")
    public String uploadNewGalleryItem(@ModelAttribute GalleryItem item, Model model, BindingResult result)
            throws IOException {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/add";
        }

        service.createGalleryItem(item);

        model.addAttribute("message", "Gallery Item added");
        return "redirect:/admin/gallery/add";
    }

    @PostMapping("/edit/{id}")
    public String updateGalleryItem(@PathVariable long id, @ModelAttribute GalleryItem item, Model model,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/gallery/edit/" + id;
        }

        try {
            service.updateGalleryItem(id, item);
        } catch (Exception ex) {
            model.addAttribute("message", "Something went wrong");
            return "redirect:/admin/gallery/edit/" + id;
        }

        model.addAttribute("successMessage", "Gallery item successfully modified");
        return "redirect:/admin/gallery";
    }

    @GetMapping("/edit/{id}")
    public String editShowcase(@PathVariable long id, Model model) throws Exception {
        GalleryItem item = service.getGalleryItemById(id);
        model.addAttribute("galleryItem", item);
        model.addAttribute("successMessage", "Showcase was successfully modified");
        return "showcase-edit";
    }

}
