package org.sidao.bp;

import org.sidao.bp.aliyun.AliyunDNSR;

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
    	adnsr.getDomainRecord("wixct.com");
    	
    	return 0;
    }
}
