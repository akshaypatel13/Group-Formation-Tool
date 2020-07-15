package CSCI5308.GroupFormationTool.Response;

public class ResponseAbstractFactory {

	private static ResponseAbstractFactory uniqueInstance = null;
    private static IResponsePersistence responseDB;
    
    public static ResponseAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new ResponseAbstractFactory();
        }
        return uniqueInstance;
    }
    
    private ResponseAbstractFactory(){
    	responseDB = new ResponseDB();
    }
    
    public IResponse createResponseInstance() {
        return new Response();
    }
    
    public IResponsePersistence createResponseDBInstance() {
        return responseDB;
    }
}
