package ir.najaftech.service;

import java.io.IOException;
import java.util.List;

import ir.najaftech.model.ProvidedServiceItem;

public interface ProvidedServiceItemService {

    List<ProvidedServiceItem> getAllProvidedServiceItems();

    List<ProvidedServiceItem> getAllActiveProvidedServiceItems();

    ProvidedServiceItem createProvidedServiceItem(ProvidedServiceItem item) throws IOException;

    // TODO : Correct Exception need to be thrown
    ProvidedServiceItem getProvidedServiceItemById(long id) throws Exception;


    // TODO : Correct Exception 
    void deleteProvidedServiceItem(long id) throws Exception;

    // TODO : Guess what
    ProvidedServiceItem updateProvidedServiceItem(long id, ProvidedServiceItem item) throws Exception;

}
