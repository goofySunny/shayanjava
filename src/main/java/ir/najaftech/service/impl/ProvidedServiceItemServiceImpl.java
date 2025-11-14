package ir.najaftech.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.dto.request.ServiceItemRequest;
import ir.najaftech.dto.response.ServiceItemResponse;
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
    private final ModelMapper modelMapper;

    @Override
    public List<ServiceItemResponse> getAllProvidedServiceItems() {
        List<ServiceItemResponse> list = new ArrayList<>();
        repo.findAll().forEach(each -> {
            list.add(modelMapper.map(each, ServiceItemResponse.class));
        });;
        return list;
    }

    @Override
    public List<ServiceItemResponse> getAllActiveProvidedServiceItems() {
        List<ServiceItemResponse> list = new ArrayList<>(); 
        repo.getByActiveTrue().forEach(each -> {
            list.add(modelMapper.map(each, ServiceItemResponse.class));
        });
        return list;
    }

    @Override
    public ServiceItemResponse getProvidedServiceItemById(long id) throws Exception {
        ProvidedServiceItem item = repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
        return modelMapper.map(item, ServiceItemResponse.class);
    }

    @Override
    public ProvidedServiceItem createProvidedServiceItem(ServiceItemRequest item, MultipartFile file)
            throws IOException {
        ProvidedServiceItem newItem = modelMapper.map(item, ProvidedServiceItem.class);
        newItem.setImageName(fileHandler.saveFile(file));
        return repo.save(newItem);
    }

    @Override
    public void deleteProvidedServiceItem(long id) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found"));
        repo.deleteById(id);
    }

    @Override
    public ProvidedServiceItem updateProvidedServiceItem(long id, ServiceItemRequest item) throws Exception {
        ProvidedServiceItem newItem = modelMapper.map(item, ProvidedServiceItem.class);
        ProvidedServiceItem oldItem = repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
        newItem.setId(oldItem.getId());
        newItem.setImageName(oldItem.getImageName());

        return repo.save(newItem);
    }

}
