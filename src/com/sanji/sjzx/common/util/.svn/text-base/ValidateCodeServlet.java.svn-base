package com.sanji.sjzx.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 验证码图片的宽度�?
	private int width = 60;
	// 验证码图片的高度�?
	private int height = 20;
	// 验证码字符个�?
	private int codeCount = 4;

	private int x = 0;
	// 字体高度
	private int fontHeight;
	private int codeY;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 初始化验证图片属�?
	 */
	public void init() throws ServletException {
		// 从web.xml中获取初始信�?
		// 宽度
		String strWidth = this.getInitParameter("width");
		// 高度
		String strHeight = this.getInitParameter("height");
		// 字符个数
		String strCodeCount = this.getInitParameter("codeCount");

		// 将配置的信息转换成数�?
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
		}

		x = width / (codeCount + 1);
		fontHeight = height - 5;
		codeY = height - 4;

	}

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {

		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();

		// 创建�?��随机数生成器�?
		Random random = new Random();

		// 将图像填充为白色
		g.setColor(Color.WHITE);
		// g.setColor(new Color(204,232,207));
		g.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定�?
		Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
		// 设置字体�?
		g.setFont(font);

		// 画边框�?
		// g.setColor(Color.BLACK);
		g.setColor(new Color(213, 213, 213));
		g.drawRect(0, 0, width - 3, height - 3);

		// 随机产生10条干扰线，使图象中的认证码不易被其它程序探测到�?
		g.setColor(new Color(213, 213, 213));
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(24);
			int yl = random.nextInt(24);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证�?
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生codeCount数字的验证码�?
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字�?
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构�?颜色值，这样输出的每位数字的颜色值都将不同�?
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中�?
			g.setColor(new Color(red, green, blue));
			// g.setColor(Color.BLACK);
			g.drawString(strRand, i * x, codeY);

			// 将产生的四个随机数组合在�?���?
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中�?
		HttpSession session = req.getSession();
		session.setAttribute("validateCode", randomCode.toString());

		// 禁止图像缓存�?
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpg");

		// 将图像输出到Servlet输出流中�?
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpg", sos);
		sos.close();
	}

}
