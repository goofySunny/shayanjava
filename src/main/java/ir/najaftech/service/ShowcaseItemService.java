package ir.najaftech.service;

import ir.najaftech.dto.request.ShowcaseRequest;
import ir.najaftech.dto.response.ShowcaseResponse;
import ir.najaftech.model.ShowcaseItem;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ShowcaseItemService {

    ShowcaseResponse getShowCaseItemById(long id) throws Exception;

    List<ShowcaseResponse> getAllActiveShowcaseItems();

    List<ShowcaseResponse> getAllShowcaseItems();

    boolean deleteShowcaseItemById(long id);

    ShowcaseItem updateShowCaseItem(ShowcaseRequest item, long id) throws Exception;

    ShowcaseItem createShowcaseItem(ShowcaseRequest item, MultipartFile file) throws IOException;

}
