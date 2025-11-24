package ir.najaftech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ir.najaftech.service.CategoryService;
import ir.najaftech.service.GalleryItemService;
import ir.najaftech.service.ProductService;
import ir.najaftech.service.ProvidedServiceItemService;
import ir.najaftech.service.ShowcaseItemService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@SessionAttributes("preferredTheme")
public class MainController {

    private final ShowcaseItemService showcaseService;
    private final GalleryItemService galleryService;
    private final ProvidedServiceItemService providedServiceItemService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public String home(Model model, HttpSession session) {
        getAndOrSetTheme(model, session);

        model.addAttribute("showcaseItems", showcaseService.getAllShowcaseItems());
        model.addAttribute("providedServiceItems", providedServiceItemService.getAllActiveProvidedServiceItems());
        model.addAttribute("galleryItems", galleryService.getAllActiveGalleryItems());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.getShowcasedProducts());

        return "index";
    }

    @GetMapping("/admin")
    public String getMethodName() {
        return "admin";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/gallery/")
    public String galleryPage(Model model, @RequestParam(required = false) String searchContext) {
        if (searchContext == null) {
            model.addAttribute("galleryItems", galleryService.getAllActiveGalleryItems());
        } else {
            // TODO : make this happen
            // model.addAttribute("galleryItems",
            // galleryService.getAllByMatchingPattern(searchContext));
        }
        return "gallery";
    }

    @GetMapping("/products")
    public String productsPage(Model model, @RequestParam(required=false) String param) throws Exception {

        // Handle Search
        if (param != null && !param.isEmpty()) {
            model.addAttribute("searchContext", param);
            // TODO : make this happen
            // model.addAttribute("products",
            // productService.getAllByMatchingPattern(param));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        return "products";
    }

    @GetMapping("/products/{id}")
    public String specificProductPage(@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @GetMapping("/categories")
    public String categoriesPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String specificCategoryPage(@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("category", categoryService.findById(id));
        // model.addAttribute("products", productService.getProductsByCategoryId(id));
        return "category";
    }

    @GetMapping("/projects")
    public String projectsPage() {
        // TODO‌ :‌ ‌‌‌‌Retrieve All projects and display them here
        // TODO‌ : If there exists a search query return matching results‌‌‌
        return "projects";
    }

    @GetMapping("/showcase/{id}")
    public String focusShowcase(@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("showcase", showcaseService.getShowCaseItemById(id));

        return "showcase";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    // Utility method to get and set the theme
    private void getAndOrSetTheme(Model model, HttpSession session) {
        String theme = (String) session.getAttribute("preferredTheme");
        if (theme != null && (theme == "light" || theme == "dark")) {
            model.addAttribute("preferredTheme", theme);
        } else {
            model.addAttribute("preferredTheme", "light");
        }

    }

}