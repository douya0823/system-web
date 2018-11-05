package com.uaf.controller;

import java.awt.Insets;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

public class PdfUtil {
	protected int topValue = 0;
	protected int leftValue = 20;
	protected int rightValue = 10;
	protected int bottomValue = 0;
	protected int userSpaceWidth = 700;

	/**
	* @param args
	*/
	public static void main(String[] args) {
		try {
			PdfUtil jt = new PdfUtil();
			//
			//String html = readFile("D:/input/261.0.html", "GBK");
			String html = readFile("C:/Users/KJ00054/Desktop/summer.html", "GBK");
			jt.doConversion2(html, "D:\\Test\\11.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doConversion2(String htmlDocument, String outputPath) throws InvalidParameterException,
			MalformedURLException, IOException {

		PD4ML pd4ml = new PD4ML();

		pd4ml.setHtmlWidth(userSpaceWidth); // set frame width of
		// "virtual web browser"

		// choose target paper format
		pd4ml.setPageSize(PD4Constants.A4);

		// define PDF page margins
		//pd4ml.setPageInsets(new Insets(topValue, leftValue, bottomValue, rightValue));
		//pd4ml.setPageInsetsMM(new Insets(topValue, leftValue, bottomValue, rightValue));

		// source HTML document also may have margins, could be suppressed this
		// way
		// (PD4ML *Pro* feature):
		//pd4ml.addStyle("BODY {margin: 0; font-family:MSJH}", true);

		// If built-in basic PDF fonts are not sufficient or
		// if you need to output non-Latin texts, TTF embedding feature should
		// help
		// (PD4ML *Pro*)
		// pd4ml.useTTF("C:\\workspace\\HtmlToPDF", true);
		//pd4ml.useTTF("java:fonts", true);
		pd4ml.useTTF("D:/Test/fonts", true); //D:/Test/fonts文件夹可自定义,保持一致即可
		//pd4ml.setDefaultTTFs("MSJH", "Arial", "Courier New");
		//pd4ml.setDefaultTTFs("SimSun", "SimSun", "SimSun");//该字体对应fonts中的.ttf文件 (如:simsun.ttc)
		
		PD4ML.getVersion(); // 静态方法,查看pd4ml版本
		pd4ml.enableDebugInfo(); 
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// actual document conversion from HTML string to byte array
		pd4ml.render(new StringReader(htmlDocument), baos);
		// if the HTML has relative references to images etc,
		// use render() method with baseDirectory parameter instead
		baos.close();

		System.out.println("resulting PDF size: " + baos.size() + " bytes");
		// in Web scenarios it is a good idea to send the size with
		// "Content-length" HTTP header

		File output = new File(outputPath);
		java.io.FileOutputStream fos = new java.io.FileOutputStream(output);
		fos.write(baos.toByteArray());
		fos.close();

		System.out.println(outputPath + "\ndone.");
	}

	public final static String readFile(String path, String encoding) throws IOException {

		File f = new File(path);
		FileInputStream is = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(is);

		ByteArrayOutputStream fos = new ByteArrayOutputStream();
		byte buffer[] = new byte[2048];

		int read;
		do {
			read = is.read(buffer, 0, buffer.length);
			if (read > 0) {
				fos.write(buffer, 0, read);
			}
		} while (read > -1);

		fos.close();
		bis.close();
		is.close();

		return fos.toString(encoding);
	}

}
