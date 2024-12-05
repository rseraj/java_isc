package model;


import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import accounts.Account;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * this is AppService
 *
 */
public class Application 
{
    public static void main( String[] args ) throws Exception
    {
    	
        File flie =new File("acocount.json");
        
        ObjectMapper objectmaper = new ObjectMapper();
        //transaction ta= o3.readValue(flie2,  transaction.class);
        Account a = objectmaper.readValue(flie ,  Account.class);

       
        System.out.println(  a.toString() );
    }
}