package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ir.najaftech.dto.request.ServiceItemRequest;
import ir.najaftech.dto.response.ServiceItemResponse;
import ir.najaftech.model.ProvidedServiceItem;

public interface ProvidedServiceItemService {

    List<ServiceItemResponse> getAllProvidedServiceItems();

    List<ServiceItemResponse> getAllActiveProvidedServiceItems();

    ProvidedServiceItem createProvidedServiceItem(ServiceItemRequest item, MultipartFile file) throws IOException;

    // TODO : Correct Exception need to be thrown
    ServiceItemResponse getProvidedServiceItemById(long id) throws Exception;


    // TODO : Correct Exception 
    void deleteProvidedServiceItem(long id) throws Exception;

    // TODO : Guess what
    ProvidedServiceItem updateProvidedServiceItem(long id, ServiceItemRequest item) throws Exception;

}
