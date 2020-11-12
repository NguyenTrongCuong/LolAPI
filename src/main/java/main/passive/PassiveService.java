package main.passive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassiveService {
	@Autowired
	private PassiveRepository passiveRepo;

}
