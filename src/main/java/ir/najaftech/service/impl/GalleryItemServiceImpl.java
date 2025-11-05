package ir.najaftech.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.model.GalleryItem;
import ir.najaftech.repository.GalleryItemRepository;
import ir.najaftech.service.GalleryItemService;
import ir.najaftech.util.FileHandler;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryItemServiceImpl implements GalleryItemService {

    private final GalleryItemRepository repo;
    private final FileHandler fileHandler;

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
    public GalleryItem createGalleryItem(GalleryItem item, MultipartFile file) throws IOException {
        GalleryItem newItem = GalleryItem.builder()
            .desc(item.getDesc())
            .imageName(fileHandler.saveFile(file))
            .title(item.getTitle())
            .active(item.isActive())
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
        GalleryItem oldItem = repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        item.setId(id);
        item.setImageName(oldItem.getImageName());
        return repo.save(item);
    }

}
