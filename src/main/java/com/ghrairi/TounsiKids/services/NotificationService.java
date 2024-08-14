package com.ghrairi.TounsiKids.services;

import com.ghrairi.TounsiKids.models.Notification;
import com.ghrairi.TounsiKids.models.Order;
import com.ghrairi.TounsiKids.models.User;
import com.ghrairi.TounsiKids.repository.NotificationRepository;
import com.ghrairi.TounsiKids.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Notification createNotification(Order order) {
        // Trouver tous les utilisateurs avec le rôle "ROLE_ADMIN"
        List<User> admins = userRepository.findByRoles_Name("ROLE_ADMIN");

        // Utiliser findFirst() pour obtenir le premier administrateur
        Optional<User> adminOptional = admins.stream().findFirst();

        // Vérifier si un administrateur est présent, sinon lever une exception
        if (!adminOptional.isPresent()) {
            throw new ResourceNotFoundException("Admin not found");
        }

        User admin = adminOptional.get();

        // Créer et retourner la notification
        Notification notification = new Notification();
        notification.setAdmin(admin);
        notification.setOrder(order);
        notification.setRead(false);

        return notificationRepository.save(notification);
    }

    public List<Notification> getAdminNotifications(Long adminId) {
        return notificationRepository.findByAdmin_IdAndIsReadFalse(adminId);
    }
}
