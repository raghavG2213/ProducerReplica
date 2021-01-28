package com.tcs.service.service

import com.tcs.service.events.DummyEvent
import com.tcs.service.model.Dummy
import io.eventuate.tram.events.common.DomainEvent
import io.eventuate.tram.events.publisher.DomainEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class Producer {

@Autowired
lateinit var  domainEventPublisher: DomainEventPublisher

    fun create(dummy: Dummy) {
        publishTodoEvent(dummy, DummyEvent(dummy.shipmentId))
    }

    fun publishTodoEvent(Dummy: Dummy, vararg domainEvents: DomainEvent) {
        domainEventPublisher.publish(Dummy::class.java, Dummy.shipmentId, listOf(*domainEvents))
    }

}