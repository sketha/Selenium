import io.restassured.RestAssured;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Map;

/**
 * Author: Sunil Ketha
 * Version: 1.0
 * Date of Creation: 03/26/2019
 * Class Description: This is Rest API wrapper covers all Rest Call Methods built on top of Rest Assured
 */

public class RestAssuredCore {

    private RequestSpecification request;
    private Response response;
    public RestAssuredCore() {
    }
    /**
     *
     * @param baseURI Initialize baseURI in RestAssuredCore constructor
     * @param basePath you can pass basepath alone or including basepath and relative path
     */
    public RestAssuredCore(String baseURI, String basePath) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        request = RestAssured.given().log().all();
    }
    /**
     *
     * @param baseURI Initialize baseURI in RestAssuredCore constructor
     * @param basePath you can pass basepath alone or including basepath and relative path
     * @param authenticationType Support as of now basic authentication type
     * @param usernameOrCertPath Can pass either certification path or username, keep one variable so that can use two conditions
     * @param password supply password
     */
    public RestAssuredCore(String baseURI, String basePath, String authenticationType, String usernameOrCertPath, String password, String token) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        if (authenticationType.equalsIgnoreCase("ssl")) {
            RestAssured.config = RestAssuredConfig.newConfig().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
            RestAssured.authentication = RestAssured.certificate(usernameOrCertPath, password);
            request = RestAssured.given().log().all();
        } else if (authenticationType.equalsIgnoreCase("basic")) {
            request = RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic(usernameOrCertPath, password).log().all();
        }  else if (authenticationType.equalsIgnoreCase("basic-NonPreemptive")) {
            request = RestAssured.given().relaxedHTTPSValidation().auth().basic(usernameOrCertPath, password).log().all();
        } else if(authenticationType.equalsIgnoreCase("Bearer-token")) {
            request=RestAssured.given().relaxedHTTPSValidation().header(new Header("Authorization", "Bearer "+token));
        }else if(authenticationType.equalsIgnoreCase("NoAuth")) {
            request=RestAssured.given().relaxedHTTPSValidation().log().all();
        }
    }
    /**
     *
     * @param baseURI Reset basetURI value as null
     */
    public static void resetBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    /**
     *
     * @param basePath Reset basePath value as null
     */
    private static void resetBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    /**
     * It reset all like baseURI, basePATH etc.,
     */
    private static void resetAll() {
        RestAssured.reset();
    }

    /**
     *
     * @param state must be set True or False. This will encypt when you set True
     * @return current class object
     */
    public RestAssuredCore setURLEncodingStatus(boolean state) {
        request.urlEncodingEnabled(state);
        return this;
    }
    /**
     * @param configureEnv to verify condition
     */
    public RestAssuredCore reConfigureEnv(String configureEnv) {
        switch (configureEnv) {
            case "baseURI":resetBaseURI(configureEnv); break;
            case "basePath":resetBasePath(configureEnv); break;
            default: break;
        }
        return this;
    }

    /**
     * @param resetType One method to reset specific requirement
     */
    public RestAssuredCore resetRestConfig(String resetType) {
        switch (resetType) {
            case "baseURI":resetBaseURI(null); break;
            case "basePath":resetBasePath(null);break;
            default: resetAll(); break;
        }
        return this;
    }
    /**
     *
     * @param requestType supply keys like "GET","PUT","POST","DELETE","PATCH"
     * @param resourcePath is combination of baseURI, basePATH and resourcePATH
     * @return Instantiating Response class to hold response object after invoking request
     */
    public RestResponse invokeRestCall(String requestType, String resourcePath) {
        switch (requestType) {
            case "GET":response = request.get(resourcePath); break;
            case "PUT":response = request.put(resourcePath); break;
            case "POST":response = request.post(resourcePath); break;
            case "DELETE":response = request.delete(resourcePath);break;
            case "PATCH": response = request.patch(resourcePath); break;
            default:break;
        }
        return new RestResponse(response);
    }

    /**
     *
     * @param contentType set content type
     * @return current class object
     */
    public RestAssuredCore setContentType(String contentType) {
        request = request.contentType(contentType);
        return this;
    }

    /**
     *
     * @param headerType set header
     * @param o object
     * @return current class object
     */
    public RestAssuredCore setHeader(String headerType, Object o) {
        request = request.headers(headerType, o);
        return this;
    }
    /**
     *
     * @param headerType Pass entire header set as map
     * @return current class object
     */
    public RestAssuredCore setHeaders(Map<String, ?> headerType) {
        request = request.headers(headerType);
        return this;
    }

    /**
     *
     * @param filePayload Pass payload in file format
     * @return current class object
     */
    public RestAssuredCore setBodyAsInputStream(String filePayload) {
        File file = new File(filePayload);
        request = request.body(file);
        return this;
    }

    /**
     *
     * @param filePayload Pass payload in file format
     * @return current class object
     */
    public RestAssuredCore setBodyAsString(String filePayload) {

        request = request.body(filePayload);
        return this;
    }

    public RestAssuredCore setBodyAsJSONObject(JSONObject json){
        request = request.body(json.toJSONString());
        return this;
    }

    /**
     *
     * @param query accept single query and its param
     * @param param value
     * @return return current class object
     */
    public RestAssuredCore setQueryParam(String query, String param) {
        request = request.queryParam(query, param);
        return this;
    }
    /**
     * Initializing multipathparam
     *
     * @param pathParamList Initializing dynamic value and use variable in rest endpoint
     *                      for eg., test/{value} can add multiple values
     */
    public RestAssuredCore setMultiPathParam(Map<String, ?> pathParamList) {
        request = request.pathParams(pathParamList).log().ifValidationFails();
        return this;
    }

    /**
     * Initializing multiQueryParams
     *
     * @param queryParamList Initializing dynamic query param
     */
    public RestAssuredCore setMultiQueryParams(Map<String, ?> queryParamList) {
        request = request.queryParams(queryParamList).log().ifValidationFails();
        return this;
    }

    /**
     * Initializing multiformParams
     *
     * @param formParamList Initializing dynamic form param list
     */
    public RestAssuredCore setFormParams(Map<String, ?> formParamList) {
        request = request.formParams(formParamList);
        return this;
    }

	/*public RestAssuredCore setFormParamsInString(String arg1) {
		request = request.
		return this;
	}*/
    /**
     * Intializing attachment for API request
     *
     * @param sAttachment supports file attachments
     */
    public RestAssuredCore setMultiPart(String sAttachment) {
        File file = new File(sAttachment);
        request = request.multiPart(file);
        return this;
    }

    /**
     * @param multiHeaderLists set multiple headers
     * @return current class object
     */
    public RestAssuredCore setMultiHeaders(Map<String, ?> multiHeaderLists) {
        request = request.headers(multiHeaderLists);
        return this;
    }

    /**
     * @param 'method to convert the payload as String
     * @return current class object
     */
    public static String convertPayloadtoStringFormat(String filePath){
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {	String line;
            while ((line = br.readLine()) != null) {
                sb.append(line); sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

}
