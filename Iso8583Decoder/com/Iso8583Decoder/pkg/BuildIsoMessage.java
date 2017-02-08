package com.Iso8583Decoder.pkg;

import java.io.IOException;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;



public class BuildIsoMessage {
	
	public static void main(String[] args) throws IOException, ISOException {
		//Create Packager based on XML that contain DE type
        GenericPackager packager = new GenericPackager("Iso8583Decoder/base1.xml");
		
        // Create ISO Message
        ISOMsg isoMsg = new ISOMsg();
       
        // Setting values
        isoMsg.setMTI("0200");
		/*isoMsg.set(3, "201234");
		isoMsg.set(4, "10000");
		isoMsg.set(7, "110722180");
		isoMsg.set(11, "123456");
		isoMsg.set(12, "789101");
		isoMsg.set(13, "989898");
		isoMsg.set(39, "00");*/
		isoMsg.set(41,"80117712");
		/*isoMsg.set(42,"341198052      ");
		isoMsg.set(44,"EB4E53397F3FE12C8BD41");*/
		//isoMsg.set(55,"82020800950580800000009A031610185F3401009F100706010C03A000009F2608AA84D42F73E9A8049F2701809F34033F00009F3602013F9F3704990FC066");
		
		//Setting package
		isoMsg.setPackager(packager);
		
        //Printing the DE list
        //logISOMsg(isoMsg);
       
        
        // Get and print the output result
        byte[] data = isoMsg.pack();
        
        String valueHex = ISOUtil.hexdump(data);
        String dataString = new String(data);
        /*for(int i=1;i<data.length;i++){
        	System.out.print(data[i]);
        }*/
        //System.out.println(dataString);
        

      
     }
 
	private static void logISOMsg(ISOMsg msg) {
		System.out.println("----ISO MESSAGE-----");
		try {
			System.out.println("  MTI : " + msg.getMTI());
			for (int i=1;i<=msg.getMaxField();i++) {
				if (msg.hasField(i)) {
					System.out.println("    Field-"+i+" : "+msg.getString(i));
				}
			}
		} catch (ISOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------------------");
		}
 
	}
}
