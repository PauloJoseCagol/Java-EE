<!DOCTYPE html>
<%@page import="br.com.javaweb.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<script>
function confirma(i) {
	if(window.confirm("Confirma a excluisão?")){
		 location.href="cliente?i="+i;
	}
}

</script>

<body>


	Tela de Cliente
	<br/>

	<div>
		
		<%
			Object msg = request.getAttribute("msg");
			if(msg!=null){
				String msgStr = (String)msg;
				out.print(msgStr);
			}
		%>
		
	</div>

	<form method="post" action="cliente">
		Email: <input type="text" value="" name="email" /> <input
			type="submit" value="Save" />
	</form>

<%
List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
int i = 0;
for (Cliente c: lista){
	out.print("ID "+i+" "+c.getEmail()+"<a href='javascript:confirma("+i+")'> Excluir <a/><br/>");
	i++;
}
%>

</body>
</html>