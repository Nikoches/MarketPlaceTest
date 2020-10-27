<html>
<head><title>FreeMarker Hello World</title>

<body>


<table class="datatable">
    <tr>
        <th>Model</th>  <th>Color</th>
    </tr>
    <#list users as user>
    <tr>
        <td>${user.model}</td> <td>${user.color}</td>
    </tr>
</#list>
</table>
</body>
</html>