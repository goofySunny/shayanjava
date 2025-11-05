package ir.najaftech.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.model.ProvidedServiceItem;
import ir.najaftech.repository.ProvidedServiceItemRepository;
import ir.najaftech.service.ProvidedServiceItemService;
import ir.najaftech.util.FileHandler;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvidedServiceItemServiceImpl implements ProvidedServiceItemService {

    private final ProvidedServiceItemRepository repo;
    private final FileHandler fileHandler;

    @Override
    public List<ProvidedServiceItem> getAllProvidedServiceItems() {
        return repo.findAll();
    }

    @Override
    public List<ProvidedServiceItem> getAllActiveProvidedServiceItems() {
        return repo.getByActiveTrue();
    }

    @Override
    public ProvidedServiceItem getProvidedServiceItemById(long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
    }

    @Override
    public ProvidedServiceItem createProvidedServiceItem(ProvidedServiceItem item, MultipartFile file) throws IOException {
        ProvidedServiceItem newItem = ProvidedServiceItem.builder()
        .title(item.getTitle())
        .active(item.isActive())
        .imageName(fileHandler.saveFile(file))
        .build();
        return repo.save(newItem);
    }

    @Override
    public void deleteProvidedServiceItem(long id) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        repo.deleteById(id);
    }

    @Override
    public ProvidedServiceItem updateProvidedServiceItem(long id, ProvidedServiceItem item) throws Exception {
        ProvidedServiceItem oldItem = repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
        item.setId(id);
        item.setImageName(oldItem.getImageName());
        return repo.save(item);
    }



}
