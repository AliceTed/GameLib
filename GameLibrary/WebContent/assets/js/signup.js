/**
 *
 */

function CheckPassward()
{
	var pw=document.signup.elements['passward'];
	var repw=document.signup.elements['repassward'];
	if(pw.value!=repw.value)
	{
		alert("パスワードが一致しません。");
		return false
	}
	return true;
}