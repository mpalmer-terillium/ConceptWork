package com.concepttest.service;

import com.concepttest.dto.JDEServiceResponse;
import com.concepttest.processor.ConceptProcessor;
import com.concepttest.valueobject.JDECustomer;
import com.concepttest.valueobject.JDEItem;
import com.concepttest.valueobject.QuoteUpdate;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class JDEToConceptService {
    
    private static final ConceptProcessor conceptProcessor = new ConceptProcessor();
    
    @WebMethod
    public JDEServiceResponse updateQuoteStatus(@WebParam(name="Quote to Update")
                                                QuoteUpdate quoteToUpdate) {
        return conceptProcessor.updateQuoteStatus(quoteToUpdate);
    }
    
    @WebMethod
    public JDEServiceResponse processItem(@WebParam(name="Item")
                                          JDEItem item) {
        return conceptProcessor.processItem(item);
    }
    
    @WebMethod
    public JDEServiceResponse processCustomer(@WebParam(name="Customer") 
                                              JDECustomer jdeCustomer) {
        return conceptProcessor.processCustomer(jdeCustomer);
    }
}
