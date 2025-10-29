package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import ir.najaftech.model.ProvidedServiceItem;
import ir.najaftech.repository.ProvidedServiceItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvidedServiceItemServiceImpl implements ProvidedServiceItemService {

    private final ProvidedServiceItemRepository repo;

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
    public ProvidedServiceItem createProvidedServiceItem(ProvidedServiceItem item) throws IOException {
        ProvidedServiceItem newItem = ProvidedServiceItem.builder()
        .active(item.isActive())
        .title(item.getTitle())
        .image(item.getFile().getBytes())
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
        item.setImage(oldItem.getImage());
        return repo.save(item);
    }



}
