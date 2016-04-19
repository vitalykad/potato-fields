<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Марсианская целина</title>
    <style>
        body{
            background-color: orange; /* Цвет фона веб-страницы */
        }
    </style>
</head>
<body>

<h1 align="center"> Фотографии картофельных полей </h1>

<c:forEach items="${photos}" var="photo">
    <div>
        <h4 align="center">Сол ${photo.sol}</h4>
    <img src=${photo.url} width="500" height="500" align="center">
    </div>
</c:forEach>

</body>
</html>