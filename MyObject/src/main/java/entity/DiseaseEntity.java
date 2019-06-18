package entity;

public class DiseaseEntity {
	private int no;
	private String name ;
	private String buwei ;
	private String percent ;
	private String seson ;
	private String people ;
	private String acctive ;
	private String way ;
	private String keshi ;
	private String yibao ;
	private String time ;
	private String money ;
	private String zhiyu ;
	private String care ;
	private String diet ;
	private String ban ;
	
	public DiseaseEntity() {
		
	}
/**
 * 疾病百科输出目录名字，
 * @param no  传值去查看详情
 * @param name  展示疾病百科名字
 */
	public DiseaseEntity(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public DiseaseEntity(int no, String name, String buwei, String percent, String seson, String people, String acctive,
			String way, String keshi, String yibao, String time, String money, String zhiyu, String care, String diet,
			String ban) {
		super();
		this.no = no;
		this.name = name;
		this.buwei = buwei;
		this.percent = percent;
		this.seson = seson;
		this.people = people;
		this.acctive = acctive;
		this.way = way;
		this.keshi = keshi;
		this.yibao = yibao;
		this.time = time;
		this.money = money;
		this.zhiyu = zhiyu;
		this.care = care;
		this.diet = diet;
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuwei() {
		return buwei;
	}

	public void setBuwei(String buwei) {
		this.buwei = buwei;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getSeson() {
		return seson;
	}

	public void setSeson(String seson) {
		this.seson = seson;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getAcctive() {
		return acctive;
	}

	public void setAcctive(String acctive) {
		this.acctive = acctive;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getKeshi() {
		return keshi;
	}

	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}

	public String getYibao() {
		return yibao;
	}

	public void setYibao(String yibao) {
		this.yibao = yibao;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getZhiyu() {
		return zhiyu;
	}

	public void setZhiyu(String zhiyu) {
		this.zhiyu = zhiyu;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	@Override
	public String toString() {
		return "DiseaseEntity [no=" + no + ", name=" + name + ", buwei=" + buwei + ", percent=" + percent + ", seson="
				+ seson + ", people=" + people + ", acctive=" + acctive + ", way=" + way + ", keshi=" + keshi
				+ ", yibao=" + yibao + ", time=" + time + ", money=" + money + ", zhiyu=" + zhiyu + ", care=" + care
				+ ", diet=" + diet + ", ban=" + ban + "]";
	}

	
	
	
}
