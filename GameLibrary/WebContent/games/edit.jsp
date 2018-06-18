<%@page import="bean.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/header.jsp"%>

<%
	Game game=(Game)request.getAttribute("game");
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h2 class="form-signin-heading">編集</h2>
	</div>
	<form action="Update.action" method="post">
		<div class="panel-body">

			<div class="input-group-addon3">
				<label for="title">書籍名</label>
				<input type="text" name="title" class="form-control" placeholder="タイトル..."
				 value=<%= game.getTitle() %> required>
				<label for="company">会社名</label>
				<input type="text" name="company" class="form-control" placeholder="会社名..."
				value=<%= game.getCompany()%> required>
				<label for="date">発売日</label>
				<input type="date" name="release" class="form-control" value=<%= game.getDate() %> required>

				<label for="date">ジャンル</label>
				<select class="form-control" name="genre">
        			<option value="アクション" >アクション</option>
        			<option value="シューティング">シューティング</option>
        			<option value="RPG">RPG</option>
        			<option value="シミュレーション・ストラテジー">シミュレーション・ストラテジー</option>
        			<option value="アドベンチャー">アドベンチャー</option>
       				<option value="その他" >その他</option>
      			</select>
			</div>
		</div>
		<div class="panel-footer" align="right">
			<input type="hidden" name="id" value=<%= game.getId()%>> <input
				type="submit" class="btn btn-success" value="変更">
			<a href="Index.action" class="btn btn-primary">戻る</a>
		</div>
	</form>
</div>

<%@include file="../layouts/footer.jsp"%>