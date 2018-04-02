package org.sidao.bp;

import java.util.List;

import org.sidao.bp.aliyun.AliyunDNSR;

import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse.Record;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public int countProjects(){
    	AliyunDNSR adnsr=new AliyunDNSR();
//    	List<Record> wixctRecords=adnsr.getDomainRecord("wixct.com");
//    	for(Record r:wixctRecords) {
//    		System.out.println(r.getRecordId());
//    		System.out.println(r.getDomainName());
//    	}
    	return 0;
    }
}
