<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Future potato fields</title>
</head>
<body>

<c:forEach items="${photos}" var="photo">
    <img src=${photo.url} alt="альтернативный текст" width="500" height="500">
</c:forEach>

</body>
</html>