package dataAccess.abstracts;

import entities.concretes.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticDao extends JpaRepository<Statistic, Integer> {
}
