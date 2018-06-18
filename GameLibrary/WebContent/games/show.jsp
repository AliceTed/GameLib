<%@page import="bean.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/header.jsp"%>

<%
	Game game = (Game) request.getAttribute("game");
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h2 class="form-signin-heading">詳細</h2>
	</div>
	<div class="panel-body">
		<table class="table">
			<tr>
				<td>ID</td>
				<td>タイトル</td>
				<td>会社名</td>
				<td>発売日</td>
				<td>ジャンル</td>
			</tr>
			<tr>
				<td><%=game.getId()%></td>
				<td><%=game.getTitle()%></td>
				<td><%=game.getCompany()%></td>
				<td><%=game.getFormatDate()%></td>
				<td><%=game.getGenre()%></td>
			</tr>
		</table>
	</div>
	<div class="panel-footer" align="right">
		<a href="Index.action" class="btn btn-primary" role="button">戻る</a>
	</div>
</div>



<%@include file="../layouts/footer.jsp"%>
