<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Co loi xay ra</title>
</head>
<body>
<%@ include file="common/header.jspf" %>

<h2>Thong bao loi</h2>
<p style="color: #b71c1c;"><c:out value="${errorMessage}" /></p>
<p><a href="<c:url value='/employees' />">Ve danh sach nhan vien</a></p>

<%@ include file="common/footer.jspf" %>
</body>
</html>

