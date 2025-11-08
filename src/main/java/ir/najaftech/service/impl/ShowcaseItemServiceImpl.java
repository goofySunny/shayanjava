package ir.najaftech.service.impl;


import ir.najaftech.dto.request.ShowcaseRequest;
import ir.najaftech.dto.response.ShowcaseResponse;
import ir.najaftech.model.ShowcaseItem;
import ir.najaftech.repository.ShowcaseItemRepository;
import ir.najaftech.service.ShowcaseItemService;
import ir.najaftech.util.FileHandler;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO : refactor the return types into Response dtos
@Service
@RequiredArgsConstructor
public class ShowcaseItemServiceImpl implements ShowcaseItemService {

    private final ShowcaseItemRepository repo;
    private final FileHandler fileHandler;
    private final ModelMapper modelMapper;

    @Override
    public ShowcaseResponse getShowCaseItemById(long id) throws Exception {
        ShowcaseResponse item = modelMapper.map(repo.findById(id).orElseThrow(() -> new Exception("Not Found")), ShowcaseResponse.class);
        return item;
    }

    @Override
    public List<ShowcaseResponse> getAllActiveShowcaseItems() {
        List<ShowcaseResponse> list = new ArrayList<>();
        repo.findByActiveTrue().forEach(e -> list.add(modelMapper.map(e, ShowcaseResponse.class)));
        return list;
    }

    @Override
    public List<ShowcaseResponse> getAllShowcaseItems() {
        List<ShowcaseResponse> list = new ArrayList<>();
        repo.findAll().forEach(e -> list.add(modelMapper.map(e, ShowcaseResponse.class)));
        return list;
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
    public ShowcaseItem updateShowCaseItem(ShowcaseRequest item, long id) throws Exception {
        ShowcaseItem old = repo.findById(id).orElseThrow(() -> new Exception("Not Found"));
        ShowcaseItem update = modelMapper.map(item, ShowcaseItem.class);
        update.setId(old.getId());
        update.setImageName(old.getImageName());

        return repo.save(update);
    }

    @Override
    public ShowcaseItem createShowcaseItem(ShowcaseRequest item, MultipartFile file) throws IOException {
        ShowcaseItem savedItem = modelMapper.map(item, ShowcaseItem.class);

        savedItem.setImageName(fileHandler.saveFile(file));

        return repo.save(savedItem);
    }
}
