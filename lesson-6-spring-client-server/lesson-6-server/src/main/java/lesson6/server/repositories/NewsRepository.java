package lesson6.server.repositories;

import lesson6.server.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  NewsRepository extends JpaRepository<News, Long> {
}
