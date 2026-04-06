<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bao cao diem sinh vien</title>
</head>
<body>
<h2>Bao cao diem sinh vien</h2>

<c:if test="${not empty keyword}">
    <p>Tu khoa tim kiem: <c:out value="${keyword}" /></p>
</c:if>

<table border="1" cellpadding="6" cellspacing="0">
    <thead>
    <tr>
        <th>Ma SV</th>
        <th>Ho ten</th>
        <th>Diem</th>
        <th>Xep loai</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reports}" var="item">
        <tr>
            <td><c:out value="${item.studentId}" /></td>
            <td><c:out value="${item.fullName}" /></td>
            <td>${item.score}</td>
            <td>
                <c:choose>
                    <c:when test="${item.score >= 5}">Dat</c:when>
                    <c:otherwise>Khong Dat</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

