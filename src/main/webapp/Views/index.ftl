<html>
<head><title>Cars</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <style>
        .datatable {
            position: absolute;
            background: #ffcc5a;
            left: 15px;
            height: 200px;
            border-radius: 25px;
        }
        td,th {

            padding: 10px;
        }
        .layer1 {
            position: absolute;
            top: 15px;
            left: 15px;
            line-height: 1px;
            font-size: large;
        }
    </style>

</head>

<body>
<br>

<table class="datatable" >
    <br>
    <div class="layer1">All cars for sale</div>
    <tr>
        <th>Brand</th>   <th>Model</th>   <th>Engine</th>   <th>Body</th>   <th>Color</th>   <th>User</th>
    </tr>
    <#list cars as car>
    <tr>
        <td>${car.brand.name}</td> <td>${car.model}</td>  <td>${car.engine.type}</td> <td>${car.body.name}</td> <td>${car.color}</td> <td>${car.itemId.user.name}</td> <td><img src="images/mercedes.png"/></td>
    </tr>
</#list>
</table>
</body>
</html>