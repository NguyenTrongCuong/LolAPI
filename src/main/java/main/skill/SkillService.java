package main.skill;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepo;
	
	public void updateSkill(Skill skill) {
		this.skillRepo.save(skill);
	}
	
	public void updateInfoOfSkill(SkillDTO skillDTO) throws Exception {
		Optional<Skill> rs = this.skillRepo.findById(Long.parseLong(skillDTO.getSkillId()));
		if(!rs.isEmpty()) {
			Skill skill = rs.get();
			if(skillDTO.getPassive() != null) {
				skill.setPassive(skillDTO.getPassive());
			}
			if(skillDTO.getSkillActiveButton() != null && !skillDTO.getSkillActiveButton().equals("")) {
				skill.setSkillActiveButton(skillDTO.getSkillActiveButton());
			}
			if(skillDTO.getSkillCoolDown() != null && !skillDTO.getSkillCoolDown().equals("")) {
				skill.setSkillCoolDown(skillDTO.getSkillCoolDown());
			}
			if(skillDTO.getSkillDescription() != null && !skillDTO.getSkillDescription().equals("")) {
				skill.setSkillDescription(skillDTO.getSkillDescription());
			}
			if(skillDTO.getSkillName() != null && !skillDTO.getSkillName().equals("")) {
				skill.setSkillName(skillDTO.getSkillName());
			}
			this.updateSkill(skill);
		}
		else throw new Exception("Skill not found");
	}
	
	

}
