package main.equipment;

public class EquipmentResponseBuilder {
	
	public static EquipmentFake buildResponse(Equipment equipment) {
		return new EquipmentFake(equipment, 1);
	}

}
