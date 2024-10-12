package org.example.app.config;

import org.example.app.entity.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Spring сканує файли, які знаходяться в пакеті org.example.app
@ComponentScan("org.example.app")
public class AppConfig {

    // Імена методів, за замовчанням, є
    // Spring Bean ідентифікатором для
    // Spring IoC контейнеру

    // Одного цього методу достатньо тут,
    // коли конфігурація в Контролері та Сервісі
    // відбувається ін'єкцією через Field або Constructor

    // Конфігурація через створення об'єкта біна
    // та виклик його методу
    @Bean
    public Message doMessage() {
        Message message = new Message();
        message.setMessage("Congratulations, you have reached the end!");
        return message;
    }
}
