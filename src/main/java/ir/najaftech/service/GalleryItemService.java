package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import ir.najaftech.model.GalleryItem;

public interface GalleryItemService {

    List<GalleryItem> getAllGalleryItems();

    List<GalleryItem> getAllActiveGalleryItems();

    // TODO : Correct Exception need to be thrown
    GalleryItem getGalleryItemById(long id) throws Exception;

    GalleryItem createGalleryItem(GalleryItem item) throws IOException;

    // TODO : Correct Exception 
    void deleteGalleryItem(long id) throws Exception;

    // TODO : Guess what
    GalleryItem updateGalleryItem(long id, GalleryItem item) throws Exception;

}
