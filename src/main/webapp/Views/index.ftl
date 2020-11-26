<html>
<head><title>Cars</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <style>
        .datatable2 {
            left: 15px;
        }
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
<table class="datatable2" >
   <tr>
       <th><button formmethod="get" type="submit" onclick="location.href = 'saveCar';" class="btn btn-primary" >Create Car</button></th>
       <th><button formmethod="post" type="submit" onclick="location.href = 'login?act=unlogin';" class="btn btn-primary" >Unlogin</button></th>
       <th>${Session.user_name}</th>
   </tr>
</table>
<table class="datatable" >
    <br>
    <div class="layer1">All cars for sale</div>
    <br>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Engine</th>
        <th>Body</th>
        <th>Color</th>
        <th>User</th>
        <th>Image</th>
        <th>Image name</th>
    </tr>
    <#list cars as car>
    <tr>
        <td>${car.brand.name}</td>
        <td>${car.model}</td>
        <td>${car.engine.type}</td>
        <td>${car.body.name}</td>
        <td>${car.color}</td>
        <td>${car.itemId.user.name}</td>
        <td><img src="/marketplaceTest/load?name=${car.image}" width="170px" height="100px" alt="beautiful car"/></td>
        <td>${car.image}</td>
        <td>
            <#if Session.user_name??>
                <#if Session.user_id == car.itemId.user.name+"">
                    <button formmethod="get" type="submit" onclick="location.href = 'update';" class="btn btn-primary" >Update Car</button>
                </#if>
            </#if>

        </td>
    </tr>

</#list>
</table>

</body>
</html>