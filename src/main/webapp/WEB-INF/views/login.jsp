<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dang nhap Portal Nhan su</title>
</head>
<body>
<%@ include file="common/header.jspf" %>

<h2>Dang nhap Mini Portal Nhan su</h2>

<c:if test="${not empty requestScope.errorMessage}">
    <p style="color: red;"><c:out value="${requestScope.errorMessage}" /></p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <label>Username: </label>
        <input type="text" name="username" required />
    </p>
    <p>
        <label>Password: </label>
        <input type="password" name="password" required />
    </p>
    <button type="submit">Dang nhap</button>
</form>

<p>Tai khoan demo: hr_manager/hr123 hoac hr_staff/staff456</p>

<%@ include file="common/footer.jspf" %>
</body>
</html>

