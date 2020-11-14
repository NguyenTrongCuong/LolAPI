package main.passive;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassiveService {
	@Autowired
	private PassiveRepository passiveRepo;
	
	public void savePassive(Passive passive) {
		this.passiveRepo.save(passive);
	}
	
	public void updatePassive(Passive passive) {
		this.passiveRepo.save(passive);
	}
	
	public void updateInfoOfPassive(PassiveDTO passiveDTO) throws Exception {
		Optional<Passive> rs = this.passiveRepo.findById(Long.parseLong(passiveDTO.getPassiveId()));
		if(!rs.isEmpty()) {
			Passive passive = rs.get();
			if(passiveDTO.getPassiveCoolDown() != null && !passiveDTO.getPassiveCoolDown().equals("")) {
				passive.setPassiveCoolDown(passiveDTO.getPassiveCoolDown());
			}
			if(passiveDTO.getPassiveDescription() != null && !passiveDTO.getPassiveDescription().equals("")) {
				passive.setPassiveDescription(passiveDTO.getPassiveDescription());
			}
			if(passiveDTO.getPassiveName() != null && !passiveDTO.getPassiveName().equals("")) {
				passive.setPassiveName(passiveDTO.getPassiveName());
			}
			this.updatePassive(passive);
		}
		else throw new Exception("Passive not found");
	}
	
	public Passive getPassiveByIdEagerly(long passiveId) throws Exception {
		Passive passive = this.passiveRepo.getPassiveByIdEagerly(passiveId);
		if(passive != null) {
			return passive;
		}
		else throw new Exception("Passive not found");
	}

}

















































