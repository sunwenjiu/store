package entity;

public class ChecksEntity {
	private int id;
	private String name;
	private String unsuitable;
	public ChecksEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChecksEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ChecksEntity(int id, String name, String unsuitable) {
		super();
		this.id = id;
		this.name = name;
		this.unsuitable = unsuitable;
	}
	@Override
	public String toString() {
		return "ChecksEntity [id=" + id + ", name=" + name + ", unsuitable=" + unsuitable + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnsuitable() {
		return unsuitable;
	}
	public void setUnsuitable(String unsuitable) {
		this.unsuitable = unsuitable;
	}
	

}
