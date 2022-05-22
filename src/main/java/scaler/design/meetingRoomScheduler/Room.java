package scaler.design.meetingRoomScheduler;

public class Room {
	int id;
	String name;
	RoomStatus status;
	MeetingDetails meetingDetails;
	public Room(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.status = RoomStatus.FREE;
	}
}