<!DOCTYPE HTML>
<html>
<head>
<title>Getting Started: Serving Web Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<div>
		<form action="/logout" method="post">
			<input type="submit" value="Sign Out" /> <input type="hidden"
				name="_csrf" value="${_csrf.token}" />
		</form>
	</div>
	<div>
		<form method="post">
			<input type="text" name="text" placeholder="Messege,svp" /> <input
				type="text" name="tag" placeholder="Tag,svp" />
			<button type="submit">Ajouter</button>
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</div>
	<div>List messages</div>

	<#list messages as message>
	<div>
		<b>${message.id}</b> <span>${message.text}</span> <i>${message.tag}</i>
		<strong>${message.authorName}</strong>

	</div>
	<#else> No message </#list>
	<div>

		<form method="post" action="filter">
			<input type="text" name="filter" placeholder="Tag" />
			<button type="submit">Filtrer</button>
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>