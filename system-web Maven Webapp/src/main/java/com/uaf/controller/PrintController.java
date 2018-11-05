package com.uaf.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zefer.html.doc.p;

import com.alibaba.fastjson.JSONObject;
import com.uaf.bean.ContractInfo;
import com.uaf.bean.ContractModel;
import com.uaf.bean.ContractParam;
import com.uaf.bean.ContractType;
import com.uaf.bean.ContractVersion;
import com.uaf.bean.LoanCity;
import com.uaf.bean.LoanParam;
import com.uaf.bean.LoanProduct;
import com.uaf.bean.SystemInfo;
import com.uaf.nlp.common.json.utils.JsonUtil;
import com.uaf.service.ContractManageServiceService;
import com.uaf.util.BeanToMapUtils;
import com.uaf.util.CommonUtils;
import com.uaf.util.PageModel;
import com.uaf.util.ParameterMap;

/**
 * 文件名：PrintController.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年7月19日下午5:42:58
 */
@Controller()
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private ContractManageServiceService contractManageService;

	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/index");
	}

	@RequestMapping("/toM")
	public ModelAndView toM(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		ContractModel contractModel = contractManageService.getContractModelById(map);
		request.setAttribute("contractModel", contractModel);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("model_id", contractModel.getId());
		List<ContractParam> contractParams = contractManageService.getContractParamList(map2);
		List<String> paramsList = new ArrayList<String>();
		for (ContractParam c : contractParams) {
			paramsList.add(c.getParam().getDescription());
		}
		request.setAttribute("model_id", contractModel.getId());
		//request.setAttribute("params", JsonUtil.toJson(paramsList));
		request.setAttribute("params", paramsList);
		return new ModelAndView("/summer");
	}

	@RequestMapping("/getParamPage")
	@ResponseBody
	public PageModel<LoanParam> getParamsPage(HttpServletRequest request) {
		PageModel<LoanParam> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanParam> params = contractManageService.getLoanParamPage(map);
		pageModel.setRows(params);
		pageModel.setTotal(contractManageService.getLoanParamCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteParam")
	@ResponseBody
	public String deleteParam(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteParam(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping("/getParamList")
	@ResponseBody
	public List<LoanParam> getParamList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanParam> loanParams = contractManageService.getLoanParamList(map);
		return loanParams;
	}

	@RequestMapping(value = "/updateParam")
	@ResponseBody
	public String updateCityParam(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateParam(param);
			return "更新成功";
		} else {
			contractManageService.insertLoanParam(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getCityPage")
	@ResponseBody
	public PageModel<LoanCity> getCityPage(HttpServletRequest request) {
		PageModel<LoanCity> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanCity> loanCity = contractManageService.getLoanCityPage(map);
		pageModel.setRows(loanCity);
		pageModel.setTotal(contractManageService.getLoanCityCount(map));

		return pageModel;
	}

	@RequestMapping("/getCity")
	@ResponseBody
	public LoanCity getCity(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		LoanCity loanCity = contractManageService.getLoanCityById(map);

		return loanCity;
	}

	@RequestMapping("/getCityList")
	@ResponseBody
	public List<LoanCity> getCityList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanCity> loanCitys = contractManageService.getLoanCityList(map);

		return loanCitys;
	}

	@RequestMapping("/deleteCity")
	@ResponseBody
	public String deleteCity(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteCity(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateCity")
	@ResponseBody
	public String updateCity(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateCity(param);
			return "更新成功";
		} else {
			contractManageService.insertLoanCity(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getProductPage")
	@ResponseBody
	public PageModel<LoanProduct> getProductPage(HttpServletRequest request) {
		PageModel<LoanProduct> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanProduct> loanProducts = contractManageService.getLoanProductPage(map);
		pageModel.setRows(loanProducts);
		pageModel.setTotal(contractManageService.getLoanProductCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteProduct")
	@ResponseBody
	public String deleteProduct(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteProduct(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateProduct")
	@ResponseBody
	public String updateProduct(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateProduct(param);
			return "更新成功";
		} else {
			contractManageService.insertLoanProduct(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getProductList")
	@ResponseBody
	public List<LoanProduct> getProductList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<LoanProduct> products = contractManageService.getProductList(map);
		return products;
	}

	@RequestMapping("/getSystemPage")
	@ResponseBody
	public PageModel<SystemInfo> getSystemPage(HttpServletRequest request) {
		PageModel<SystemInfo> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<SystemInfo> systemInfos = contractManageService.getSystemInfoPage(map);
		pageModel.setRows(systemInfos);
		pageModel.setTotal(contractManageService.getSystemInfoCount(map));
		return pageModel;
	}

	@RequestMapping("/getSystemList")
	@ResponseBody
	public List<SystemInfo> getSystemList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<SystemInfo> systemInfos = contractManageService.getSystemInfoList(map);
		return systemInfos;
	}

	@RequestMapping("/deleteSystem")
	@ResponseBody
	public String deleteSystem(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteSystemInfo(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateSystem")
	@ResponseBody
	public String updateSystem(@RequestBody SystemInfo systemInfo) {
		if (CommonUtils.isNotBlank(systemInfo.getId())) {
			contractManageService.updateSystemInfo(systemInfo);
			return "更新成功";
		} else {
			contractManageService.insertSystemInfo(systemInfo);
			return "新增成功";
		}
	}

	@RequestMapping("/getContractTypePage")
	@ResponseBody
	public PageModel<ContractType> getContractTypePage(HttpServletRequest request) {
		PageModel<ContractType> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractType> contractTypes = contractManageService.getContractTypePage(map);
		pageModel.setRows(contractTypes);
		pageModel.setTotal(contractManageService.getContractTypeCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteContractType")
	@ResponseBody
	public String deleteContractType(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteContractType(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping("/getContractTypeList")
	@ResponseBody
	public List<ContractType> getContractTypeList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractType> contractTypes = contractManageService.getContractTypeList(map);
		return contractTypes;
	}

	@RequestMapping(value = "/updateContractType")
	@ResponseBody
	public String updateContractType(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateContractType(param);
			return "更新成功";
		} else {
			contractManageService.insertContractType(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getContractInfoPage")
	@ResponseBody
	public PageModel<ContractInfo> getContractInfoPage(HttpServletRequest request) {
		PageModel<ContractInfo> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractInfo> contractInfos = contractManageService.getContractInfoPage(map);
		pageModel.setRows(contractInfos);
		pageModel.setTotal(contractManageService.getContractInfoCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteContractInfo")
	@ResponseBody
	public String deleteContractInfo(HttpServletRequest request) {
		String contractId = request.getParameter("contractId");
		if (CommonUtils.isNotBlank(contractId)) {
			contractManageService.deleteContractInfo(contractId);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateContractInfo")
	@ResponseBody
	public String updateContractInfo(@RequestBody Map<String, Object> param) {
		if (param.get("contractId") != null) {
			contractManageService.updateContractInfo(param);
			return "更新成功";
		} else {
			contractManageService.insertContractInfo(param);
			return "新增成功";
		}
	}
	@RequestMapping(value = "/setModel")
	@ResponseBody
	public String setModel(HttpServletRequest request) {
		Map<String, Object> param = ParameterMap.getParameterMap(request);
		if (param.get("ids") != null) {
			Map<String, Object> map= new HashMap<>();
			String[] ids = String.valueOf(param.get("ids")).split(",");
			for(String id:ids){
				map.put("contractId",param.get("contractId"));
				map.put("modelId", id);
				contractManageService.updateContractInfo(map);
			}
			return "更新成功";
		} else {
			return "未选中数据";
		}
	}

	@RequestMapping("/getContractInfoList")
	@ResponseBody
	public List<ContractInfo> getContractInfoList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractInfo> contractInfos = contractManageService.getContractInfoList(map);
		return contractInfos;
	}

	@RequestMapping("/getContractInfo")
	@ResponseBody
	public ContractInfo getContractInfo(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		ContractInfo contractInfo = contractManageService.getContractInfoById(map);
		return contractInfo;
	}

	@RequestMapping("/getContractParamPage")
	@ResponseBody
	public PageModel<ContractParam> getContractParamPage(HttpServletRequest request) {
		PageModel<ContractParam> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractParam> contractParams = contractManageService.getContractParamPage(map);
		pageModel.setRows(contractParams);
		pageModel.setTotal(contractManageService.getContractParamCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteContractParam")
	@ResponseBody
	public String deleteContractParam(HttpServletRequest request) {
		String contractId = request.getParameter("id");
		if (CommonUtils.isNotBlank(contractId)) {
			contractManageService.deleteContractParam(contractId);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateContractParam", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String updateContractParam(@RequestBody Map<String, Object> param) {
		if (param.get("id")!=null) {
			contractManageService.updateContractParam(param);
			return "更新成功";
		} else {
			contractManageService.insertContractParam(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getContractVersionPage")
	@ResponseBody
	public PageModel<ContractVersion> getContractVersionPage(HttpServletRequest request) {
		PageModel<ContractVersion> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractVersion> contractVersions = contractManageService.getContractVersionPage(map);
		pageModel.setRows(contractVersions);
		pageModel.setTotal(contractManageService.getContractVersionCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteContractVersion")
	@ResponseBody
	public String deleteContractVersion(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteContractVersion(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateContractVersion", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String updateContractVersion(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateContractVersion(param);
			return "更新成功";
		} else {
			contractManageService.insertContractVersion(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getContractModelPage")
	@ResponseBody
	public PageModel<ContractModel> getContractModelPage(HttpServletRequest request) {
		PageModel<ContractModel> pageModel = new PageModel<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractModel> ContractModels = contractManageService.getContractModelPage(map);
		pageModel.setRows(ContractModels);
		pageModel.setTotal(contractManageService.getContractModelCount(map));
		return pageModel;
	}

	@RequestMapping("/deleteContractModel")
	@ResponseBody
	public String deleteContractModel(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (CommonUtils.isNotBlank(id)) {
			contractManageService.deleteContractModel(id);
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/updateContractModel", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String updateContractModel(@RequestBody Map<String, Object> param) {
		if (param.get("id") != null) {
			contractManageService.updateContractModel(param);
			return "更新成功";
		} else {
			contractManageService.insertContractModel(param);
			return "新增成功";
		}
	}

	@RequestMapping("/getContractModelList")
	@ResponseBody
	public List<ContractModel> getContractModelList(HttpServletRequest request) {
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		List<ContractModel> contractModel = contractManageService.getContractModelList(map);
		return contractModel;
	}

	@RequestMapping("/readContract")
	@ResponseBody
	public Map<String, String> readTemplate(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		ContractModel contractModel = contractManageService.getContractModelById(map);
		String pathname = contractModel.getUrl();
		if (CommonUtils.isBlank(pathname)) {
			result.put("code", "1111");
			result.put("message", "无合同文件,您可编辑保存");
			return result;
		}
		StringBuffer data = null;
		BufferedReader br = null;
		File file = new File(pathname); // 要读取以上路径的input.txt文件
		if (file.isFile() && file.exists()) {
			try {
				// InuputStream in =
				// PrintController.class.getResourse("input.txt");
				// 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径

				InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
				data = new StringBuffer();
				br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
				String line = null;
				while ((line = br.readLine()) != null) {
					data = data.append(line); // 一次读入一行数据
				}
				result.put("code", "0000");
				result.put("contract", data.toString());

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			result.put("code", "1111");
			result.put("message", "文件不存在");
		}
		// HttpResponseMessage responseMessage = new HttpResponseMessage {
		// Content = new StringContent("你要返回的字符串",
		// Encoding.GetEncoding("UTF-8"), "text/plain") };
		return result;
	}

	@RequestMapping("/writeContract")
	@ResponseBody
	public Map<String, String> writeTemplate(HttpServletRequest request) throws IOException {
		Map<String, String> result = new HashMap<>();
		Map<String, Object> map = ParameterMap.getParameterMap(request);
		ContractModel contractModel = contractManageService.getContractModelById(map);
		String pathname = contractModel.getUrl();
		File writename = null;
		try {
			// 如果文件名为空，则新建一个文件
			if (CommonUtils.isBlank(pathname)) {
				String url = "D:/input/" + contractModel.getId() + contractModel.getVersion() + ".html";
				writename = new File(url);
				writename.createNewFile(); // 创建新文件
				contractModel.setUrl(url);
				Map<String, Object> param = new HashMap<>();
				param.put("id", contractModel.getId());
				param.put("url", contractModel.getUrl());
				contractManageService.updateContractModel(param);
			} else {
				writename = new File(contractModel.getUrl());
			}
			String data = String.valueOf(map.get("contractHtml"));
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(String.valueOf(map.get("contractHtml"))); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件

		} catch (IOException e) {
			result.put("code", "1111");
			result.put("message", "保存失败");
			e.printStackTrace();
		}
		result.put("code", "0000");
		result.put("message", "保存成功");
		return result;
	}

	@RequestMapping("/getTree")
	@ResponseBody
	public String getTree() {
		StringBuffer data = null;
		BufferedReader br = null;
		try {
			// InuputStream in = PrintController.class.getResourse("input.txt");
			String pathname = "treedata.json"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			File file = new File(pathname); // 要读取以上路径的input.txt文件
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
				data = new StringBuffer();
				br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
				String line = null;
				while ((line = br.readLine()) != null) {
					data = data.append(line); // 一次读入一行数据
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new String(data);
	}

}
