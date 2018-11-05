package web.annotation;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * ������
 * @author hanlw
 * 2012 -07 - 04
 */
public class Controller {

public static void main(String[] args) throws Exception{
/**
* InputStream��OutputStream��ʹ������
* 
* (�����ļ�������)BufferedInputStream �� (�ļ�������)FileInputStream �� (������)java.io.InputStream
* 
* (�����ļ������)BufferedOuputStream �� (�ļ������)FileOuputStream �� (�����)java.io.OutputStream
*/
/**
* 1.ͨ��������һ��ͼƬ������
*/
/* File file = new File("c:/images/1.png");
File outfile = new File("C:/temp.png");
FileInputStream inputStream = new FileInputStream(file);
FileOutputStream outputStream = new FileOutputStream(outfile);
int i = 0;
while(i != -1) {
i = inputStream.read();
outputStream.write(i);
}
//ע�����Ĺر�(������)
inputStream.close();
outputStream.close();
*/
/**
* 2.������������Ҫ��߸��Ƶ��ٶ�,���Բ��û����ļ�����/�����,����:
*/
/* File file = new File("C:/images/1.png");
File outfile = new File("C:/temp1.jpg");
//�ļ�������
FileInputStream inputStream = new FileInputStream(file);
//�ļ������
FileOutputStream outputStream = new FileOutputStream(outfile);
//�����ļ�������
BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//�����ļ������
BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
int i = 0;
while(i != -1) {
i = bufferedInputStream.read();
bufferedOutputStream.write(i);
}
//���Ĺر�
bufferedOutputStream.flush();//ǿ�����������������
bufferedInputStream.close();
bufferedOutputStream.close();
*/
/**
* 3.���ļ��ܴ�,����Ҫ��һ�����崦��������ٶȡ�����:���ļ��Ĵ�С����512���ֽ�ʱ,ÿ�ζ���512���ֽں���������
* 
*/
/* File file = new File("C:/images/1.png");
File outfile = new File("C:/temp2.png");
//�ļ�������
FileInputStream inputStream = new FileInputStream(file);
//�ļ������
FileOutputStream outputStream = new FileOutputStream(outfile);
int i = 0;
//�����СΪ512�ֽ�
byte[] buffer = new byte[512];
while(true) {
if(inputStream.available() < 512) {
while(i != -1) {
i = inputStream.read();
outputStream.write(i);
}
break;//ע��˴���������Ŷ
} else {
//���ļ��Ĵ�С����512�ֽ�ʱ
inputStream.read(buffer);
outputStream.write(buffer);
}
}
//���Ĺر�
//ע�����Ĺر�(������)
inputStream.close();
outputStream.close();
*/
/**
* 4.�������������,���ǿ���֪��:���ǿ�����һ��˫������ļ�����
*/
File file = new File("C:/images/1.png");
File outfile = new File("C:/temp3.png");
//�ļ�������
FileInputStream inputStream = new FileInputStream(file);
//�ļ������
FileOutputStream outputStream = new FileOutputStream(outfile);
//�����ļ�������
BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//�����ļ������
BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
int i = 0;
//�������Ĵ�С
byte[] buffer = new byte[512];
while(true) {
if(bufferedInputStream.available() < 512) {
while(i != -1) {
i = bufferedInputStream.read();
bufferedOutputStream.write(i);
}
break;
} else {
//���ļ��Ĵ�С������512�ֽ�ʱ
bufferedInputStream.read(buffer);
bufferedOutputStream.write(buffer);
}
}
//ǿ����ջ�����������
bufferedOutputStream.flush();
//���Ĺر�
bufferedInputStream.close();
bufferedOutputStream.close();
}
}

