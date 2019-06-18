package entity;

public class Hero {
	private int id;
	private String name;
	private String  nickname;
	private String   sex;
	private String   language;
	private String   camp;
	private String   type;
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hero(int id, String name, String nickname, String sex, String camp) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.sex = sex;
		this.camp = camp;
	}

	public Hero(int id, String name, String nickname, String sex, String language, String camp, String type) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.sex = sex;
		this.language = language;
		this.camp = camp;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", nickname=" + nickname + ", sex=" + sex + ", language="
				+ language + ", camp=" + camp + ", type=" + type + "]";
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCamp() {
		return camp;
	}
	public void setCamp(String camp) {
		this.camp = camp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}
