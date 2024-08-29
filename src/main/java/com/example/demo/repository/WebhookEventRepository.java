
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.WebHookEvent;

public interface WebhookEventRepository extends JpaRepository<WebHookEvent, Long> {

}