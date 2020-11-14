package main.skill;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import main.passive.PassiveService;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private PassiveService passiveRepo;
	
	public void updateSkill(Skill skill) {
		this.skillRepo.save(skill);
	}
	
	public void updateInfoOfSkill(SkillDTO skillDTO) throws Exception  {
		Optional<Skill> rs = this.skillRepo.findById(Long.parseLong(skillDTO.getSkillId()));
		if(!rs.isEmpty()) {
			Skill skill = rs.get();
			if(skillDTO.getPassive() != null) {
				skill.setPassive(null);
				skillDTO.getPassive().setSkill(skill);
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
			if(skillDTO.getPassive() != null) {
				this.passiveRepo.savePassive(skillDTO.getPassive());
			}
		}
		else throw new Exception("Skill not found");
	}
	
	public void deletePassiveOfSkill(long skillId) throws Exception {
		Optional<Skill> skill = this.skillRepo.findById(skillId);
		if(!skill.isEmpty()) {
			skill.get().setPassive(null);
			this.updateSkill(skill.get());
		}
		else throw new Exception("Skill not found");
	}
	
	public Skill getSkillByIdEagerly(long skillId) throws Exception {
		Skill skill = this.skillRepo.getSkillByIdEagerly(skillId);
		if(skill != null) {
			return skill;
		}
		else throw new Exception("Skill not found");
	}
	
	
	
	
	
	
	
	
	
	

}
