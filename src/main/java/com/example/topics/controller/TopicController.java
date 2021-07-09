package com.example.topics.controller;

import javax.validation.Valid;

import com.example.topics.exception.ResourceNotFoundException;
import com.example.topics.model.Topic;
import com.example.topics.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TopicController {

    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable(value = "id") Long topicId)
        throws ResourceNotFoundException {
        Topic topic = topicRepository.findById(topicId)
            .orElseThrow(() -> new ResourceNotFoundException("Topic not found for this is id :: " + topicId));
        return ResponseEntity.ok().body(topic);
    }

    @PostMapping("/topics")
    public Topic createTopic(@Valid @RequestBody Topic topic) {
        return topicRepository.save(topic);
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable(value = "id") Long topicId,
        @Valid @RequestBody Topic topicDetails) throws ResourceNotFoundException {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found for this id :: " + topicId));

        topic.setName(topicDetails.getName());
        topic.setDescription(topicDetails.getDescription());
        topic.setTopicItemId(topicDetails.getTopicItemId());
        final Topic updatedTopic = topicRepository.save(topic);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/topics/{id}")
    public Map<String, Boolean> deleteTopic(@PathVariable(value = "id") Long topicId)
            throws ResourceNotFoundException {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found for this id :: " + topicId));

        topicRepository.delete(topic);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
