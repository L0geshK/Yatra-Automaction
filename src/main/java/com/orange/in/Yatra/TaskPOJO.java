package com.orange.in.Yatra;

public class TaskPOJO {
	private String Name;
	private String Memory;
	private String CPU;
	private String Disk;
	private String Network;
	public TaskPOJO(String name, String memory, String cPU, String disk, String network) {
		super();
		Name = name;
		Memory = memory;
		CPU = cPU;
		Disk = disk;
		Network = network;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMemory() {
		return Memory;
	}
	public void setMemory(String memory) {
		Memory = memory;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getDisk() {
		return Disk;
	}
	public void setDisk(String disk) {
		Disk = disk;
	}
	public String getNetwork() {
		return Network;
	}
	public void setNetwork(String network) {
		Network = network;
	}
	@Override
	public String toString() {
		return "TaskPOJO [Name=" + Name + ", Memory=" + Memory + ", CPU=" + CPU + ", Disk=" + Disk + ", Network="
				+ Network + "]";
	}
	
}
