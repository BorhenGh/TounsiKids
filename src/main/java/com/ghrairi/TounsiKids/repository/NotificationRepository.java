package com.ghrairi.TounsiKids.repository;

import com.ghrairi.TounsiKids.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository  <Notification, Long> {
    List<Notification> findByAdmin_IdAndIsReadFalse(Long adminId);

}
