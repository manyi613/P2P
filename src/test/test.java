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
	private static String filenameflst = "/企业设置_法律实体V3.xlsx";
	private static List<String[]> data = null;
//	private static List<String[]> temp;
	public static List<Map> LegalEntity = new ArrayList<Map>();
	public List<Map[]>  CostCenter = new ArrayList<Map[]>();
	public List<Map[]>  Dept = new ArrayList<Map[]>();
	public List<Map[]>  Employee = new ArrayList<Map[]>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = fileBase + filenameflst;
        File file = new File(filePath);
       
        data  = POIUtil.readExcel(file);
//        System.out.println(data.size());
        getLegalEntityData(data);
        verifyFieldDup("编码",LegalEntity);
        verifyFieldDup("法律实体名称",LegalEntity);
        printList(LegalEntity);
//        System.out.println(data.size());
//        for(int i = 0 ; i< data.size(); i++) {
//        	String[] tmp = data.get(i);
//        	for(int j = 0 ; j < tmp.length ; j ++) {
//        		System.out.println(tmp[j]);
//        	}
//        	
//        }
        
	}
	public static void getLegalEntityData(List<String[]> temp) {
		
		String[] key = null;
		for(int i = 0 ; i< temp.size(); i++) {
			Map map = new HashMap();
			String[] str = temp.get(i);
        	if(i == 0 ) {
        		key = str;
        		continue;
        	}
        	for(int j = 0 ; j < str.length ; j ++) {
//        		System.out.println(str[j]);
        		map.put(key[j], str[j]);
        		
        	}
        	LegalEntity.add(map);
        }
		
		
	}
	
	public static void printList(List<Map> legalEntity2) {
			Iterator it1 = legalEntity2.iterator();
			while(it1.hasNext()){
				System.out.println(it1.next());
			}
	}
	public static void verifyFieldDup(String str,List<Map> source) {
		String value = "";
		
		for(int i = 0;i < source.size(); i ++){
			Map map = source.get(i);
			
			if(i == 0) {
				value = (String) map.get(str);
				continue;
			}
			
            if(map.get(str).equals(value)) {
            	int j = i+ 1;
            	System.out.println(str + "重复！！！！" + "第" + j + "行，，，"+ "重复字段为：" + value);
            }
            else {
            	value = (String) map.get(str);
            }
        }
}
	
	
	public File getFileFromPath(String filePath) {
		
		return new File(filePath);
		
	}
}
