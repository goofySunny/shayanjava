package ir.najaftech.service;

import ir.najaftech.model.ShowcaseItem;

import java.io.IOException;
import java.util.List;

public interface ShowcaseItemService {

    ShowcaseItem getShowCaseItemById(long id);

    List<ShowcaseItem> getAllActiveShowcaseItems();

    List<ShowcaseItem> getAllShowcaseItems();

    boolean deleteShowcaseItemById(long id);

    ShowcaseItem updateShowCaseItem(ShowcaseItem item, long id);

    ShowcaseItem createShowcaseItem(ShowcaseItem item) throws IOException;

}
