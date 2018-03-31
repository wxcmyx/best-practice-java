/**
 * 
 */
package org.sidao.bp.aliyun;

import java.util.List;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse.Record;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jfinal.kit.PropKit;

/**
 * @author xcwang
 *
 */
public class AliyunDNSR {
	private String aliKeyId;
	private String aliKeySecret;
	private static IAcsClient client = null;
	
	public AliyunDNSR() {
		// 加载属性文件
		PropKit.use("domain.properties");
		PropKit.appendIfExists("domain-prod.properties");
		// 获取属性
		this.aliKeyId = PropKit.get("alikeyid");
		this.aliKeySecret = PropKit.get("alikeysec");
		String regionId = "cn-hangzhou"; // 必填固定值，必须为“cn-hanghou”
		IClientProfile profile = DefaultProfile.getProfile(regionId, aliKeyId, aliKeySecret);
		client = new DefaultAcsClient(profile);
	}

	/**
	 * @param domainvalue 域名
	 * @return 记录列表
	 */
	public List<Record> getDomainRecord(String domainvalue) {
		DescribeDomainRecordsRequest request = new DescribeDomainRecordsRequest();
		request.setDomainName(domainvalue);
		DescribeDomainRecordsResponse response;
		List<Record> list=null;
		try {
			response = client.getAcsResponse(request);
			list = response.getDomainRecords();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @param recordId  记录ID
	 * @param ip 新的IP地址
	 * @return 返回的记录ID
	 */
	public String update(String recordId,String ip) {
		UpdateDomainRecordRequest request = new UpdateDomainRecordRequest();
//		request.setRecordId("3827828807455744");
		request.setRecordId(recordId);
		request.setValue(ip);
		UpdateDomainRecordResponse response;
		String respRecordId=null;
		try {
			response = client.getAcsResponse(request);
			respRecordId = response.getRecordId();
			//System.out.println(recordId);
			
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return respRecordId;
	}
}
