<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Creating Car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<form name="loginForm" method="post" action="saveCar" enctype="multipart/form-data" content="notnull">
    <label for="Brand"> Brand:</label>
    <input type="text" class="form-control" id="brand" name="brand">
    <br>
    <label for="Model"> Model:</label>
    <input type="text" class="form-control" id="model" name="model">
    <br>
    <label for="Engine"> Engine:</label>
    <input type="text" class="form-control" id="engine" name="engine">
    <br>
    <label for="Body"> Body:</label>
    <input type="text" class="form-control" id="body" name="body">
    <br>
    <label for="Color"> Color:</label>
    <input type="text" class="form-control" id="color" name="color">
    <br>
    <br>
    <div class="checkbox">
        <label for="file"> File upload:</label>
        <input type="file" name="file">
    </div>
    <p>  </p>
    <button type="submit"  class="btn btn-default">Submit</button>
</form>
</body>
</html>