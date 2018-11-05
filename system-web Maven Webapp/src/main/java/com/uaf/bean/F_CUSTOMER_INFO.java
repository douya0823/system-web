package com.uaf.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 版权所有: 信雅达系统工程股份有限公司
 * 工程名: UAFWEB
 * 包名: com.sunyard.bean.appform
 * 文件名: F_CUSTOMER_INFO.java
 * 文件描述: 
 * 创建人: 许鹏程 
 * 创建时间: 2013-4-10 下午06:11:08
 * 修改人: XPC
 * 修改时间:
 * Email: pengch.xu@sunyard.com
 */
@SuppressWarnings("serial")
public class F_CUSTOMER_INFO implements Serializable{

     //无参构造方法
    public F_CUSTOMER_INFO() {
    }
    
    public void setCREDITCARD_MONTH_CONT(String cREDITCARD_MONTH_CONT) {
        this.cREDITCARD_MONTH_CONT = cREDITCARD_MONTH_CONT;
    }

    public String getCREDITCARD_MONTH_CONT() {
        return cREDITCARD_MONTH_CONT;
    }
    public void setCREDITCARD_LOAN_BALANCE(String cREDITCARD_LOAN_BALANCE) {
        this.cREDITCARD_LOAN_BALANCE = cREDITCARD_LOAN_BALANCE;
    }

    public String getCREDITCARD_LOAN_BALANCE() {
        return cREDITCARD_LOAN_BALANCE;
    }
    public void setTOTAL_LOAN_AMOUNT(String tOTAL_LOAN_AMOUNT) {
        this.tOTAL_LOAN_AMOUNT = tOTAL_LOAN_AMOUNT;
    }

    public String getTOTAL_LOAN_AMOUNT() {
        return tOTAL_LOAN_AMOUNT;
    }
    public void setTOTAL_MONTH_CONT_AMOUNT(String tOTAL_MONTH_CONT_AMOUNT) {
        this.tOTAL_MONTH_CONT_AMOUNT = tOTAL_MONTH_CONT_AMOUNT;
    }

    public String getTOTAL_MONTH_CONT_AMOUNT() {
        return tOTAL_MONTH_CONT_AMOUNT;
    }
    public void setTOTAL_BALANCE(String tOTAL_BALANCE) {
        this.tOTAL_BALANCE = tOTAL_BALANCE;
    }

    public String getTOTAL_BALANCE() {
        return tOTAL_BALANCE;
    }
    public void setSPOUSE_NAME(String sPOUSE_NAME) {
        this.sPOUSE_NAME = sPOUSE_NAME;
    }

    public String getSPOUSE_NAME() {
        return sPOUSE_NAME;
    }
    public void setSPOUSE_IS_KOWN_LOAN(String sPOUSE_IS_KOWN_LOAN) {
        this.sPOUSE_IS_KOWN_LOAN = sPOUSE_IS_KOWN_LOAN;
    }

    public String getSPOUSE_IS_KOWN_LOAN() {
        return sPOUSE_IS_KOWN_LOAN;
    }
    public void setSPOUSE_MOBILE(String sPOUSE_MOBILE) {
        this.sPOUSE_MOBILE = sPOUSE_MOBILE;
    }

    public String getSPOUSE_MOBILE() {
        return sPOUSE_MOBILE;
    }
    public void setSPOUSE_COMPANY_NAME(String sPOUSE_COMPANY_NAME) {
        this.sPOUSE_COMPANY_NAME = sPOUSE_COMPANY_NAME;
    }

    public String getSPOUSE_COMPANY_NAME() {
        return sPOUSE_COMPANY_NAME;
    }
    public void setSPOUSE_POSITION(String sPOUSE_POSITION) {
        this.sPOUSE_POSITION = sPOUSE_POSITION;
    }

    public String getSPOUSE_POSITION() {
        return sPOUSE_POSITION;
    }
    public void setSPOUSE_COMPANY_ADDRESS(String sPOUSE_COMPANY_ADDRESS) {
        this.sPOUSE_COMPANY_ADDRESS = sPOUSE_COMPANY_ADDRESS;
    }

    public String getSPOUSE_COMPANY_ADDRESS() {
        return sPOUSE_COMPANY_ADDRESS;
    }
    public void setSPOUSE_AGE(String sPOUSE_AGE) {
        this.sPOUSE_AGE = sPOUSE_AGE;
    }

    public String getSPOUSE_AGE() {
        return sPOUSE_AGE;
    }
    public void setSPOUSE_TEL_AREA(String sPOUSE_TEL_AREA) {
        this.sPOUSE_TEL_AREA = sPOUSE_TEL_AREA;
    }

    public String getSPOUSE_TEL_AREA() {
        return sPOUSE_TEL_AREA;
    }
    public void setSPOUSE_TEL_NUMBER(String sPOUSE_TEL_NUMBER) {
        this.sPOUSE_TEL_NUMBER = sPOUSE_TEL_NUMBER;
    }

    public String getSPOUSE_TEL_NUMBER() {
        return sPOUSE_TEL_NUMBER;
    }
    public void setSPOUSE_TEL_EXT(String sPOUSE_TEL_EXT) {
        this.sPOUSE_TEL_EXT = sPOUSE_TEL_EXT;
    }

    public String getSPOUSE_TEL_EXT() {
        return sPOUSE_TEL_EXT;
    }
    public void setSPOUSE_MONTHLY_INCOME(String sPOUSE_MONTHLY_INCOME) {
        this.sPOUSE_MONTHLY_INCOME = sPOUSE_MONTHLY_INCOME;
    }

    public String getSPOUSE_MONTHLY_INCOME() {
        return sPOUSE_MONTHLY_INCOME;
    }
    public void setIS_MAIN_LOANER(String iS_MAIN_LOANER) {
        this.iS_MAIN_LOANER = iS_MAIN_LOANER;
    }

    public String getIS_MAIN_LOANER() {
        return iS_MAIN_LOANER;
    }
    public void setIS_LOANER(String iS_LOANER) {
        this.iS_LOANER = iS_LOANER;
    }

    public String getIS_LOANER() {
        return iS_LOANER;
    }
    public void setIS_GUARANTOR(String iS_GUARANTOR) {
        this.iS_GUARANTOR = iS_GUARANTOR;
    }

    public String getIS_GUARANTOR() {
        return iS_GUARANTOR;
    }
    public void setIS_OWNER(String iS_OWNER) {
        this.iS_OWNER = iS_OWNER;
    }

    public String getIS_OWNER() {
        return iS_OWNER;
    }
    
    public String getIS_CAROWNER() {
		return iS_CAROWNER;
	}

	public void setIS_CAROWNER(String iS_CAROWNER) {
		this.iS_CAROWNER = iS_CAROWNER;
	}
	
    public void setEMAIL_ADDRESS(String eMAIL_ADDRESS) {
        this.eMAIL_ADDRESS = eMAIL_ADDRESS;
    }

    public String getEMAIL_ADDRESS() {
        return eMAIL_ADDRESS;
    }
    public void setCURCITY(String cURCITY) {
        this.cURCITY = cURCITY;
    }

    public String getCURCITY() {
        return cURCITY;
    }
    public void setOPER_ID(String oPER_ID) {
        this.oPER_ID = oPER_ID;
    }

    public String getOPER_ID() {
        return oPER_ID;
    }
    public void setOPER_TIME(Date oPER_TIME) {
        this.oPER_TIME = oPER_TIME;
    }

    public Date getOPER_TIME() {
        return oPER_TIME;
    }
    public void setAAS_NBR(String aAS_NBR) {
        this.aAS_NBR = aAS_NBR;
    }

    public String getAAS_NBR() {
        return aAS_NBR;
    }
    public void setBAR_CODE(String bAR_CODE) {
        this.bAR_CODE = bAR_CODE;
    }

    public String getBAR_CODE() {
        return bAR_CODE;
    }
    public void setCERT_TYPE(String cERT_TYPE) {
        this.cERT_TYPE = cERT_TYPE;
    }

    public String getCERT_TYPE() {
        return cERT_TYPE;
    }
    public void setCERT_NO(String cERT_NO) {
        this.cERT_NO = cERT_NO;
    }

    public String getCERT_NO() {
        return cERT_NO;
    }
    public void setSURNAME(String sURNAME) {
        this.sURNAME = sURNAME;
    }

    public String getSURNAME() {
        return sURNAME;
    }
    public void setGIVENNAME(String gIVENNAME) {
        this.gIVENNAME = gIVENNAME;
    }

    public String getGIVENNAME() {
        return gIVENNAME;
    }
    public void setUSED_NAME(String uSED_NAME) {
        this.uSED_NAME = uSED_NAME;
    }

    public String getUSED_NAME() {
        return uSED_NAME;
    }
    public void setBIRTHDAY(Date bIRTHDAY) {
        this.bIRTHDAY = bIRTHDAY;
    }

    public Date getBIRTHDAY() {
        return bIRTHDAY;
    }
    public void setAGE(String aGE) {
        this.aGE = aGE;
    }

    public String getAGE() {
        return aGE;
    }
    public void setRPR_PROVINCE(String rPR_PROVINCE) {
        this.rPR_PROVINCE = rPR_PROVINCE;
    }

    public String getRPR_PROVINCE() {
        return rPR_PROVINCE;
    }
    public void setRPR_CITY(String rPR_CITY) {
        this.rPR_CITY = rPR_CITY;
    }

    public String getRPR_CITY() {
        return rPR_CITY;
    }
    public void setNATIVE_PLACE(String nATIVE_PLACE) {
        this.nATIVE_PLACE = nATIVE_PLACE;
    }

    public String getNATIVE_PLACE() {
        return nATIVE_PLACE;
    }
    public void setSEX(String sEX) {
        this.sEX = sEX;
    }

    public String getSEX() {
        return sEX;
    }
    public void setMARITAL_STATUS(String mARITAL_STATUS) {
        this.mARITAL_STATUS = mARITAL_STATUS;
    }

    public String getMARITAL_STATUS() {
        return mARITAL_STATUS;
    }
    public void setEDUCATION_LEVEL(String eDUCATION_LEVEL) {
        this.eDUCATION_LEVEL = eDUCATION_LEVEL;
    }

    public String getEDUCATION_LEVEL() {
        return eDUCATION_LEVEL;
    }
    public void setSOCIAL_SECURITY_COMPUTER(String sOCIAL_SECURITY_COMPUTER) {
        this.sOCIAL_SECURITY_COMPUTER = sOCIAL_SECURITY_COMPUTER;
    }

    public String getSOCIAL_SECURITY_COMPUTER() {
        return sOCIAL_SECURITY_COMPUTER;
    }
    public void setLABOR_ENSURE_CARD(String lABOR_ENSURE_CARD) {
        this.lABOR_ENSURE_CARD = lABOR_ENSURE_CARD;
    }

    public String getLABOR_ENSURE_CARD() {
        return lABOR_ENSURE_CARD;
    }
    public void setIS_OWN_SOCIAL_SECURITY(String iS_OWN_SOCIAL_SECURITY) {
        this.iS_OWN_SOCIAL_SECURITY = iS_OWN_SOCIAL_SECURITY;
    }

    public String getIS_OWN_SOCIAL_SECURITY() {
        return iS_OWN_SOCIAL_SECURITY;
    }
    public void setRESIDENCE_PERMIT_NO(String rESIDENCE_PERMIT_NO) {
        this.rESIDENCE_PERMIT_NO = rESIDENCE_PERMIT_NO;
    }

    public String getRESIDENCE_PERMIT_NO() {
        return rESIDENCE_PERMIT_NO;
    }
    public void setMOBILE(String mOBILE) {
        this.mOBILE = mOBILE;
    }

    public String getMOBILE() {
        return mOBILE;
    }
    public void setUNITNAME(String uNITNAME) {
        this.uNITNAME = uNITNAME;
    }

    public String getUNITNAME() {
        return uNITNAME;
    }
    public void setOTHER_TEL_AREA(String oTHER_TEL_AREA) {
        this.oTHER_TEL_AREA = oTHER_TEL_AREA;
    }

    public String getOTHER_TEL_AREA() {
        return oTHER_TEL_AREA;
    }
    public void setOTHER_TEL_NUMBER(String oTHER_TEL_NUMBER) {
        this.oTHER_TEL_NUMBER = oTHER_TEL_NUMBER;
    }

    public String getOTHER_TEL_NUMBER() {
        return oTHER_TEL_NUMBER;
    }
    public void setID_CARD_VALIDITY_FROM(Date iD_CARD_VALIDITY_FROM) {
        this.iD_CARD_VALIDITY_FROM = iD_CARD_VALIDITY_FROM;
    }

    public Date getID_CARD_VALIDITY_FROM() {
        return iD_CARD_VALIDITY_FROM;
    }
    public void setID_CARD_VALIDITY_TO(Date iD_CARD_VALIDITY_TO) {
        this.iD_CARD_VALIDITY_TO = iD_CARD_VALIDITY_TO;
    }

    public Date getID_CARD_VALIDITY_TO() {
        return iD_CARD_VALIDITY_TO;
    }
    public void setID_CARD_VALIDITY_PERIOD(String iD_CARD_VALIDITY_PERIOD) {
        this.iD_CARD_VALIDITY_PERIOD = iD_CARD_VALIDITY_PERIOD;
    }

    public String getID_CARD_VALIDITY_PERIOD() {
        return iD_CARD_VALIDITY_PERIOD;
    }
    
    public void setID_CARD_ADDRESS_PROVINCE(String iD_CARD_ADDRESS_PROVINCE) {
        this.iD_CARD_ADDRESS_PROVINCE = iD_CARD_ADDRESS_PROVINCE;
    }

    public String getID_CARD_ADDRESS_PROVINCE() {
        return iD_CARD_ADDRESS_PROVINCE;
    }
    public void setID_CARD_ADDRESS_CITY(String iD_CARD_ADDRESS_CITY) {
        this.iD_CARD_ADDRESS_CITY = iD_CARD_ADDRESS_CITY;
    }

    public String getID_CARD_ADDRESS_CITY() {
        return iD_CARD_ADDRESS_CITY;
    }
    public void setID_CARD_ADDRESS_AREA(String iD_CARD_ADDRESS_AREA) {
        this.iD_CARD_ADDRESS_AREA = iD_CARD_ADDRESS_AREA;
    }

    public String getID_CARD_ADDRESS_AREA() {
        return iD_CARD_ADDRESS_AREA;
    }
    public void setID_CARD_ADDRESS_DETAIL(String iD_CARD_ADDRESS_DETAIL) {
        this.iD_CARD_ADDRESS_DETAIL = iD_CARD_ADDRESS_DETAIL;
    }

    public String getID_CARD_ADDRESS_DETAIL() {
        return iD_CARD_ADDRESS_DETAIL;
    }
    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getEMAIL() {
        return eMAIL;
    }
    public void setIS_OWN_SELF_HOUSE(String iS_OWN_SELF_HOUSE) {
        this.iS_OWN_SELF_HOUSE = iS_OWN_SELF_HOUSE;
    }

    public String getIS_OWN_SELF_HOUSE() {
        return iS_OWN_SELF_HOUSE;
    }
    public void setSELF_HOUSE_LOAN_AMOUNT(String sELF_HOUSE_LOAN_AMOUNT) {
        this.sELF_HOUSE_LOAN_AMOUNT = sELF_HOUSE_LOAN_AMOUNT;
    }

    public String getSELF_HOUSE_LOAN_AMOUNT() {
        return sELF_HOUSE_LOAN_AMOUNT;
    }
    public void setSELF_HOUSE_MONTH_CONT(String sELF_HOUSE_MONTH_CONT) {
        this.sELF_HOUSE_MONTH_CONT = sELF_HOUSE_MONTH_CONT;
    }

    public String getSELF_HOUSE_MONTH_CONT() {
        return sELF_HOUSE_MONTH_CONT;
    }
    public void setSELF_HOUSE_LOAN_BALANCE(String sELF_HOUSE_LOAN_BALANCE) {
        this.sELF_HOUSE_LOAN_BALANCE = sELF_HOUSE_LOAN_BALANCE;
    }

    public String getSELF_HOUSE_LOAN_BALANCE() {
        return sELF_HOUSE_LOAN_BALANCE;
    }
    public void setIS_OWN_SELF_CAR(String iS_OWN_SELF_CAR) {
        this.iS_OWN_SELF_CAR = iS_OWN_SELF_CAR;
    }

    public String getIS_OWN_SELF_CAR() {
        return iS_OWN_SELF_CAR;
    }
    public void setSELF_CAR_LOAN_AMOUNT(String sELF_CAR_LOAN_AMOUNT) {
        this.sELF_CAR_LOAN_AMOUNT = sELF_CAR_LOAN_AMOUNT;
    }

    public String getSELF_CAR_LOAN_AMOUNT() {
        return sELF_CAR_LOAN_AMOUNT;
    }
    public void setSELF_CAR_MONTH_CONT(String sELF_CAR_MONTH_CONT) {
        this.sELF_CAR_MONTH_CONT = sELF_CAR_MONTH_CONT;
    }

    public String getSELF_CAR_MONTH_CONT() {
        return sELF_CAR_MONTH_CONT;
    }
    public void setSELF_CAR_LOAN_BALANCE(String sELF_CAR_LOAN_BALANCE) {
        this.sELF_CAR_LOAN_BALANCE = sELF_CAR_LOAN_BALANCE;
    }

    public String getSELF_CAR_LOAN_BALANCE() {
        return sELF_CAR_LOAN_BALANCE;
    }
    public void setIS_OWN_OTHER(String iS_OWN_OTHER) {
        this.iS_OWN_OTHER = iS_OWN_OTHER;
    }

    public String getIS_OWN_OTHER() {
        return iS_OWN_OTHER;
    }
    public void setOTHER_LOAN_AMOUNT(String oTHER_LOAN_AMOUNT) {
        this.oTHER_LOAN_AMOUNT = oTHER_LOAN_AMOUNT;
    }

    public String getOTHER_LOAN_AMOUNT() {
        return oTHER_LOAN_AMOUNT;
    }
    public void setOTHER_MONTH_CONT(String oTHER_MONTH_CONT) {
        this.oTHER_MONTH_CONT = oTHER_MONTH_CONT;
    }

    public String getOTHER_MONTH_CONT() {
        return oTHER_MONTH_CONT;
    }
    public void setOTHER_LOAN_BALANCE(String oTHER_LOAN_BALANCE) {
        this.oTHER_LOAN_BALANCE = oTHER_LOAN_BALANCE;
    }

    public String getOTHER_LOAN_BALANCE() {
        return oTHER_LOAN_BALANCE;
    }
    public void setIS_OWN_UNSECURED(String iS_OWN_UNSECURED) {
        this.iS_OWN_UNSECURED = iS_OWN_UNSECURED;
    }

    public String getIS_OWN_UNSECURED() {
        return iS_OWN_UNSECURED;
    }
    public void setUNSECURED_LOAN_AMOUNT(String uNSECURED_LOAN_AMOUNT) {
        this.uNSECURED_LOAN_AMOUNT = uNSECURED_LOAN_AMOUNT;
    }

    public String getUNSECURED_LOAN_AMOUNT() {
        return uNSECURED_LOAN_AMOUNT;
    }
    public void setUNSECURED_MONTH_CONT(String uNSECURED_MONTH_CONT) {
        this.uNSECURED_MONTH_CONT = uNSECURED_MONTH_CONT;
    }

    public String getUNSECURED_MONTH_CONT() {
        return uNSECURED_MONTH_CONT;
    }
    public void setUNSECURED_LOAN_BALANCE(String uNSECURED_LOAN_BALANCE) {
        this.uNSECURED_LOAN_BALANCE = uNSECURED_LOAN_BALANCE;
    }

    public String getUNSECURED_LOAN_BALANCE() {
        return uNSECURED_LOAN_BALANCE;
    }
    public void setIS_OWN_CREDITCARD(String iS_OWN_CREDITCARD) {
        this.iS_OWN_CREDITCARD = iS_OWN_CREDITCARD;
    }

    public String getIS_OWN_CREDITCARD() {
        return iS_OWN_CREDITCARD;
    }
    public void setCREDITCARD_LOAN_AMOUNT(String cREDITCARD_LOAN_AMOUNT) {
        this.cREDITCARD_LOAN_AMOUNT = cREDITCARD_LOAN_AMOUNT;
    }

    public String getCREDITCARD_LOAN_AMOUNT() {
        return cREDITCARD_LOAN_AMOUNT;
    }
    
    /**信用资料-信用卡-总每月供款*/
    private String cREDITCARD_MONTH_CONT;
    
    /**信用资料-信用卡-总贷款金额*/
    private String cREDITCARD_LOAN_BALANCE;
    
    /**总贷款额度总额*/
    private String tOTAL_LOAN_AMOUNT;
    
    /**总每月供款总额*/
    private String tOTAL_MONTH_CONT_AMOUNT;
    
    /**总贷款金额总额*/
    private String tOTAL_BALANCE;
    
    /**配偶资料-姓名*/
    private String sPOUSE_NAME;
    
    /**配偶资料-是否知悉贷款*/
    private String sPOUSE_IS_KOWN_LOAN;
    
    /**配偶资料-手机号码*/
    private String sPOUSE_MOBILE;
    
    /**配偶资料-公司名称*/
    private String sPOUSE_COMPANY_NAME;
    
    /**配偶资料-职位*/
    private String sPOUSE_POSITION;
    
    /**配偶资料-公司地址*/
    private String sPOUSE_COMPANY_ADDRESS;
    
    /**配偶资料-年龄*/
    private String sPOUSE_AGE;
    
    /**配偶资料-电话-区号*/
    private String sPOUSE_TEL_AREA;
    
    /**配偶资料-电话-号码*/
    private String sPOUSE_TEL_NUMBER;
    
    /**配偶资料-电话-分机*/
    private String sPOUSE_TEL_EXT;
    
    /**配偶资料-每月收入*/
    private String sPOUSE_MONTHLY_INCOME;
    
    /**配偶资料-证件号*/
    private String SPOUSE_CERT_NO;
    /**配偶资料-省*/
    private String SPOUSE_ADDRESS_PROVINCE;
    /**配偶资料-市*/
    private String SPOUSE_ADDRESS_CITY;
    /**配偶资料-区*/
    private String SPOUSE_ADDRESS_AREA;
    /**配偶资料-详细地址*/
    private String SPOUSE_ADDRESS_DETAIL;
    
    
    /**是否主贷人*/
    private String iS_MAIN_LOANER;
    
    /**是否贷款人*/
    private String iS_LOANER;
    
    /**是否担保人*/
    private String iS_GUARANTOR;
    
    /**是否业主*/
    private String iS_OWNER;
    
    /**是否车主*/
    private String iS_CAROWNER;
    
    /**邮寄地址*/
    private String eMAIL_ADDRESS;
    
    /**贷款城市*/
    private String cURCITY;
    
    /**操作员*/
    private String oPER_ID;
    
    private String lOANER_NAME;
    
    /**操作时间*/
    private Date oPER_TIME;
    
    /**信审号*/
    private String aAS_NBR;
    
    /**流程编号*/
    private String bAR_CODE;
    
    /**个人资料-证件类型*/
    private String cERT_TYPE;
    
    /**个人资料-证件号*/
    private String cERT_NO;
    
    /**个人资料-姓*/
    private String sURNAME;
    
    /**个人资料-名*/
    private String gIVENNAME;
    
    /**个人资料-曾用名*/
    private String uSED_NAME;
    
    /**个人资料-出生日期*/
    private Date bIRTHDAY;
    
    /**个人资料-年龄*/
    private String aGE;
    
    /**个人资料-户口所在地-省*/
    private String rPR_PROVINCE;
    
    /**个人资料-户口所在地-市*/
    private String rPR_CITY;
    
    /**个人资料-籍贯*/
    private String nATIVE_PLACE;
    
    /**个人资料-性别*/
    private String sEX;
    
    /**个人资料-婚姻状况*/
    private String mARITAL_STATUS;
    
    /**个人资料-教育程度*/
    private String eDUCATION_LEVEL;
    
    /**个人资料-社会保险卡电脑号*/
    private String sOCIAL_SECURITY_COMPUTER;
    
    /**个人资料-劳动保障卡号*/
    private String lABOR_ENSURE_CARD;
    
    /**个人资料-当前社保供款记录*/
    private String iS_OWN_SOCIAL_SECURITY;
    
    /**个人资料-所在地居住证*/
    private String rESIDENCE_PERMIT_NO;
    
    /**个人资料-手机号码*/
    private String mOBILE;
    
    /**个人资料-单位名称*/
    private String uNITNAME;
    
    /**个人资料-其他电话-区号*/
    private String oTHER_TEL_AREA;
    
    /**个人资料-其他电话-号码*/
    private String oTHER_TEL_NUMBER;
    
    /**个人资料-身份证有效期限起*/
    private Date iD_CARD_VALIDITY_FROM;
    
    /**个人资料-身份证有效期限止*/
    private Date iD_CARD_VALIDITY_TO;
    
    /**个人资料-身份证有效期*/
    private String iD_CARD_VALIDITY_PERIOD;
    
    /**个人资料-中国身份证上的地址-省*/
    private String iD_CARD_ADDRESS_PROVINCE;
    
    /**个人资料-中国身份证上的地址-市*/
    private String iD_CARD_ADDRESS_CITY;
    
    /**个人资料-中国身份证上的地址-区*/
    private String iD_CARD_ADDRESS_AREA;
    
    /**个人资料-中国身份证上的地址-详细地址*/
    private String iD_CARD_ADDRESS_DETAIL;
    
    /**个人资料-电邮地址*/
    private String eMAIL;
    
    /**微信号*/
    private String  WECHAT_NUMBER;
   
    
    public String getWECHAT_NUMBER() {
		return WECHAT_NUMBER;
	}

	public void setWECHAT_NUMBER(String WECHAT_NUMBER) {
		this.WECHAT_NUMBER = WECHAT_NUMBER;
	}

	/**信用资料-有抵押贷款-自有房产*/
    private String iS_OWN_SELF_HOUSE;
    
    /**信用资料-有抵押贷款-自有房产-总贷款额度*/
    private String sELF_HOUSE_LOAN_AMOUNT;
    
    /**信用资料-有抵押贷款-自有房产-总每月供款*/
    private String sELF_HOUSE_MONTH_CONT;
    
    /**信用资料-有抵押贷款-自有房产-总贷款金额*/
    private String sELF_HOUSE_LOAN_BALANCE;
    
    /**信用资料-有抵押贷款-自有汽车*/
    private String iS_OWN_SELF_CAR;
    
    /**信用资料-有抵押贷款-自有汽车-总贷款额度*/
    private String sELF_CAR_LOAN_AMOUNT;
    
    /**信用资料-有抵押贷款-自有汽车-总每月供款*/
    private String sELF_CAR_MONTH_CONT;
    
    /**信用资料-有抵押贷款-自有汽车-总贷款金额*/
    private String sELF_CAR_LOAN_BALANCE;
    
    /**信用资料-有抵押贷款-其它*/
    private String iS_OWN_OTHER;
    
    /**信用资料-有抵押贷款-其它-总贷款额度*/
    private String oTHER_LOAN_AMOUNT;
    
    /**信用资料-有抵押贷款-其它-总每月供款*/
    private String oTHER_MONTH_CONT;
    
    /**信用资料-有抵押贷款-其它-总贷款金额*/
    private String oTHER_LOAN_BALANCE;
    
    /**信用资料-无抵押贷款*/
    private String iS_OWN_UNSECURED;
    
    /**信用资料-无抵押贷款-总贷款额度*/
    private String uNSECURED_LOAN_AMOUNT;
    
    /**信用资料-无抵押贷款-总每月供款*/
    private String uNSECURED_MONTH_CONT;
    
    /**信用资料-无抵押贷款-总贷款金额*/
    private String uNSECURED_LOAN_BALANCE;
    
    /**信用资料-信用卡*/
    private String iS_OWN_CREDITCARD;
    
    /**信用资料-信用卡-总贷款额度*/
    private String cREDITCARD_LOAN_AMOUNT;
    
    /**客户ID*/
    private String cUSTOMER_ID;

	public String getLOANER_NAME() {
		return lOANER_NAME;
	}

	public void setLOANER_NAME(String loaner_name) {
		lOANER_NAME = loaner_name;
	}

	public String getCUSTOMER_ID() {
		return cUSTOMER_ID;
	}

	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		this.cUSTOMER_ID = cUSTOMER_ID;
	}

	public String getSPOUSE_CERT_NO() {
		return SPOUSE_CERT_NO;
	}

	public void setSPOUSE_CERT_NO(String sPOUSECERTNO) {
		SPOUSE_CERT_NO = sPOUSECERTNO;
	}

	public String getSPOUSE_ADDRESS_CITY() {
		return SPOUSE_ADDRESS_CITY;
	}

	public void setSPOUSE_ADDRESS_CITY(String sPOUSEADDRESSCITY) {
		SPOUSE_ADDRESS_CITY = sPOUSEADDRESSCITY;
	}

	public String getSPOUSE_ADDRESS_AREA() {
		return SPOUSE_ADDRESS_AREA;
	}

	public void setSPOUSE_ADDRESS_AREA(String sPOUSEADDRESSAREA) {
		SPOUSE_ADDRESS_AREA = sPOUSEADDRESSAREA;
	}

	public String getSPOUSE_ADDRESS_DETAIL() {
		return SPOUSE_ADDRESS_DETAIL;
	}

	public void setSPOUSE_ADDRESS_DETAIL(String sPOUSEADDRESSDETAIL) {
		SPOUSE_ADDRESS_DETAIL = sPOUSEADDRESSDETAIL;
	}

	public String getSPOUSE_ADDRESS_PROVINCE() {
		return SPOUSE_ADDRESS_PROVINCE;
	}

	public void setSPOUSE_ADDRESS_PROVINCE(String sPOUSEADDRESSPROVINCE) {
		SPOUSE_ADDRESS_PROVINCE = sPOUSEADDRESSPROVINCE;
	}

}
