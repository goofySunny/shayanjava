package ir.najaftech.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ir.najaftech.dto.request.ProjectRequest;
import ir.najaftech.service.ProjectService;
import lombok.RequiredArgsConstructor;

/**
 * @author sun
 * @description Adming panel controller for Projects
 */

@Controller()
@RequiredArgsConstructor
@RequestMapping("/admin/project")
public class ProtectedProjectsController {

    private final ProjectService projectService;

    @GetMapping()
    public String projectsDash(Model model) {

        model.addAttribute("projects", projectService.getAllProjects());

        return "projects-dash";
    }

    @GetMapping("/add")
    public String addNewPage(Model model) {
        model.addAttribute("project", new ProjectRequest());

        return "projects-add";
    }

    @PostMapping("/add")
    public String addNew(@ModelAttribute ProjectRequest request, BindingResult result, RedirectAttributes redirectAttributes) throws Exception {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong");
        }

        projectService.createProject(request);

        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Showcase Item Added");

        return "projects-dash";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable long id, Model model, RedirectAttributes redirectAttributes)
            throws Exception {
        model.addAttribute("project", projectService.getProjectById(id));

        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Showcase Item Added");

        return "projects-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable long id, RedirectAttributes redirectAttributes,
            @ModelAttribute ProjectRequest request, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("showAlert", true);
            redirectAttributes.addFlashAttribute("alertTitle", "Fail");
            redirectAttributes.addFlashAttribute("alertType", "error");
            redirectAttributes.addFlashAttribute("alertMessage", "Something went wrong");
        }

        projectService.updateProject(request, id);

        redirectAttributes.addFlashAttribute("showAlert", true);
        redirectAttributes.addFlashAttribute("alertTitle", "Success");
        redirectAttributes.addFlashAttribute("alertType", "success");
        redirectAttributes.addFlashAttribute("alertMessage", "Showcase Item Added");

        return "projects-dash";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) throws Exception {
        projectService.removeProject(id);
        return "projects-dash";
    }

}
