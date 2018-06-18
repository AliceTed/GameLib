<%@page import="bean.GameList"%>
<%@page import="java.util.List"%>
<%@page import="bean.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/header.jsp"%>

<%
GameList games= (GameList) request.getAttribute("list");
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h2 class="form-signin-heading">ゲーム一覧</h2>
	</div>
	<div class="panel-body">
			<table class="table">
				<tr>
				<td>ID</td>
				<td>タイトル</td>
				<td>会社名</td>
				<td>操作</td>
			</tr>
				<%for (Game game : games){%>
				<tr>
					<td><%=game.getId()%></td>
					<td><%=game.getTitle()%></td>
					<td><%=game.getCompany()%></td>
					<td>
					<div class="btn-group">
					 <button type="button" class="btn btn-primary">操作</button>
					 <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					 <span class="caret"></span>
					 <span class="sr-only">Toggle Dropdown</span>
					  </button>
					 <ul class="dropdown-menu">
					 	<li><a href="Show.action?id=<%=game.getId()%>" class="btn btn-info">詳細</a></li>
					 	<li><a href="Edit.action?id=<%=game.getId()%>" class="btn btn-success">編集</a></li>
					 	<li><a href="Delete.action?id=<%=game.getId()%>" class="btn btn-danger"
						onclick="javascript:return confirm('本当に削除しますか？')">削除</a></li>
					 </ul>
					</div>
					</td>
				</tr>
				<%}%><!--/.for books  -->
			</table>
	</div><!--/.panel-body -->
	<div class="panel-footer" align="right">
		<a href="new.jsp" class="btn btn-success">新規作成</a>
	</div>
</div>


<%@include file="../layouts/footer.jsp"%>
