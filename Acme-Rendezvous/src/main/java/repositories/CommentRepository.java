
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("select avg(c.subComments.size) from Comment c")
	Double avgRepliesPerComment();

	@Query("select stddev(c.subComments.size) from Comment c")
	Double stdDevRepliesPerComment();

}
