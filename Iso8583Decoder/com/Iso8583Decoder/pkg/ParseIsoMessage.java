package com.Iso8583Decoder.pkg;

import java.io.IOException;

import org.jpos.iso.ISOComponent;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOFieldPackager;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

public class ParseIsoMessage {
	
	public static void main(String[] args) throws IOException, ISOException {
		// Create Packager based on XML that contain DE type
		GenericPackager packager = new GenericPackager("Iso8583Decoder/base24.xml");
 
		// Print Input Data
		String data = "02003238000002D0000020123400000001000001107221801234567891019898983030383031313737313233343131393830353220202020202021EB4E53397F3FE12C8BD41";
		
		System.out.println("DATA : " + data);
		// Create ISO Message
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);		
		isoMsg.unpack(data.getBytes());
		
 
		// print the DE list
		String log = logISOMsg(isoMsg);
		System.out.println(log);
	}
	
	public String getIsoMsgUnpacked(String data, GenericPackager packager) throws ISOException{
		String value_iso = new String();
		// Create ISO Message
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);
		isoMsg.unpack(data.getBytes());
 
		// print the DE list
		value_iso = logISOMsg(isoMsg);
		return value_iso;
	}

	public static String logISOMsg(ISOMsg msg) throws ISOException {
		String log =new String();
		log += "----ISO MESSAGE-----\n";
		GenericPackager packager = new GenericPackager("Iso8583Decoder/basic.xml");
		try {
			log +="  MTI : " + msg.getMTI()+"\n";
			for (int i=1;i<=msg.getMaxField();i++) {
				if (msg.hasField(i)) {
					String val = packager.getFieldPackager(39).getClass().toString();
					String[]  words= val.split(" ");
					String[] words2 = words[1].split("\\.");					
					String class_package_name = words2[words2.length-1];
					if(class_package_name.equals("IFA_BINARY"))
						log += "    Field-"+i+" : "+ISOUtil.dumpString(msg.getBytes(i))+"\n";
					else
						log += "    Field-"+i+" : "+msg.getString(i)+"\n";
				}
			}
		} catch (ISOException e) {
			e.printStackTrace();
		} finally {
			log +="--------------------\n";
		}
		return log;
	}
	
}
