<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <title>Login Page</title>
</head>
<body>
<form action="authenticate" method="post">
    <div class="form-group">
        <label>CustomerId</label>
        <input type="number" class="form-control" name="cust_id"  placeholder="Enter Id">
        <small id="emailHelp" class="form-text text-muted">We'll never share your Id with anyone else.</small>
    </div>
    <div class="form-group">
        <label>PIN</label>
        <input type="password" class="form-control" name="pin" placeholder="Password">
    </div>

    <button type="submit" class="btn btn-primary">Login</button>
</form>
</body>
</html>
