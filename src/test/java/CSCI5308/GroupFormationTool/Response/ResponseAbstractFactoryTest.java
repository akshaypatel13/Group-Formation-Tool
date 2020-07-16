package CSCI5308.GroupFormationTool.Response;

public class ResponseAbstractFactoryTest {
	
    private static ResponseAbstractFactoryTest uniqueInstance = null;
    private IResponsePersistence responsePersistence;
    public static ResponseAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new ResponseAbstractFactoryTest();
        }
        return uniqueInstance;
    }
    
    private ResponseAbstractFactoryTest(){
    	responsePersistence = new ResponseDBMock();
    }

    public IResponsePersistence getResponsePersistence(){
        return responsePersistence;
    }
    
}
