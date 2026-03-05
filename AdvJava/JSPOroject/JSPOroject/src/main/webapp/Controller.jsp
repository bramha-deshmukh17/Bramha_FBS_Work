<%@page import="jakarta.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session = "true"%>

<jsp:useBean id="s" class="com.StudentCourseDetails" scope="session">
	<jsp:setProperty name="s" property="*" />
</jsp:useBean>

<jsp:forward page="result.jsp"/>
 