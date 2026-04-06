<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dat ve</title>
</head>
<body>
<h2>Ket qua dat ve</h2>
<p><c:out value="${bookingMessage}" /></p>
<p><a href="<c:url value='/events/search' />">Quay lai tim kiem su kien</a></p>
</body>
</html>

