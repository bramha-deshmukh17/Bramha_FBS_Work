package casestudy2.view;

import java.util.List;
import java.util.Scanner;

import casestudy2.controller.HouseController;
import casestudy2.model.*;

public class HouseView {

	HouseController hc;
	Scanner sc;

	public HouseView(HouseController hc) {
		this.hc = hc;
		sc = new Scanner(System.in);
	}

	public void start() {
		boolean running = true;

		while (running) {
			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

				case 0: {
					running = false;
					System.out.println("Exiting...");
					break;
				}

				case 1: {
					addRoom();
					break;
				}

				case 2: {
					removeRoom();
					break;
				}

				case 3: {
					getRoomsList();
					break;
				}

				case 4: {
					addDevice();
					break;
				}

				case 5: {
					removeDevice();
					break;
				}

				case 6: {
					turnOnDevice();
					break;
				}

				case 7: {
					turnOffDevice();
					break;
				}

				case 8: {
					checkStatus();
					break;
				}

				case 9: {
					showDeviceTime();
					break;
				}

				case 10: {
					operateDevice();
					break;
				}

				default: {
					System.out.println("Invalid choice.");
					break;
				}
			}

		}

		sc.close();
	}

	public void operateDevice() {
		System.out.print("Enter Room ID: ");
		int roomId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Device ID: ");
		int deviceId = sc.nextInt();
		sc.nextLine();

		Device device = hc.findDevice(roomId, deviceId);

		if (device == null) {
			System.out.println("Device not found.");
			return;
		}

		System.out.println("Operating Device: " + device.getClass().getSimpleName());

		if (device instanceof Light) {
			operateLight((Light) device, roomId);
		} else if (device instanceof Fan) {
			operateFan((Fan) device, roomId);
		} else if (device instanceof Ac) {
			operateAc((Ac) device, roomId);
		} else if (device instanceof Tv) {
			operateTv((Tv) device, roomId);
		} else if (device instanceof Shower) {
			operateShower((Shower) device, roomId);
		} else {
			System.out.println("This device has no special operations.");
		}
	}

	public void operateLight(Light light, int roomId) {
		System.out.println("1. Change Color\n2. Change Intensity");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.print("New Color: ");
			String color = sc.nextLine();
			hc.changeLightColor(roomId, light.getDeviceId(), color);
		} else if (choice == 2) {
			System.out.print("New Intensity: ");
			int intensity = sc.nextInt();
			sc.nextLine();
			hc.changeLightIntensity(roomId, light.getDeviceId(), intensity);
		}
	}

	public void operateFan(Fan fan, int roomId) {
		System.out.println("1. Change Speed");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.print("New Speed: ");
			int speed = sc.nextInt();
			sc.nextLine();
			hc.changeFanSpeed(roomId, fan.getDeviceId(), speed);
		}
	}

	public void operateAc(Ac ac, int roomId) {
		System.out.println("1. Change Temperature\n2. Change Fan Speed\n3. Change Mode");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.print("New Temperature: ");
			int temp = sc.nextInt();
			sc.nextLine();
			hc.changeAcTemperature(roomId, ac.getDeviceId(), temp);
		} else if (choice == 2) {
			System.out.print("New Fan Speed: ");
			int speed = sc.nextInt();
			sc.nextLine();
			hc.changeAcFanSpeed(roomId, ac.getDeviceId(), speed);
		} else if (choice == 3) {
			System.out.print("New Mode: ");
			String mode = sc.nextLine();
			hc.changeAcMode(roomId, ac.getDeviceId(), mode);
		}
	}

	public void operateTv(Tv tv, int roomId) {
		System.out.println("1. Change Channel\n2. Change Volume\n3. Change Input Source");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.print("New Channel: ");
			int channel = sc.nextInt();
			sc.nextLine();
			hc.changeTvChannel(roomId, tv.getDeviceId(), channel);
		} else if (choice == 2) {
			System.out.print("Volume change (+/-): ");
			int vol = sc.nextInt();
			sc.nextLine();
			hc.changeTvVolume(roomId, tv.getDeviceId(), vol);
		} else if (choice == 3) {
			System.out.print("New Source (HDMI1, HDMI2, AV, USB): ");
			String src = sc.nextLine();
			hc.changeTvInputSource(roomId, tv.getDeviceId(), src);
		}
	}

	public void operateShower(Shower shower, int roomId) {
		System.out.println("1. Change Water Temperature\n2. Change Flow Rate");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.print("New Water Temp: ");
			double temp = sc.nextDouble();
			sc.nextLine();
			hc.changeShowerWaterTemp(roomId, shower.getDeviceId(), temp);
		} else if (choice == 2) {
			System.out.print("New Flow Rate: ");
			int rate = sc.nextInt();
			sc.nextLine();
			hc.changeShowerFlowRate(roomId, shower.getDeviceId(), rate);
		}
	}

	public void showDeviceTime() {
		System.out.println("Room ID: ");
		int roomId = sc.nextInt();
		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		long t = hc.totalTimeTillLastStateChange(roomId, id);
		if (t == -1) {
			System.out.println("Failed to get time.");
		} else {
			System.out.println("Time since last state change (ms): " + t);
		}
	}

	public void checkStatus() {
		System.out.println("Room ID: ");
		int roomId = sc.nextInt();
		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int result = hc.checkDeviceStatus(roomId, id);
		if (result == -1)
			System.out.println("Failed to get device status.");
		else
			System.out.println("Status: " + (result == 1 ? "ON" : "OFF"));

	}

	public void turnOffDevice() {
		System.out.println("Room ID: ");
		int roomId = sc.nextInt();
		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		if (hc.turnOffDevice(roomId, id) == -1)
			System.out.println("Failed to turn off device.");
		else
			System.out.println("Device Turned OFF.");
	}

	public void turnOnDevice() {
		System.out.println("Room ID: ");
		int roomId = sc.nextInt();
		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		if (hc.turnOnDevice(roomId, id) == -1)
			System.out.println("Failed to turn on device.");
		else
			System.out.println("Device Turned ON.");
	}

	public void removeDevice() {
		System.out.print("Room ID: ");
		int roomId = sc.nextInt();
		sc.nextLine();
		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		if (hc.removeDevice(roomId, id) == -1)
			System.out.println("Failed to remove device.");
		else
			System.out.println("Device Removed.");
	}

	public void addDevice() {
		System.out.print("Room ID: ");
		int roomId = sc.nextInt();
		sc.nextLine();
		System.out.println("1. Light");
		System.out.println("2. Fan");
		System.out.println("3. AC");
		System.out.println("4. TV");
		System.out.println("5. Shower");
		int dchoice = sc.nextInt();
		sc.nextLine();

		System.out.print("Device ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		Device device = null;

		switch (dchoice) {

			case 1: {
				System.out.print("Color: ");
				String color = sc.nextLine();
				System.out.print("Intensity: ");
				int intensity = sc.nextInt();
				sc.nextLine();
				device = new Light(id, color, intensity);
				break;
			}

			case 2: {
				System.out.print("No. of Blades: ");
				int blades = sc.nextInt();
				sc.nextLine();
				System.out.print("Speed: ");
				int sp = sc.nextInt();
				sc.nextLine();
				device = new Fan(id, blades, sp);
				break;
			}

			case 3: {
				System.out.print("Temperature: ");
				int temp = sc.nextInt();
				sc.nextLine();
				System.out.print("Fan Speed: ");
				int fanSpeed = sc.nextInt();
				sc.nextLine();
				System.out.print("Mode: ");
				String mode = sc.nextLine();
				device = new Ac(id, temp, fanSpeed, mode);
				break;
			}

			case 4: {
				System.out.print("Channel: ");
				int ch = sc.nextInt();
				sc.nextLine();
				System.out.print("Volume (0-100): ");
				int vol = sc.nextInt();
				sc.nextLine();
				System.out.print("Device Name: ");
				String name = sc.nextLine();
				System.out.print("Input Source (HDMI1/HDMI2/AV/USB): ");
				String src = sc.nextLine();
				Tv.ipSource source;
				try {
					source = Tv.ipSource.valueOf(src.toUpperCase());
				} catch (IllegalArgumentException ex) {
					source = Tv.ipSource.HDMI1;
				}
				device = new Tv(id, ch, vol, name, source);
				break;
			}

			case 5: {
				System.out.print("Water Temp: ");
				double wt = sc.nextDouble();
				System.out.print("Flow Rate: ");
				int fr = sc.nextInt();
				sc.nextLine();
				device = new Shower(id, wt, fr);
				break;
			}

			default:
				System.out.println("Invalid device option.");
				break;
		}

		if (device != null) {
			if (hc.addDevice(roomId, device) == -1)
				System.out.println("Failed to add device.");
			else
				System.out.println("Device Added.");
		}
	}

	public void getRoomsList() {
		List<Room> rooms = hc.getRooms();
		if (rooms.isEmpty()) {
			System.out.println("\nNo rooms found!");
			return;
		}
		System.out.println("\n--- House Details ---");
		for (int i = 0; i < rooms.size(); i++) {
			Room r = rooms.get(i);
			System.out.println("\n" + (i + 1) + ". Room: " + r.getRoomType() + " (ID: " + r.getRoomId() + ", Area: "
					+ r.getArea() + " sq.m)");
			List<Device> devs = r.getDevices();
			System.out.println("  Devices:");
			if (devs.isEmpty()) {
				System.out.println("    - No devices in this room.");
			} else {
				for (Device d : devs) {
					String details = "    - ID: " + d.getDeviceId() + " | " + d.getClass().getSimpleName() + " | On: "
							+ (d.isOn() ? "Yes" : "No");
					if (d instanceof Light) {
						Light l = (Light) d;
						details += " | Color: " + l.getColor() + " | Intensity: " + l.getIntensity();
					} else if (d instanceof Fan) {
						Fan f = (Fan) d;
						details += " | Blades: " + f.getNoOfBlades() + " | Speed: " + f.getSpeed();
					} else if (d instanceof Ac) {
						Ac a = (Ac) d;
						details += " | Temp: " + a.getTemperature() + "°C | Fan Speed: " + a.getFanspeed() + " | Mode: "
								+ a.getMode();
					} else if (d instanceof Tv) {
						Tv t = (Tv) d;
						details += " | Channel: " + t.getCurrentChannel() + " | Volume: " + t.getVolume()
								+ " | Source: "
								+ t.getInputSource();
					} else if (d instanceof Shower) {
						Shower s = (Shower) d;
						details += " | Water Temp: " + s.getCurrentwatertemp() + "°C | Flow Rate: " + s.getFlowrate();
					}
					System.out.println(details);
				}
			}
		}
		System.out.println("---------------------");
	}

	public void removeRoom() {
		System.out.print("Room ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int result = hc.removeRoom(id);
		if (result != -1)
			System.out.println("ID: " + result + " Room Removed.");
		else
			System.out.println("Failed to remove the room");
	}

	public void addRoom() {
		System.out.print("Room Type: ");
		String type = sc.nextLine();
		System.out.print("Area: ");
		double area = sc.nextDouble();
		sc.nextLine();
		try {
			Room room = new Room(area, type);
			int newId = hc.addRoom(room);
			System.out.println("Room added successfully with ID: " + newId);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayMenu() {

		System.out.println("\n0. Exit");
		System.out.println("1. Add Room");
		System.out.println("2. Remove Room");
		System.out.println("3. List Rooms");
		System.out.println("4. Add Device to Room");
		System.out.println("5. Remove Device from Room");
		System.out.println("6. Turn ON Device");
		System.out.println("7. Turn OFF Device");
		System.out.println("8. Check Device Status");
		System.out.println("9. Show Device Time Since Last Change");
		System.out.println("10. Operate Device");
		System.out.print("Enter choice: ");
	}

}