package entity;

public class DrugsEntity {
 private int	id; // comment '主键约束',
 private String name ;// comment '药名',
 private String basis;// text comment '主要成分',
 private String indication ;//text comment '适应症',
 private String dosage;// text comment '用法用量',
 private String reaction;// text comment '不良反应', 
 private String attentions ;//text comment '注意事项',
 private String taboo;// text comment '禁忌',
 private String dosage_forms ;//text comment '剂型',
 private String yao_character ;//text comment '性状',
 private String store;// text comment '贮藏',
 private String effective;// int comment '有效期:按月计'
public DrugsEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public DrugsEntity(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public DrugsEntity(int id, String name, String basis, String indication, String dosage, String reaction,
		String attentions, String taboo, String dosage_forms, String yao_character, String store, String effective) {
	super();
	this.id = id;
	this.name = name;
	this.basis = basis;
	this.indication = indication;
	this.dosage = dosage;
	this.reaction = reaction;
	this.attentions = attentions;
	this.taboo = taboo;
	this.dosage_forms = dosage_forms;
	this.yao_character = yao_character;
	this.store = store;
	this.effective = effective;
}
@Override
public String toString() {
	return "DrugsEntity [id=" + id + ", name=" + name + ", basis=" + basis + ", indication=" + indication + ", dosage="
			+ dosage + ", reaction=" + reaction + ", attentions=" + attentions + ", taboo=" + taboo + ", dosage_forms="
			+ dosage_forms + ", yao_character=" + yao_character + ", store=" + store + ", effective=" + effective + "]";
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
public String getBasis() {
	return basis;
}
public void setBasis(String basis) {
	this.basis = basis;
}
public String getIndication() {
	return indication;
}
public void setIndication(String indication) {
	this.indication = indication;
}
public String getDosage() {
	return dosage;
}
public void setDosage(String dosage) {
	this.dosage = dosage;
}
public String getReaction() {
	return reaction;
}
public void setReaction(String reaction) {
	this.reaction = reaction;
}
public String getAttentions() {
	return attentions;
}
public void setAttentions(String attentions) {
	this.attentions = attentions;
}
public String getTaboo() {
	return taboo;
}
public void setTaboo(String taboo) {
	this.taboo = taboo;
}
public String getDosage_forms() {
	return dosage_forms;
}
public void setDosage_forms(String dosage_forms) {
	this.dosage_forms = dosage_forms;
}
public String getYao_character() {
	return yao_character;
}
public void setYao_character(String yao_character) {
	this.yao_character = yao_character;
}
public String getStore() {
	return store;
}
public void setStore(String store) {
	this.store = store;
}
public String getEffective() {
	return effective;
}
public void setEffective(String effective) {
	this.effective = effective;
}



}
