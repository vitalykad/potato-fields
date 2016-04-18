<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Марсианская целина</title>
</head>
<body>

<h1 align="center"> Фотографии картофельных полей </h1>

<c:forEach items="${photos}" var="photo">
    <div>
        <h4>Сол ${photo.sol}</h4>
    <img src=${photo.url} alt="альтернативный текст" width="500" height="500">
    </div>
</c:forEach>

</body>
</html>