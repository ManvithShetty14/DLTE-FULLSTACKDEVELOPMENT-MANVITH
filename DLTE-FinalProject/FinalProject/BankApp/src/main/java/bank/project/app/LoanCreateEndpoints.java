package bank.project.app;
import bank.project.dao.LoanScheme;
import bank.project.dao.LoanScheme;
import bank.project.dao.RoleService;
import bankloansoapwebservice.web.bank.soap.CreateNewLoanRequest;
import bankloansoapwebservice.web.bank.soap.CreateNewLoanResponse;
import bankloansoapwebservice.web.bank.soap.ServiceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

@Endpoint

public class LoanCreateEndpoints {
    private static final String url="http://soap.bank.web.bankloansoapwebservice";
    private Logger logger= LoggerFactory.getLogger(LoanCreateEndpoints.class);

    @Autowired
    private RoleService roleService;

    @PayloadRoot(namespace = url,localPart = "createNewLoanRequest")
    @ResponsePayload
    public CreateNewLoanResponse createNewLoanResponse(@RequestPayload CreateNewLoanRequest createNewLoanRequest){
        CreateNewLoanResponse createNewLoanResponse =new CreateNewLoanResponse();
        LoanScheme pojo=new LoanScheme();
        ServiceStatus serviceStatus=new ServiceStatus();
        logger.info("Service has been considered.");
        // source,target
        BeanUtils.copyProperties(createNewLoanRequest.getBankloan(),pojo);
        logger.info("Request properties are copied to pojo");
        roleService.insertLoan(pojo);
        logger.info("Entity has inserted");
        serviceStatus.setStatus("Success");
        serviceStatus.setMessage("Object Inserted");
        createNewLoanResponse.setBankloan(createNewLoanRequest.getBankloan());
        createNewLoanResponse.setServiceStatus(serviceStatus);
        logger.info("Response object assembled yet to send");
        return createNewLoanResponse;
    }
}

