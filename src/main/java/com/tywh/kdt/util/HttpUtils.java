package com.tywh.kdt.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.parser.Feature;

/**
 * 版权所有：2017-天一文化所有，严禁外传 项目名称：ty-http-1.0
 * 
 * @className: HttpUtils
 * @description: http请求工具类
 * @author：jiasen
 * @date：2017-8-3 下午3:54:06
 * 
 * @editor：jiasen
 * @date：2017-8-3 下午3:54:06
 * @description：
 */
public class HttpUtils implements Serializable {

	/**
	 * serialVersionUID : 
	 */ 
	private static final long serialVersionUID = 3219606352379629323L;

	/**
	 * @author jiasen
	 * @date 2017-8-3 下午3:53:38
	 * 
	 * @Title: getEntity
	 * @Description: get请求获取HttpEntity
	 * @param url
	 * @return
	 * @return HttpEntity
	 * @throws
	 */
	public static HttpEntity getEntity(String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return response.getEntity();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			try {
//				if (response != null)
//					response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:01:30
	*
	* @Title: postEntity 
	* @Description: post请求，获取HttpEntity
	* @param url
	* @param params
	* @return
	* @return HttpEntity 
	* @throws 
	*/
	public static HttpEntity postEntity(String url, List<NameValuePair> params) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			post.setHeader("Accept", "application/json");
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return response.getEntity();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			try {
//				if (response != null)
//					response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:02:02
	*
	* @Title: postEntity 
	* @Description: post请求，获取HttpEntity
	* @param url
	* @param params
	* @return
	* @return HttpEntity 
	* @throws 
	*/
//	public static HttpEntity postEntity(String url, MultipartEntityBuilder params) {
//		CloseableHttpClient client = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		CloseableHttpResponse response = null;
//		try {
//			HttpEntity httpEntity = params.build();
//			post.setEntity(httpEntity);
//			response = client.execute(post);
//			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				return response.getEntity();
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(response != null)
//					response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:16:32
	*
	* @Title: postEntity 
	* @Description: post请求，获取HttpEntity
	* @param url
	* @param params
	* @return
	* @return HttpEntity 
	* @throws 
	*/
	public static HttpEntity postEntity(String url, String params) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			post.setEntity(new StringEntity(params, "UTF-8"));
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return response.getEntity();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(response != null)
					response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:17:25
	*
	* @Title: getString 
	* @Description: get请求，获取String
	* @param url
	* @return
	* @return String 
	* @throws 
	*/
	public static String getString(String url) {
		try {
			return EntityUtils.toString(getEntity(url));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:17:39
	*
	* @Title: postString 
	* @Description: post请求，获取String
	* @param url
	* @param params
	* @return
	* @return String 
	* @throws 
	*/
	public static String postString(String url, List<NameValuePair> params) {
		try {
			return EntityUtils.toString(postEntity(url, params));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:17:49
	*
	* @Title: postString 
	* @Description: post请求，获取String
	* @param url
	* @param params
	* @return
	* @return String 
	* @throws 
	*/
//	public static String postString(String url, MultipartEntityBuilder params) {
//		try {
//			return EntityUtils.toString(postEntity(url, params));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:17:54
	*
	* @Title: postString 
	* @Description: post请求，获取String
	* @param url
	* @param params
	* @return
	* @return String 
	* @throws 
	*/
	public static String postString(String url, String params) {
		try {
			return EntityUtils.toString(postEntity(url, params));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:18:00
	*
	* @Title: getJson 
	* @Description: get请求获取JSONObject
	* @param url
	* @return
	* @return JSONObject 
	* @throws 
	*/
//	public static JSONObject getJson(String url) {
//		return JSONObject.parseObject(getString(url), Feature.OrderedField);
//	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:18:19
	*
	* @Title: postJson 
	* @Description: post请求获取JSONObject
	* @param url
	* @param params
	* @return
	* @return JSONObject 
	* @throws 
	*/
//	public static JSONObject postJson(String url, List<NameValuePair> params) {
//		return JSONObject.parseObject(postString(url, params),  Feature.OrderedField);
//	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:18:30
	*
	* @Title: postJson 
	* @Description: post请求获取JSONObject
	* @param url
	* @param params
	* @return
	* @return JSONObject 
	* @throws 
	*/
//	public static JSONObject postJson(String url, MultipartEntityBuilder params) {
//		return JSONObject.parseObject(postString(url, params), Feature.OrderedField);
//	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:18:35
	*
	* @Title: postJson 
	* @Description: post请求获取JSONObject
	* @param url
	* @param params
	* @return
	* @return JSONObject 
	* @throws 
	*/
//	public static JSONObject postJson(String url, String params) {
//		return JSONObject.parseObject(postString(url, params), Feature.OrderedField);
//	}
	
	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:19:09
	*
	* @Title: getStream 
	* @Description: get请求，获取InputStream
	* @param url
	* @return
	* @return InputStream 
	* @throws 
	*/
	public static InputStream getStream(String url) {
		try {
			return getEntity(url).getContent();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 
	* @author jiasen
	* @date 2017-8-3 下午4:19:24
	*
	* @Title: postStream 
	* @Description: post请求，获取InputStream
	* @param url
	* @param params
	* @return
	* @return InputStream 
	* @throws 
	*/
	public static InputStream postStream(String url, List<NameValuePair> params) {
		try {
			return postEntity(url, params).getContent();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 
	* @author jiasen
	* @date 2017年10月19日 上午9:13:09
	*
	* @Title: postStream 
	* @Description: post请求，传递流对象，获取InputStream
	* @param url
	* @param params
	* @return
	* @return InputStream 
	* @throws 
	*/
//	public static InputStream postStream(String url, MultipartEntityBuilder params) {
//		try {
//			return postEntity(url, params).getContent();
//		} catch (UnsupportedOperationException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
