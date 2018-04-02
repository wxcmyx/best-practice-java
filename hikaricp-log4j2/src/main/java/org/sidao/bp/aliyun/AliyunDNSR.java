/**
 * 
 */
package org.sidao.bp.aliyun;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(AliyunDNSR.class.getName());

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
		if (logger.isDebugEnabled()) {
			logger.debug("update(String, String) - start"); //$NON-NLS-1$
		}

		UpdateDomainRecordRequest request = new UpdateDomainRecordRequest();
		request.setRecordId(recordId);
		request.setValue(ip);
		request.setRR("@");
		request.setType("A");
		UpdateDomainRecordResponse response;
		String respRecordId=null;
		try {
			response = client.getAcsResponse(request);
			respRecordId = response.getRecordId();
		} catch (ServerException e) {
			logger.error("update(String, String)", e); //$NON-NLS-1$
		} catch (ClientException e) {
			logger.error("update(String, String)", e); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(String, String) - end"); //$NON-NLS-1$
		}
		return respRecordId;
	}
}
