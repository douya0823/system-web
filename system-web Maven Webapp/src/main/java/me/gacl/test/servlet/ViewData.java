package me.gacl.test.servlet;


import javax.servlet.http.HttpServletRequest;


/**
 * ��Ҫ���͵��ͻ�����ʾ������ģ��
 */
public class ViewData {
    
    private HttpServletRequest request;
    
    public ViewData() {
        initRequest();
    }

    private void initRequest(){
        //��requestHodler�л�ȡrequest����
        this.request = WebContext.requestHodler.get();
    }
    
    public void put(String name,Object value){
        this.request.setAttribute(name, value);
    }
}