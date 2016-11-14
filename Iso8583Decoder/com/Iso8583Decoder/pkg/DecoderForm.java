package com.Iso8583Decoder.pkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

/**
 * Servlet implementation class DecoderForm
 */
@WebServlet("/DecoderForm")
public class DecoderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected String myParam = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecoderForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String frame_txt = request.getParameter("frame_txt");
		
		//eliminamos los espacios y saltos de línea
		String iso_frame = fusionIsoValues(frame_txt);
		
				
		//generamos la trama decodificada
		ParseIsoMessage parser = new ParseIsoMessage();
		GenericPackager packager = null;
		String iso_frame_parsed = new String();
		try {
			//packager = new GenericPackager("basic.xml");
			iso_frame_parsed = parser.getIsoMsgUnpacked(frame_txt,packager);
		} catch (ISOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		request.setAttribute("resp",iso_frame_parsed);
		RequestDispatcher rd = request.getRequestDispatcher("/Iso8583DecoderView/General/mainView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public String fusionIsoValues(String iso_frame){
		String new_iso = new String();
		new_iso = iso_frame.replaceAll("\\s", "");
		System.out.println(new_iso);
		return new_iso;
	}

}
