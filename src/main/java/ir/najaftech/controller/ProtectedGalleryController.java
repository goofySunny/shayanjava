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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ir.najaftech.model.GalleryItem;
import ir.najaftech.service.GalleryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/gallery")
public class ProtectedGalleryController {

    private final GalleryItemService service;

    @GetMapping()
    public ModelAndView galleryDash() {
        ModelAndView mv = new ModelAndView("gallery-dash");
        mv.addObject("galleryItems", service.getAllGalleryItems());
        return mv;
    }

    @GetMapping("/add")
    public String createGalleryItem(Model model) {
        model.addAttribute("galleryItem", new GalleryItem());
        return "gallery-addition";
    }

    @PostMapping("/upload")
    public String uploadNewGalleryItem(@ModelAttribute GalleryItem item, RedirectAttributes redirectAttributes,
            BindingResult result)
            throws IOException {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail!");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong!");
            return "redirect:/add";
        }

        service.createGalleryItem(item);
        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Gallery Item Added");
        return "redirect:/admin/gallery/add";
    }

    @PostMapping("/edit/{id}")
    public String updateGalleryItem(@PathVariable long id, @ModelAttribute GalleryItem item, Model model,
            BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("showAlert", true);
            model.addAttribute("alertTitle", "");
            model.addAttribute("alertMessage", "");
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
    public String editGalleryItem(@PathVariable long id, Model model) throws Exception {
        GalleryItem item = service.getGalleryItemById(id);
        model.addAttribute("galleryItem", item);
        model.addAttribute("successMessage", "Gallery Item was successfully modified");
        return "gallery-edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteGalleryItem(@PathVariable long id, RedirectAttributes redirectAttributes) throws Exception {
        service.deleteGalleryItem(id);

        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success!");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Gallery Item Deleted Successfully");

        return "redirect:/admin/gallery";
    }

}
