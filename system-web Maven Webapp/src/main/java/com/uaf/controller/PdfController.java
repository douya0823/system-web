package com.uaf.controller;

import java.awt.Insets;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.reflect.TypeToken;
import com.uaf.bean.ContractInfo;
import com.uaf.bean.ContractModel;
import com.uaf.bean.ContractParam;
import com.uaf.bean.ContractVersion;
import com.uaf.bean.LoanParam;
import com.uaf.service.ContractManageServiceService;
import com.uaf.util.CommonUtils;
import com.uaf.util.JsonUtil;
import com.uaf.util.ParameterMap;

/**
 * 文件名：PrintController.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年7月19日下午5:42:58
 */
@Controller()
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private ContractManageServiceService contractManageService;
	protected int topValue = 10;
	protected int leftValue = 20;
	protected int rightValue = 10;
	protected int bottomValue = 10;
	protected int userSpaceWidth = 700;

	// protected int userSpaceWidth = 775;

	@RequestMapping(value = "/downPdf", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> downPdf(@RequestParam(value = "info", required = false) String info,
			HttpServletResponse response) throws IOException {
		Map<String, String> result = new HashMap<String, String>();
		if (CommonUtils.isBlank(info)) {
			result.put("code", "1111");
			result.put("message", "参数为空");
			return result;
		}

		try {
			JSONObject reObject2 = JSONObject.parseObject(info);
			Map<String, Object> pMap = (Map<String, Object>) reObject2;
			Object obj1 = pMap.get("query");
			Map map1 = (Map) obj1;
			Object obj2 = pMap.get("param");
			Map map2 = (Map) obj2;

			ContractModel contractModel = contractManageService.getContractModelById(map1);
			if (contractModel == null) {
				result.put("code", "1111");
				result.put("message", "模板不存在");
				return result;
			}

			String contractUrl = contractModel.getUrl();
			if (CommonUtils.isBlank(contractUrl)) {
				result.put("code", "1111");
				result.put("message", "模板文件地址为空");
				return result;
			}

			// 生成暂时html路径
			String url = "D:/input/temp/" + contractModel.getName() + contractModel.getVersion() + ".html";
			File htmlUrl = new File(url);
			// 生成pdf路径
			String pdfUrl = "D:/input/temp/" + contractModel.getName() + contractModel.getVersion() + ".pdf";
			File pdfFile = new File(pdfUrl);
			if (!pdfFile.exists()) {
				pdfFile.createNewFile();
			}

			// 读取模板文件
			StringBuffer data = null;
			BufferedReader br = null;
			File file = new File(contractUrl);
			if (file.isFile() && file.exists()) {

				try {
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
					data = new StringBuffer();
					br = new BufferedReader(reader);
					String line = null;
					while ((line = br.readLine()) != null) {
						data = data.append(line);
					}

					String pd4mlStart = "<%@ taglib uri='http://pd4ml.com/tlds/pd4ml/2.6' prefix='pd4ml' %><%@page contentType='text/html; charset=utf-8'%><pd4ml:transform screenWidth='400' pageFormat='A5' pageOrientation='landscape' pageInsets='100,100,100,100,points'><html>";
					String pd4mlEnd = "</html></pd4ml:transform>";
					String content = pd4mlStart + data.toString() + pd4mlEnd;
					// content = content.replace("my_break",
					// "<pd4ml:page.break/>");
					content = content.replace("<hr style=\"page-break-after:always;\" class=\"ke-pagebreak\" />",
							"<pd4ml:page.break/>");

					// 生成暂时的html文件
					BufferedWriter out = new BufferedWriter(new FileWriter(htmlUrl));
					out.write(content);
					out.flush();
					out.close();

					// 由html转换成pdf文件
					PdfController jt = new PdfController();
					String html = jt.readFile(url, "UTF-8");
					jt.doConversion2(html, pdfUrl);

					// 下载pdf文件
					File newFile = new File(pdfUrl);
					// File newFile = new File(contractUrl);
					InputStream in = null;
					OutputStream os = null;
					try {
						// response.setCharacterEncoding("utf-8");//第一句，设置服务器端编码
						// response.setContentType("text/html;charset=GBK");//第二句，设置浏览器端解码
						response.setContentType("application/pdf");
						in = new FileInputStream(newFile);
						os = response.getOutputStream();
						byte[] b = new byte[1024];
						while (in.read(b) != -1) {
							os.write(b);
						}
						in.close();
						os.flush();
						os.close();
					} catch (Exception e) {
						try {
							if (null != in) {
								in.close();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							if (null != os) {
								os.close();
							}
						} catch (IOException e2) {
							e2.printStackTrace();
							result.put("code", "1111");
							result.put("message", "系统错误");
							return result;
						}

					}

				} catch (IOException e) {
					e.printStackTrace();
					result.put("code", "1111");
					result.put("message", "系统错误");
					return result;

				} finally {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				result.put("code", "0000");
				result.put("message", "成功下载");
				return result;
			} else {
				result.put("code", "1111");
				result.put("message", "模板文件不存在");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", "1111");
			result.put("message", "系统错误");
			return result;
		}
	}

	@RequestMapping(value = "/previewPdf")
	public ModelAndView previewPdf(@RequestParam(value = "info", required = false) String info,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (CommonUtils.isBlank(info)) {
			request.setAttribute("message", "参数为空");
			return new ModelAndView("/error");
		}

		try {
			JSONObject reObject2 = JSONObject.parseObject(info);
			Map<String, Object> pMap = (Map<String, Object>) reObject2;
			Object obj1 = pMap.get("query");
			Map map1 = (Map) obj1;
			Object obj2 = pMap.get("param");
			Map map2 = (Map) obj2;

			ContractModel contractModel = contractManageService.getContractModelById(map1);
			if (contractModel == null) {
				request.setAttribute("message", "模板不存在");
				return new ModelAndView("/error");
			}

			String contractUrl = contractModel.getUrl();
			if (CommonUtils.isBlank(contractUrl)) {
				request.setAttribute("message", "模板文件地址为空");
				return new ModelAndView("/error");
			}

			// 生成暂时html路径
			String url = "D:/input/temp/" + contractModel.getName() + contractModel.getVersion() + ".html";
			File htmlUrl = new File(url);
			// 生成pdf路径
			String pdfUrl = "D:/input/temp/" + contractModel.getName() + contractModel.getVersion() + ".pdf";
			File pdfFile = new File(pdfUrl);
			if (!pdfFile.exists()) {
				pdfFile.createNewFile();
			}

			// 读取模板文件
			StringBuffer data = null;
			BufferedReader br = null;
			File file = new File(contractUrl);
			if (file.isFile() && file.exists()) {
				String content = "";
				try {
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
					data = new StringBuffer();
					br = new BufferedReader(reader);
					String line = null;
					while ((line = br.readLine()) != null) {
						data = data.append(line);
					}
					content = "<style> body{margin:12px;} p { display: block; -webkit-margin-before: 0.4em;"
							+ "-webkit-margin-after: 0.4em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;"
							+ "line-height: 1.7!important;}</style>" + data.toString();
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("message", "系统错误");
					return new ModelAndView("/error");
				}
				request.setAttribute("contractHtml", content);
				return new ModelAndView("/print");
			} else {
				request.setAttribute("message", "模板文件不存在");
				return new ModelAndView("/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "系统错误");
			return new ModelAndView("/error");
		}
	}

	@RequestMapping(value = "/getPdf", method = RequestMethod.POST)
	@ResponseBody
	public String getPdf(@RequestParam Map<String, String> params, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		String result = "";
		if (map == null || map.size() < 1) {
			result = "参数为空";
			return result;
		}

		try {

			/* 传入的查询合同参数：城市、产品、合同类型 */
			Map<String, Object> query = new HashMap<String, Object>();
			query.put("contract_type_code", map.get("contract_type_code"));
			query.put("product_code", map.get("appProduct"));
			query.put("city_code", map.get("appCity"));

			/* 传入的显示参数 集合 */
			Map<String, List<Map<String, Object>>> inParamListMap = new HashMap<>();
			Map<String, Object> inParamMap = new HashMap<>();
			for (Entry<String, Object> entry : map.entrySet()) {
				String value = (String) map.get(entry.getKey());
				if (value.startsWith("[")) {// 使用name查询数据库看是否是父集合参数
					JSONArray array = JSONArray.fromObject(entry.getValue());
					List<Object> list = (List<Object>) array;
					if (list != null) {
						List<Map<String, Object>> listMaps = new ArrayList<>();
						for (Object b : list) {
							Object customerInfo = (Object) list.get(0);
							Map<String, Object> customerInfoMap = (Map<String, Object>) customerInfo;
							listMaps.add(customerInfoMap);
						}
						inParamListMap.put(entry.getKey(), listMaps);
					}
				} else {
					inParamMap.put(entry.getKey(), entry.getValue());
				}
			}

			List<ContractInfo> contractInfos = contractManageService.getContractInfoList(query);
			if (contractInfos == null || contractInfos.size() <= 0) {
				result = "合同不存在";
				return result;
			}
			ContractInfo contractInfo = contractInfos.get(0);

			Map<String, Object> map3 = new HashMap<>();
			map3.put("model_id", contractInfo.getContractModel().getId());
			List<ContractParam> contractParams = contractManageService.getContractParamList(map3);
			List<LoanParam> singleParamsList = new ArrayList<LoanParam>();// 单个参数
			List<LoanParam> conllectParamsList1 = new ArrayList<LoanParam>();// 集合父参数
			List<LoanParam> conllectParamsList2 = new ArrayList<LoanParam>();// 集合子参数
			Map<String, List<LoanParam>> needParamList = new HashMap<>();// 需要的所有集合子参数
			for (ContractParam c : contractParams) {
				Map<String, Object> t = new HashMap<>();
				t.put("p_id", c.getParam().getId());
				conllectParamsList2 = contractManageService.getLoanParamList(t);
				LoanParam param = c.getParam();
				if (param.getPId() == null) {
					if (conllectParamsList2 != null && conllectParamsList2.size() > 0) {// 判断是否是父参数
						conllectParamsList1.add(param);// 将父参数放入集合中
						needParamList.put(param.getName(), new ArrayList<LoanParam>());// 创建一父参数名为key的父参名--子参集合的map
					} else {
						singleParamsList.add(c.getParam());// 判断是否是单参数
					}
				} else if (param.getPId() != null) {
					System.out.print(param.getDescription());
				}
			}
			for (ContractParam c : contractParams) {// 再次循环
				if (c.getParam().getPId() != null) {// 判断是否是子参数
					Map<String, Object> t = new HashMap<>();
					t.put("id", c.getParam().getPId().getId());
					LoanParam p = contractManageService.getLoanParamById(t);// 找到对应的父参数，只有一个
					needParamList.get(p.getName()).add(c.getParam());// 将子参数放入上面的
																		// 父参名-->子参集合
																		// 的子参集合中
				}
			}

			if (contractInfo.getContractModel() == null) {
				result = "合同未分配模板";
				return result;
			}
			String contractUrl = contractInfo.getContractModel().getUrl();
			if (CommonUtils.isBlank(contractUrl)) {
				result = "模板文件地址为空";
				return result;
			}

			// 读取模板文件
			StringBuffer data = null;
			BufferedReader br = null;
			File file = new File(contractUrl);
			if (file.isFile() && file.exists()) {

				try {
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
					data = new StringBuffer();
					br = new BufferedReader(reader);
					String line = null;
					while ((line = br.readLine()) != null) {
						data = data.append(line);
					}

					String content = data.toString();

					/* 参数过滤 */
					for (LoanParam c : singleParamsList) {
						Map<String, Object> inParamMap1 = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
						inParamMap1.putAll(inParamMap);
						if (inParamMap1.get(c.getName()) == null || "".equals(inParamMap1.get(c.getName()))) {
							result = "参数不够";
							return result;
						}
						String value = (String) inParamMap1.get(c.getName());
						content = content.replace("{" + c.getDescription() + "}", value);
					}

					/* 父参数过滤 */
					for (LoanParam c : conllectParamsList1) {
						Map<String, List<Map<String, Object>>> inParamListMap1 = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
						inParamListMap1.putAll(inParamListMap);
						if (inParamListMap1.get(c.getName()) == null || "".equals(inParamListMap1.get(c.getName()))) {
							result = "参数不够";
							return result;
						}
						List<LoanParam> listName = needParamList.get(c.getName());// 父参下的所有子参
						List<Map<String, Object>> listValue = inParamListMap1.get(c.getName());// 父参下多条子参数的值，一个map代表一条

						String[] ss = content.split("\\{" + c.getDescription() + "\\}");// 分割content
						if (ss.length == 3) {// 如果该集合名字在content中存在两处，则继续，如果不是则是缺少开头集合名或结尾集合名
							// 取中间字符串进行处理
							String listContent = ss[1];
							if (listValue != null && listValue.size() > 0) {// 如果传入的子参有值
								String[] list = new String[listValue.size()];
								for (int i = 0; i < listValue.size(); i++) {
									list[i] = listContent;
								}
								for (LoanParam o : listName) {// 用模板里需要的子参遍历，用传进的子参值替换，从第一个参数开始
									int i = 0;
									for (Map<String, Object> mm : listValue) {// 找到需要替换的子参，多条则替换多次
										Map<String, Object> m = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
										m.putAll(mm);
										String value = String.valueOf(m.get(o.getName()));
										/*if (value.startsWith("[")) {
											JSONArray array = JSONArray.fromObject(value);
											Object[] obj = new Object[array.size()];
											for (int j = 0; j < array.size(); j++) {
												net.sf.json.JSONObject jsonObject = array.getJSONObject(i);
												obj[j] = (Object) jsonObject;
											}
											String childConten[]=list[i].split("\\{" + o.getDescription() + "\\}");
										}*/
										list[i] = list[i].replace("{" + o.getDescription() + "}", value);
										i++;
									}
								}
								listContent = StringUtils.join(list);
							} else {// 如果传入的子参无值，则将模板中集合删除
								listContent = "";
							}
							content = ss[0] + listContent + ss[2];
							content = "<style> body {margin:12px} p { display: block; -webkit-margin-before: 0.4em;"
									+ "-webkit-margin-after: 0.4em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;"
									+ "line-height: 1.7!important;}</style>" + content;
						}
					}
					return content;
				} catch (IOException e) {
					e.printStackTrace();
					result = "系统错误";
					return result;

				} finally {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				result = "模板文件不存在";
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "系统错误";
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPdf1", method = RequestMethod.POST)
	@ResponseBody
	public String getPdf1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		String result = "";
		if (map == null || map.size() < 1) {
			result = "参数为空";
			return result;
		}

		try {

			/* 传入的查询合同参数：城市、产品、合同类型 */
			Map<String, Object> query = new HashMap<String, Object>();
			query.put("contract_type_code", map.get("contract_type_code"));
			query.put("appProduct", map.get("appProduct"));
			query.put("appCity", map.get("appCity"));

			/* 传入的显示参数 集合 */
			Map<String, List<Map<String, Object>>> inParamListMap = new HashMap<>();
			Map<String, Object> inParamMap = new HashMap<>();
			for (Entry<String, Object> entry : map.entrySet()) {
				String value = (String) map.get(entry.getKey());
				if (value.startsWith("[")) {// 使用name查询数据库看是否是父集合参数
					JSONArray array = JSONArray.fromObject(entry.getValue());
					List<Object> list = (List<Object>) array;
					if (list != null) {
						List<Map<String, Object>> listMaps = new ArrayList<>();
						for (Object b : list) {
							Object customerInfo = (Object) list.get(0);
							Map<String, Object> customerInfoMap = (Map<String, Object>) customerInfo;
							listMaps.add(customerInfoMap);
						}
						inParamListMap.put(entry.getKey(), listMaps);
					}
				} else {
					inParamMap.put(entry.getKey(), entry.getValue());
				}
			}

			List<ContractInfo> contractInfos = contractManageService.getContractInfoList(query);
			if (contractInfos == null || contractInfos.size() <= 0) {
				result = "合同不存在";
				return result;
			}
			ContractInfo contractInfo = contractInfos.get(0);

			Map<String, Object> map3 = new HashMap<>();
			map3.put("model_id", contractInfo.getContractModel().getId());
			List<ContractParam> contractParams = contractManageService.getContractParamList(map3);
			List<LoanParam> singleParamsList = new ArrayList<LoanParam>();// 单个参数
			List<LoanParam> conllectParamsList1 = new ArrayList<LoanParam>();// 集合父参数
			List<LoanParam> conllectParamsList2 = new ArrayList<LoanParam>();// 集合子参数
			Map<String, List<LoanParam>> needParamList = new HashMap<>();// 需要的所有集合子参数
			for (ContractParam c : contractParams) {
				Map<String, Object> t = new HashMap<>();
				t.put("p_id", c.getParam().getId());
				conllectParamsList2 = contractManageService.getLoanParamList(t);
				LoanParam param = c.getParam();
				if (param.getPId() == null) {
					if (conllectParamsList2 != null && conllectParamsList2.size() > 0) {// 判断是否是父参数
						conllectParamsList1.add(param);// 将父参数放入集合中
						needParamList.put(param.getName(), new ArrayList<LoanParam>());// 创建一父参数名为key的父参名--子参集合的map
					} else {
						singleParamsList.add(c.getParam());// 判断是否是单参数
					}
				} else if (param.getPId() != null) {
					System.out.print(param.getDescription());
				}
			}
			for (ContractParam c : contractParams) {// 再次循环
				if (c.getParam().getPId() != null) {// 判断是否是子参数
					Map<String, Object> t = new HashMap<>();
					t.put("id", c.getParam().getPId().getId());
					LoanParam p = contractManageService.getLoanParamById(t);// 找到对应的父参数，只有一个
					needParamList.get(p.getName()).add(c.getParam());// 将子参数放入上面的
																		// 父参名-->子参集合
																		// 的子参集合中
				}
			}

			if (contractInfo.getContractModel() == null) {
				result = "合同未分配模板";
				return result;
			}
			String contractUrl = contractInfo.getContractModel().getUrl();
			if (CommonUtils.isBlank(contractUrl)) {
				result = "模板文件地址为空";
				return result;
			}

			// 生成暂时html路径
			String url = "D:/input/temp/" + contractInfo.getCity().getCode() + contractInfo.getProduct().getCode()
					+ contractInfo.getContractType().getCode() + contractInfo.getContractModel().getVersion() + ".html";
			File htmlUrl = new File(url);
			// 生成pdf路径
			String pdfUrl = "D:/input/temp/" + contractInfo.getCity().getCode() + contractInfo.getProduct().getCode()
					+ contractInfo.getContractType().getCode() + contractInfo.getContractModel().getVersion() + ".pdf";
			File pdfFile = new File(pdfUrl);
			if (!pdfFile.exists()) {
				pdfFile.createNewFile();
			}

			// 读取模板文件
			StringBuffer data = null;
			BufferedReader br = null;
			File file = new File(contractUrl);
			if (file.isFile() && file.exists()) {

				try {
					InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
					data = new StringBuffer();
					br = new BufferedReader(reader);
					String line = null;
					while ((line = br.readLine()) != null) {
						data = data.append(line);
					}

					// data过滤
					String pd4mlStart = "<%@ taglib uri='http://pd4ml.com/tlds/pd4ml/2.6' prefix='pd4ml' %><%@page contentType='text/html; charset=utf-8'%><pd4ml:transform screenWidth='400' pageFormat='A5' pageOrientation='landscape' pageInsets='100,100,100,100,points'><html>";
					String pd4mlEnd = "</html></pd4ml:transform>";
					String content = pd4mlStart + data.toString() + pd4mlEnd;
					// content = content.replace("my_break",
					// "<pd4ml:page.break/>");
					content = content.replace("<hr style=\"page-break-after:always;\" class=\"ke-pagebreak\" />",
							"<pd4ml:page.break/>");

					/* 参数过滤 */
					for (LoanParam c : singleParamsList) {
						Map<String, Object> inParamMap1 = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
						inParamMap1.putAll(inParamMap);
						if (inParamMap1.get(c.getName()) == null || "".equals(inParamMap1.get(c.getName()))) {
							result = "参数不够";
							return result;
						}
						String value = (String) inParamMap1.get(c.getName());
						content = content.replace("{" + c.getDescription() + "}", value);
					}

					/* 父参数过滤 */
					for (LoanParam c : conllectParamsList1) {
						Map<String, List<Map<String, Object>>> inParamListMap1 = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
						inParamListMap1.putAll(inParamListMap);
						if (inParamListMap1.get(c.getName()) == null || "".equals(inParamListMap1.get(c.getName()))) {
							result = "参数不够";
							return result;
						}
						List<LoanParam> listName = needParamList.get(c.getName());// 父参下的所有子参
						List<Map<String, Object>> listValue = inParamListMap1.get(c.getName());// 父参下多条数据的值，一个map代表一条

						String[] ss = content.split("\\{" + c.getDescription() + "\\}");// 分割content
						if (ss.length == 3) {// 如果该集合名字在content中存在两处，则继续，如果不是则是缺少开头集合名或结尾集合名
							// 如果集合>1则找到以集合名字开头和结尾的一段字符串复制并追加
							String listContent = ss[1];
							if (listValue.size() > 1) {
								listContent += listContent;
							}
							if (listValue != null && listValue.size() > 0) {// 如果传入的子参有值

								for (LoanParam o : listName) {// 用模板里需要的子参遍历，用传进的子参值替换，从第一个参数开始
									int i = 0;
									for (Map<String, Object> mm : listValue) {// 找到每条数据里的需要替换的子参，多条则替换多次
										Map<String, Object> m = new LinkedCaseInsensitiveMap<>();// 关于key的大小写问题
										m.putAll(mm);
										listContent = listContent.replace("{" + o.getDescription() + "}",
												String.valueOf(m.get(o.getName())));// 找到第i个替换
										i++;
									}
								}
							} else {// 如果传入的子参无值，则将模板中集合删除
								listContent = "";
							}
							content = ss[0] + listContent + ss[2];
						}
					}

					// 生成暂时的html文件
					BufferedWriter out = new BufferedWriter(new FileWriter(htmlUrl));
					out.write(content);
					out.flush();
					out.close();

					// 由html转换成pdf文件
					PdfController jt = new PdfController();
					String html = jt.readFile(url, "UTF-8");
					jt.doConversion2(html, pdfUrl);

					// 下载pdf文件
					File newFile = new File(pdfUrl);
					InputStream in = null;
					OutputStream os = null;
					try {
						response.setContentType("application/pdf");
						response.setCharacterEncoding("utf-8");
						in = new FileInputStream(newFile);
						os = response.getOutputStream();
						byte[] b = new byte[1024];
						while (in.read(b) != -1) {
							os.write(b);
						}
						in.close();
						os.flush();
						os.close();
					} catch (Exception e) {
						try {
							if (null != in) {
								in.close();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							if (null != os) {
								os.close();
							}
						} catch (IOException e2) {
							e2.printStackTrace();
							result = "系统错误";
							return result;
						}

					}

				} catch (IOException e) {
					e.printStackTrace();
					result = "系统错误";
					return result;

				} finally {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				result = "成功下载";
				return result;
			} else {
				result = "模板文件不存在";
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "系统错误";
			return result;
		}
	}

	public void doConversion2(String htmlDocument, String outputPath) throws InvalidParameterException,
			MalformedURLException, IOException {

		PD4ML pd4ml = new PD4ML();

		pd4ml.setHtmlWidth(userSpaceWidth); // set frame width of
		// "virtual web browser"

		// choose target paper format
		// pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));//横向输出
		pd4ml.setPageSize(PD4Constants.A4);// 纵向输出

		// define PDF page margins
		pd4ml.setPageInsetsMM(new Insets(topValue, leftValue, bottomValue, rightValue));

		// source HTML document also may have margins, could be suppressed this
		// way
		// (PD4ML *Pro* feature):

		// If built-in basic PDF fonts are not sufficient or
		// if you need to output non-Latin texts, TTF embedding feature should
		// help
		// (PD4ML *Pro*)
		// pd4ml.useTTF("C:\\workspace\\HtmlToPDF", true);
		// pd4ml.useTTF("java:fonts", true);
		pd4ml.useTTF("D:/Test/fonts", true); // D:/Test/fonts文件夹可自定义,保持一致即可
		// pd4ml.setDefaultTTFs("MSJH", "Arial", "Courier New");
		// pd4ml.setDefaultTTFs("SimSun", "SimSun", "SimSun");
		pd4ml.setDefaultTTFs("Kai_GB2312", "Kai_GB2312", "Kai_GB2312");
		// 该字体对应fonts中的.ttf文件 (如:simsun.ttc)

		// pd4ml.addStyle("BODY {margin: 0; font-family:MSJH}", true);//加了这句会乱码

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

	private String readFile(String path, String encoding) throws IOException {

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

		return fos.toString();
	}
}
