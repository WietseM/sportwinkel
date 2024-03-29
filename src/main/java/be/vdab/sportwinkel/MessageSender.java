package be.vdab.sportwinkel;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
class MessageSender {
    private final ArtikelGemaaktRepository repository;
    private final AmqpTemplate template;

    public MessageSender(ArtikelGemaaktRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Scheduled(fixedDelay = 5_000)
    @Transactional
    public void verstuurMessages() {
        var artikelsGemaakt = repository.findAll();
        artikelsGemaakt.forEach(gemaakt -> template.convertAndSend("sportartikels", null, gemaakt));
        repository.deleteAllInBatch(artikelsGemaakt);
    }
}
