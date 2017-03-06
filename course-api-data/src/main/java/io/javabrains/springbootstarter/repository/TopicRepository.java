package io.javabrains.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.springbootstarter.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
