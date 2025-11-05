package ir.najaftech.service.impl;


import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.repository.ShowcaseItemRepository;
import ir.najaftech.service.ShowcaseItemService;
import ir.najaftech.util.FileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowcaseItemServiceImpl implements ShowcaseItemService {

    private final ShowcaseItemRepository repo;
    private final FileHandler fileHandler;

    @Override
    public ShowcaseItem getShowCaseItemById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ShowcaseItem> getAllActiveShowcaseItems() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<ShowcaseItem> getAllShowcaseItems() {
        return repo.findAll();
    }

    @Override
    public boolean deleteShowcaseItemById(long id) {
        if(repo.findById(id).orElse(null) != null) {
            repo.deleteById(id);
            return true;
        };

        return false;
    }

    @Override
    public ShowcaseItem updateShowCaseItem(ShowcaseItem item, long id) {
        ShowcaseItem old = repo.findById(id).orElse(null);
        if (old != null) {
            item.setImageName(old.getImageName());
            item.setId(id);
            return repo.save(item);
        }
        return null;
    }

    @Override
    public ShowcaseItem createShowcaseItem(ShowcaseItem item, MultipartFile file) throws IOException {
        ShowcaseItem savedItem = ShowcaseItem.builder()
        .title(item.getTitle())
        .imageName(fileHandler.saveFile(file))
        .desc(item.getDesc())
        .active(item.isActive())
        .build();
        return repo.save(savedItem);
    }
}
