package ir.najaftech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.najaftech.model.ProvidedServiceItem;

@Repository
public interface ProvidedServiceItemRepository extends JpaRepository<ProvidedServiceItem, Long> {

    List<ProvidedServiceItem> getByActiveTrue();
}
