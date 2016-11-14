<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<meta charset="utf-8">
	<title>Inicio</title>
	<!-- The styles -->
	<link id="bootstrap-css" href="Iso8583DecoderView/General/css/bootstrap.css" rel="stylesheet">
	<link id="isodecoder-css" href="Iso8583DecoderView/General/css/isodecoder_style.css" rel="stylesheet">
    <link href='Iso8583DecoderView/General/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <!-- jQuery -->
    <script src="Iso8583DecoderView/General/bower_components/jquery/jquery.min.js"></script>	
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!--  HEADER -->
	<div class="page-header" style="border-bottom:1px solid #DDDDDD;">
		<div class="container-fluid">
			<div class="head-content row">
				<div class="col-md-2">
					<img src="Iso8583DecoderView/General/res/logo_ISOD.png" alt="Image Not Found" style="margin-bottom:10px; margin-top:-20px">
				</div>
				<div class="col-md-2 col-md-offset-8">
					<img src="Iso8583DecoderView/General/res/visanet_peru.png" alt="Image Not Found" style="width:80%;margin-bottom:10px; margin-top:-20px" >
				</div>
			</div>
		</div>		
	</div>
	<form action="DecoderForm">	
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-primary">
						  <div class="panel-heading">Ingresar Trama ISO 8583 (Envío o Respuesta)</div>
						  <div class="panel-body">
						    	<textarea class="form-control" rows="10" style="resize:none;" name ="frame_txt"></textarea>
						  </div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-warning">
						  <div class="panel-heading">Ingresar Packager ISO 8583</div>
						  <div class="panel-body">
						    	<textarea class="form-control" rows="10"  style="resize:none;" name="pck_txt"></textarea>
						  </div>
					</div>
				</div>
			</div>	
		</div>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					
						<input type="submit" class="btn btn-info" value="DECODIFICAR" style="display:block;margin: 0 auto;margin-bottom:15px;">
					
				</div>
			</div>
		</div>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-success">
						  <div class="panel-heading">Ingresar Trama ISO 8583 (Envío o Respuesta)</div>
						  <div class="panel-body">
						    	<textarea class="form-control" rows="10" style="resize:none;"><c:set var="example" scope="session" value="<%= request.getAttribute(\"resp\") %>"/><c:out value="${example}"/></textarea>
						  </div>
					</div>
				</div>
			</div>
		</div>	
	</form>
	<!-- FOOTER  -->
	
	<div class="footer" style="background-color:#DDDDDD;border-bottom:1px solid #DDDDDD;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2 col-md-offset-1" style="margin-top:10px;">
					<p class="pull-left"><a href=""><strong></strong> Iso8583 Decoder</a><strong>  &copy; 2016</strong></p>
         		</div>
				<div class="col-md-2 col-md-offset-6"  style="margin-top:10px;">
					<p class="pull-right"><strong>Powered by:</strong> <a href="">Luis M. Miranda</a></p>
				</div>
			</div>
		</div>		 
	</div>	
</body>
</html>