package tarkvaratehnika.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Override
    List<Comment> findAll();

    List<Comment> findAllByOrderByCreatedTsDesc();
}

