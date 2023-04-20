package bank.project.app;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.xml.bind.annotation.XmlSchema;

@EnableWs
@Configuration
public class LoanCreateConfiguration  extends WsConfigurerAdapter {
    @Bean(name = "bankloan")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bankLoanSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("BankLoanPort");
        schemaObject.setTargetNamespace("http://soap.bank.web.bankloansoapwebservice");
        schemaObject.setLocationUri("/bankloanpoint");
        schemaObject.setSchema(bankLoanSchema);
        return schemaObject;
    }

    @Bean
    public XsdSchema bankLoanSchema(){

        return new SimpleXsdSchema(new ClassPathResource("bankloan.xsd"));
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/bankloanpoint/*");
    }

}

