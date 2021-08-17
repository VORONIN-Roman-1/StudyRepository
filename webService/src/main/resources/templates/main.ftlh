<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<div>
	<@l.logout />
</div>
	<div>
		<form method="post">
			<input type="text" name="text" placeholder="Messege,svp" />
			 <input	type="text" name="tag" placeholder="Tag,svp" />
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

		<form method="get">
			<input type="text" name="filter" value="${filter?ifExists}"  placeholder="Tag" />
			<button type="submit">Filtrer</button>
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
		</form>
	</div>
 <a href="/user"> Edit Users</a>
</@c.page>