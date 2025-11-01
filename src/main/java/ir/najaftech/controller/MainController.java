package ir.najaftech.controller;

import ir.najaftech.model.GalleryItem;
import ir.najaftech.model.ProvidedServiceItem;
import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.service.GalleryItemService;
import ir.najaftech.service.ProvidedServiceItemService;
import ir.najaftech.service.ShowcaseItemService;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@SessionAttributes("preferredTheme")
public class MainController {

    private final ShowcaseItemService showcaseService;
    private final GalleryItemService galleryService;
    private final ProvidedServiceItemService providedServiceItemService;

    @GetMapping
    public String home(Model model, HttpSession session) {
        getAndOrSetTheme(model, session);

        model.addAttribute("showcaseItems", showcaseService.getAllShowcaseItems());
        model.addAttribute("providedServiceItems", providedServiceItemService.getAllActiveProvidedServiceItems());
        model.addAttribute("galleryItems", galleryService.getAllActiveGalleryItems());

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
            // TODO : make this happenw
            // model.addAttribute("galleryItems", galleryService.getAllByMatchingPattern(searchContext));
        }
        return "gallery";
    }

    @GetMapping("/showcase/{id}")
    public String focusShowcase(@PathVariable Long id, Model model) {
        model.addAttribute("showcase", showcaseService.getShowCaseItemById(id));

        return "showcase";
    }

    @GetMapping("/showcase/images/{id}")
    @ResponseBody
    public ResponseEntity<Object> getShowcaseImage(@PathVariable Long id) {
        ShowcaseItem item = showcaseService.getShowCaseItemById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(item.getImage().length);

        return new ResponseEntity<>(item.getImage(), headers, HttpStatus.OK);

    }

    @GetMapping("/gallery/images/{id}")
    @ResponseBody
    public ResponseEntity<Object> getGalleryImage(@PathVariable Long id) throws Exception {
        GalleryItem item = galleryService.getGalleryItemById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(item.getImage().length);

        return new ResponseEntity<>(item.getImage(), headers, HttpStatus.OK);

    }

    @GetMapping("/service/images/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProvidedServiceItemImage(@PathVariable Long id) throws Exception {
        ProvidedServiceItem item = providedServiceItemService.getProvidedServiceItemById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(item.getImage().length);

        return new ResponseEntity<>(item.getImage(), headers, HttpStatus.OK);

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