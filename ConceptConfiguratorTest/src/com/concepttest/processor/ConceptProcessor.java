package com.concepttest.processor;

import com.concepttest.dto.JDEServiceResponse;
import com.concepttest.util.Util;
import com.concepttest.valueobject.JDECustomer;
import com.concepttest.valueobject.JDEItem;
import com.concepttest.valueobject.QuoteUpdate;

import com.configureone.ws.ConceptAccessAPI;
import com.configureone.ws.ConceptAccessAPIService;
import com.configureone.ws.Customer;
import com.configureone.ws.ItemMaster;
import com.configureone.ws.Response;

public class ConceptProcessor {
    
    private static final ConceptAccessAPI concept = new ConceptAccessAPIService().getConceptAccess();
    
    public JDEServiceResponse updateQuoteStatus(QuoteUpdate quote) {
        JDEServiceResponse response = new JDEServiceResponse();
        response.setStatus(internalUpdateQuoteStatus(quote));
        return response;
    }
    
    public JDEServiceResponse processItem(JDEItem item) {
        ItemMaster itemMaster = Util.mapJDEItemToItemMaster(item);
        JDEServiceResponse response = new JDEServiceResponse();
        response.setStatus(internalProcessItem(itemMaster));
        return response;
    }
    
    public JDEServiceResponse processCustomer(JDECustomer jdeCustomer) {
        Customer customer = Util.mapJDECustomerToCustomer(jdeCustomer);
        JDEServiceResponse response = new JDEServiceResponse();
        response.setStatus(internalProcessCustomer(customer));
        return response;
    }
    
    /*
     * two input parameters - according to SOAPUI (from the wsdl)
     * param1 is a string SERIAL NUMBER
     * param2 is a string STATUS
     * 
     * Likely we will just need to know what they want the status set to, then we can work on
     * making the updates.  It looks like Concept uses Serial Numbers, which might get hairy.
     */
    private String internalUpdateQuoteStatus(QuoteUpdate quote) {
        Response response = concept.updateQuote(quote.getSerialNumber(), quote.getStatus());
        return response.isSuccess() ? "OK" : "ERROR";
    }
    
    
    
    /*
     * itemMaster is the full item information - pass this in and update whatever needs it
     * (this may or may not be how it actually works!)
     */
    private String internalProcessItem(ItemMaster itemMaster) {
        
        Response response = concept.processItem(itemMaster);
        return response.isSuccess() ? "OK" : "ERROR";
    }
    
    /*
     * similar to the item one - this one just takes all the customer info
     * (again - may or may not actually work this way!)
     */
    private String internalProcessCustomer(Customer customer) {
        Response response = concept.processCustomer(customer);
        return response.isSuccess() ? "OK" : "ERROR";
    }
}
