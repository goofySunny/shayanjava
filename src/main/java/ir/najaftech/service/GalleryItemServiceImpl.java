package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import ir.najaftech.model.GalleryItem;
import ir.najaftech.repository.GalleryItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryItemServiceImpl implements GalleryItemService {

    private final GalleryItemRepository repo;

    @Override
    public List<GalleryItem> getAllGalleryItems() {
        return repo.findAll();
    }

    @Override
    public List<GalleryItem> getAllActiveGalleryItems() {
        return repo.findByActiveTrue();
    }

    @Override
    public GalleryItem getGalleryItemById(long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Not found"));
    }

    @Override
    public GalleryItem createGalleryItem(GalleryItem item) throws IOException {
        GalleryItem newItem = GalleryItem.builder()
        .title(item.getTitle())
        .active(false)
        .image(item.getFile().getBytes())
        .desc(item.getDesc())
        .build();
        return repo.save(newItem);
    }

    @Override
    public void deleteGalleryItem(long id) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        repo.deleteById(id);
    }

    @Override
    public GalleryItem updateGalleryItem(long id, GalleryItem item) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        item.setId(id);
        return repo.save(item);
    }

}
