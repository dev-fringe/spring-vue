package dev.fringe.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fringe.app.domain.Desserts;
import dev.fringe.app.repository.DessertsRepository;

@Service
public class DessertsService {

	@Autowired
	DessertsRepository dessertsRepository;

	public void save() {
		dessertsRepository.save(new Desserts("Frozen Yogurt", 159, 6.0, 24, 4.0));
		dessertsRepository.save(new Desserts("Ice cream sandwich", 237, 9.0, 37, 4.3));
		dessertsRepository.save(new Desserts("Eclair", 262, 16.0, 23, 6.0));
		dessertsRepository.save(new Desserts("Cupcake", 305, 3.7, 67, 4.3));
		dessertsRepository.save(new Desserts("Gingerbread", 356, 16.0, 49, 3.9));
		dessertsRepository.save(new Desserts("Jelly bean", 375, 0.0, 94, 0.0));
		dessertsRepository.save(new Desserts("Lollipop", 392, 0.2, 98, (double) 0));
		dessertsRepository.save(new Desserts("Honeycomb", 408, 3.2, 87, 6.5));
		dessertsRepository.save(new Desserts("Donut", 452, 25.0, 51, 4.9));
		dessertsRepository.save(new Desserts("KitKat", 518, 26.0, 65, (double) 7));
	}

	public Object get() {
		return dessertsRepository.findAll();
	}

	public void save(Desserts desserts) {
		dessertsRepository.save(desserts);
	}
}
