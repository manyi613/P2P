package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test {

	private static String fileBase = "D:\\工作文档\\P2O\\数据\\20170621";
	private static String filenameflst = "/5. 企业设置_法律实体V3.xlsx";
	private static List<String[]> data = null;
//	private static List<String[]> temp;
	public List<Map[]> LegalEntity = new ArrayList<Map[]>();
	public List<Map[]>  CostCenter = new ArrayList<Map[]>();
	public List<Map[]>  Dept = new ArrayList<Map[]>();
	public List<Map[]>  Employee = new ArrayList<Map[]>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = fileBase + filenameflst;
        File file = new File(filePath);
       
        data  = POIUtil.readExcel(file);
        System.out.println(data.size());
        for(int i = 0 ; i< data.size(); i++) {
        	String[] tmp = data.get(i);
        	for(int j = 0 ; j < tmp.length ; j ++) {
        		System.out.println(tmp[j]);
        	}
        	
        }
        
	}
	public void getLegalEntityData(List<String[]> temp) {
		Map map = new HashMap();
		for(int i = 0 ; i< temp.size(); i++) {
        	String[] str = temp.get(i);
        	
        	for(int j = 0 ; j < str.length ; j ++) {
        		System.out.println(str[j]);
//        		map.put(key, value)
//        		LegalEntity
        	}
        	
        }
		
		
	}
	
	
	
	
	public File getFileFromPath(String filePath) {
		
		return new File(filePath);
		
	}
}
