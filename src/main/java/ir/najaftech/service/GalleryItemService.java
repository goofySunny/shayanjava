package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.dto.request.GalleryItemRequest;
import ir.najaftech.dto.response.GalleryItemResponse;
import ir.najaftech.model.GalleryItem;

public interface GalleryItemService {

    List<GalleryItem> getAllGalleryItems();

    List<GalleryItem> getAllActiveGalleryItems();

    // TODO : Correct Exception need to be thrown
    GalleryItemResponse getGalleryItemById(long id) throws Exception;

    GalleryItem createGalleryItem(GalleryItemRequest item, MultipartFile file) throws IOException;

    // TODO : Correct Exception 
    void deleteGalleryItem(long id) throws Exception;

    // TODO : Guess what
    GalleryItem updateGalleryItem(long id, GalleryItemRequest item) throws Exception;

}
