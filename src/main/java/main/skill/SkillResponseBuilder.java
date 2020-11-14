package main.skill;

public class SkillResponseBuilder {
	
	public static SkillFake buildResponse(Skill skill) {
		return new SkillFake(skill, 3);
	}

}
