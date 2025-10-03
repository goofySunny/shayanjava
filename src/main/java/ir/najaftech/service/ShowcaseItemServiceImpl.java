package ir.najaftech.service;


import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.repository.ShowcaseItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowcaseItemServiceImpl implements ShowcaseItemService {

    private final ShowcaseItemRepository repo;

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
        if (repo.findById(id).orElse(null) != null) {
            item.setId(id);
            return repo.save(item);
        }
        return null;
    }

    @Override
    public ShowcaseItem createShowcaseItem(ShowcaseItem item) throws IOException {
        ShowcaseItem newItem = ShowcaseItem.builder()
            .desc(item.getDesc())
            .image(item.getFile().getBytes())
            .title(item.getTitle())
            .active(item.isActive())
            .build();
        return repo.save(newItem);
    }
}
