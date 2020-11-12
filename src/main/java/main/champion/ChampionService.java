package main.champion;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.equipment.Equipment;
import main.passive.Passive;
import main.skill.Skill;

@Service
public class ChampionService {
	@Autowired
	private ChampionRepository championRepo;
	
	public void saveChampion(Champion champion) {
		Iterator<Skill> iterSkill = champion.getSkill().iterator();
		while(iterSkill.hasNext()) {
			Skill skill = iterSkill.next();
			skill.setChampion(champion);
			Passive passive = skill.getPassive();
			if(passive != null) {
				passive.setSkill(skill);
			}
		}
		Passive passive = champion.getPassive();
		passive.setChampion(champion);
		this.championRepo.save(champion);
	}

}
