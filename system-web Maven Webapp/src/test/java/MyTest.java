
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aspose.words.HtmlSaveOptions;

/**
 * 
 * 文件名：Test.java
 * 描述：
 * 作者：SZ05488
 * 日期：2018年5月25日下午3:40:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-applicationContext.xml" })
public class MyTest {
	@Autowired
	static String localhost = "http://ld.uaf.com.cn/UaScoreRules/customer/";

	@Test
	public void getScore() {
		// String
		// url='http://10.168.11.111:8022/UaScoreRules/loan/getScoreInfo.do';
		String url = "http://ld.uaf.com.cn/UaScoreRules/loan/getScoreInfo.do";
		try {
			String s2 = "1{SQRGR_}2{SQRGR_}3";

			String[] ss = s2.split("\\{" + "SQRGR_" + "\\}");
			// WordtoHtml.Word2003ToHtml("D:/input", "rhgzs", ".doc");
			//Document doc = new Document("D:\\input\\rhgzs.doc");// path为word地址

			HtmlSaveOptions hso = new HtmlSaveOptions();

			//hso.setExportRoundtripInformation(true);

			//doc.save("D:\\input\\rhg" + ".html", hso);// 保存html，path+".html"为我定义的生成html的名字
			
			String jsonString="[{'aAS_NBR': '20180724140100000040', 'bAR_CODE': '2018072414010000004', 'dWELL_ID': '1'}]";
			 JSONArray array = JSONArray.fromObject(jsonString);
			 Object[] obj = new Object[array.size()];
			    for (int i = 0; i < array.size(); i++) {
			        JSONObject jsonObject = array.getJSONObject(i);
			        obj[i] = (Object)jsonObject;
			        System.out.print(obj[i]);
			    }
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
