package mvc;

public class Demo {
	
	@RequestMapping("/listUser.do")
	public String listUser() {
		
		return "listUser...";
	}
@RequestMapping("/addUser.do")
	public String addUser() {
		
		return "addUser...";
	}
	
}
