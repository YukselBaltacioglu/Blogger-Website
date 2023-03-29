package dataAccess.abstracts;

import entities.concretes.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboxDao extends JpaRepository<Inbox, Integer> {

    List<Inbox> getInboxByUser_Id(int userId);
}
