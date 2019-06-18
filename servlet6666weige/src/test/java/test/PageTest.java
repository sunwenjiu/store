package test;

import java.util.List;

import org.junit.Test;

import dao.HeroDAO;
import entity.Hero;

public class PageTest {
@Test
public void test01() {
	HeroDAO dao = new HeroDAO();
		List<Hero> heros=dao.findbyPage(5, 5);
		for (Hero hero : heros) {
			System.out.println(hero);
		}
}


}
