<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script>
        function validate() {
            if ($('#email').val() === '') {
                alert("Required fields empty!");
                return false;
            }
        }
    </script>
</head>
<body>
<form method="post" action="login" >
    <p>Credentials</p>
    <br>
        <#if incorrect??>
            <p style="font-family:verdana,monospace;color: crimson">Unauthorized access request</p>
        </#if>
    <br>
    <div class="form-group">
        <label for="username"> Username:</label>
        <input type="text" class="form-control" id="username" name="username">
        <input type="hidden" value="login" id="act" name="act">
    </div>
    <button type="submit" onclick="return validate();" class="btn btn-default">Submit</button>
</form>
<br>
</body>
</html>