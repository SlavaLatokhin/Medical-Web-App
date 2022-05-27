package com.app.medicalwebapp.repositories;

import com.app.medicalwebapp.model.messages.ChatMessage;
import com.app.medicalwebapp.model.messages.StatusMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    long countBySenderIdAndRecipientId(Long senderId, Long recipientId);

    Optional<List<ChatMessage>> findByChatIdOrderBySendDateAsc(String chatId);

    Optional<ChatMessage> findFirstByChatIdOrderBySendDateDesc(String chatId);

    Optional<List<ChatMessage>> findByRecipientIdAndStatusMessageOrderBySendDateAsc(Long recipientId, StatusMessage UNREAD);
}