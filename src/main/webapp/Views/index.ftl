<html>
<head><title>Cars</title>

<body>


<table class="datatable">
    <tr>
        <th>Brand</th>  <th>Model</th> <th>Engine</th> <th>Body</th> <th>Color</th>
    </tr>
    <#list cars as car>
    <tr>
        <td>${car.brand.name}</td> <td>${car.model}</td>  <td>${car.engine.type}</td> <td>${car.body.name}</td> <td>${car.color}</td>
    </tr>
</#list>
</table>
</body>
</html>