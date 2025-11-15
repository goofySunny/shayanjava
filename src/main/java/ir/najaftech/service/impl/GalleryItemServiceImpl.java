package ir.najaftech.service.impl;

import java.io.IOException;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.dto.request.GalleryItemRequest;
import ir.najaftech.dto.response.GalleryItemResponse;
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
    private final ModelMapper modelMapper;

    @Override
    public List<GalleryItem> getAllGalleryItems() {
        return repo.findAll();
    }

    @Override
    public List<GalleryItem> getAllActiveGalleryItems() {
        return repo.findByActiveTrue();
    }

    @Override
    public GalleryItemResponse getGalleryItemById(long id) throws Exception {
        GalleryItem gi = repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        return modelMapper.map(gi, GalleryItemResponse.class);
    }

    @Override
    public GalleryItem createGalleryItem(GalleryItemRequest item, MultipartFile file) throws IOException {
        GalleryItem newItem = modelMapper.map(item, GalleryItem.class);
        newItem.setImageName(fileHandler.saveFile(file));

        return repo.save(newItem);
    }

    @Override
    public void deleteGalleryItem(long id) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        repo.deleteById(id);
    }

    @Override
    public GalleryItem updateGalleryItem(long id, GalleryItemRequest item) throws Exception {
        GalleryItem newItem = modelMapper.map(item, GalleryItem.class);
        GalleryItem oldItem = repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
        newItem.setImageName(oldItem.getImageName());
        newItem.setId(oldItem.getId());
        return repo.save(newItem);
    }

}
