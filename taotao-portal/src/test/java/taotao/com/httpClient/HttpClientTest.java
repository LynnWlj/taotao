package taotao.com.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void doGet() throws Exception {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个GET对象
		HttpGet get = new HttpGet("http://www.sogou.com");
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 取响应的结果
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		// 关闭httpclient
		response.close();
		httpClient.close();
	}
	
	
	@Test
	public void doGetPar() throws Exception {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个GET对象
		URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
		uriBuilder.addParameter("query", "赵丽颖");		
		HttpGet get = new HttpGet(uriBuilder.build());
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 取响应的结果
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		// 关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPost() throws Exception {

		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个GET对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
		// 执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		// 取响应的结果
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		// 关闭httpclient
		response.close();
		httpClient.close();
	}

	public static void main(String[] args) throws Exception {

	}

}