package cn.tedu.conntroller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.pojo.ResponseResult;
import cn.tedu.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping("getreg.do")
	public String getReg(){
		return "reg";
	}
	@RequestMapping("checkId.do")
	@ResponseBody
	public ResponseResult<Void> checkId(String id){
		System.out.println(111);
		if(service.checkName(id)==null){
			return new ResponseResult<Void>(1, "id可用");
		}
	    return new ResponseResult<Void>(0, "id已经被注册");
	}
	/**
	 * 生成验证码
	 */
	static String c="qwertyupasfghjkzxcvbnm23456789";
	@RequestMapping(value="code.do",produces="image/png")
	@ResponseBody
	public byte[] code(HttpSession session) throws IOException {
		Random r=new Random();
		char[] code=new char[4];
		for (int i = 0; i < 4; i++) {
			code[i]=c.charAt(r.nextInt(c.length()));
		}
		String str=new String(code);
		session.setAttribute("code", str);
		BufferedImage image=new BufferedImage(100, 40, BufferedImage.TYPE_3BYTE_BGR);
		//设置背景颜色
		image.setRGB(30, 20, 0xffff00);
		Graphics2D g=image.createGraphics();
		//设置字体
		Font font=new Font(Font.SANS_SERIF,Font.PLAIN,30);
		g.setFont(font);
		g.setColor(new Color(r.nextInt(0xffffff)));
		g.drawString(str,20,30);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ImageIO.write(image, "png", out);
		out.close();
		byte[] bs=out.toByteArray();
		return bs;
	}
}
