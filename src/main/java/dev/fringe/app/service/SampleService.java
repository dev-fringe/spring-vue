package dev.fringe.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fringe.app.domain.Sample;
import dev.fringe.app.repository.SampleRepository;

@Service
public class SampleService {

	@Autowired SampleRepository sampleRepository;

	public void save() {
		sampleRepository.save(new Sample(1, "test"));
		
	}
}
